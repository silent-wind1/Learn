package com.yefeng;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yefeng.pojo.Item;
import com.yefeng.pojo.itemDoc;
import com.yefeng.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@Slf4j
public class DocumentTest {

    private RestHighLevelClient client;
    @Autowired
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        this.client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://localhost:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }

    @Test
    void testAddDocument() throws IOException {
        // 1.根据id查询商品数据
        Item item = itemService.getById(100002644680L);
        // 2.转换为文档类型
        itemDoc itemDTO = BeanUtil.copyProperties(item, itemDoc.class);
        // 3.将ItemDTO转json
        String doc = JSONUtil.toJsonStr(itemDTO);

        // 1.准备Request对象
        IndexRequest request = new IndexRequest("items").id(itemDTO.getId());
        // 2.准备Json文档
        request.source(doc, XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void testGetDocumentById() throws IOException {
        // 1.准备Request对象
        GetRequest request = new GetRequest("items").id("100002644680");
        // 2.发送请求
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 3.获取响应结果中的source
        String json = response.getSourceAsString();

        itemDoc itemDTO = JSONUtil.toBean(json, itemDoc.class);
        System.out.println("itemDoc = " + itemDTO);
    }

    @Test
    void testDeleteDocumentById() throws IOException {
        DeleteRequest request = new DeleteRequest("items", "100002644680");
        client.delete(request, RequestOptions.DEFAULT);
    }

    @Test
    void testUpdateDocument() throws IOException {
        // 1.准备Request
        UpdateRequest request = new UpdateRequest("items", "100002644680");
        // 2.准备请求参数
        request.doc(
                "price", 58800,
                "commentCount", 1
        );
        // 3.发送请求
        client.update(request, RequestOptions.DEFAULT);
    }

    @Test
    void testBulk() throws IOException {
        // 1.创建Request
        BulkRequest request = new BulkRequest();
        // 2.准备请求参数
        request.add(new IndexRequest("items").id("1").source("json doc1", XContentType.JSON));
        request.add(new IndexRequest("items").id("2").source("json doc2", XContentType.JSON));
        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    @Test
    void testLoadItemDocs() throws IOException {
        // 分页查询商品数据
        int pageNo = 1;
        int size = 1000;
        while (true) {
            Page<Item> page = itemService.lambdaQuery().eq(Item::getStatus, 1).page(new Page<Item>(pageNo, size));
            // 非空校验
            List<Item> items = page.getRecords();
            if (CollUtil.isEmpty(items)) {
                return;
            }
            log.info("加载第{}页数据，共{}条", pageNo, items.size());
            // 1.创建Request
            BulkRequest request = new BulkRequest("items");
            // 2.准备参数，添加多个新增的Request
            for (Item item : items) {
                // 2.1.转换为文档类型ItemDTO
                itemDoc itemDTO = BeanUtil.copyProperties(item, itemDoc.class);
                // 2.2.创建新增文档的Request对象
                request.add(new IndexRequest()
                        .id(itemDTO.getId())
                        .source(JSONUtil.toJsonStr(itemDTO), XContentType.JSON));
            }
            // 3.发送请求
            client.bulk(request, RequestOptions.DEFAULT);

            // 翻页
            pageNo++;
        }
    }
}