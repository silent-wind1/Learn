package com.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.UUID;

@Service
public class AsyncService {
    //  告诉Spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
        System.out.println("数据处理总.....");
    }
//    @Override
//    public AjaxResult<Void> insertByAddBo(MultipartFile file) {
//        //获取文件名
//        String strDateFormat = "yyyy-MM-dd";
//        SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//        // 获取文件名, 为空生成8位UUID作为文件名
//        String originalFilename = Optional.ofNullable(file.getOriginalFilename()).orElse(UUID.randomUUID().toString().substring(0, 8));
//        long fileSize = file.getSize();
//        log.info("com.ruoyi.system.service.impl.SysFilesServiceImpl.insertByAddBo: fileName = {}", originalFilename);
//        //获取文件前缀名
//        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));
//        //获取文件后缀名
//        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
//        // 生成文件名别
//        String alias = dateFormat.format(new Date()) + "-" + UUID.randomUUID().toString().substring(0, 8);
//        //指定本地文件夹存储图片，写到需要保存的目录下
//        String filePath = RuoYiConfig.getProfile() + alias + suffixName;
//        String downloadUrl = localhost + "profile/" + alias + suffixName;
//        log.info("com.ruoyi.system.service.impl.SysFilesServiceImpl.insertByAddBo: filePath = {}", filePath);
//        try {
//            //将图片保存到static文件夹里
//            file.transferTo(new File(filePath));
//            // 保存数据
//            SysFiles sysFiles = new SysFiles();
//            sysFiles.setFileName(name);
//            sysFiles.setFileAlias(alias);
//            sysFiles.setFilePath(filePath);
//            sysFiles.setFileSize(fileSize);
//            sysFiles.setFileType(suffixName);
//            sysFiles.setFileStatus(1);
//            sysFiles.setDownloadUrl(downloadUrl);
//            this.save(sysFiles);
//            //返回提示信息
//            return new AjaxResult(0, "上传成功", "");
//        } catch (Exception e) {
//            log.error("com.ruoyi.system.service.impl.SysFilesServiceImpl.insertByAddBo: 上传失败", e);
//            return new AjaxResult<>(-1, "上传失败");
//        }
//    }

//    @Override
//    public AjaxResult<Void> download(ServletOutputStream outputStream, String filePath) {
//        // 1. 根据传入的文件路径获取文件
//        File file = new File(filePath);
//
//        if (!file.exists()) {
//            // 如果文件不存在，返回404
//            return AjaxResult.error();
//        }
//
//        // 2. 设置响应头，指定文件下载类型
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());  // 设置文件名
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);  // 设置文件的类型为二进制流
//
//        // 3. 将文件内容读取到字节数组中
//        byte[] fileBytes = new byte[1024];  // 读取文件流为字节数组
//        try {
//            InputStream fileInputStream = Files.newInputStream(file.toPath());
//            fileBytes = StreamUtils.copyToByteArray(fileInputStream);
//        } catch (IOException e) {
//            log.error("com.ruoyi.system.service.impl.SysFilesServiceImpl.download: 读取文件失败", e);
//        }
//        // 4. 返回文件内容作为响应
//        return new AjaxResult(0, "", fileBytes);
//    }
}
