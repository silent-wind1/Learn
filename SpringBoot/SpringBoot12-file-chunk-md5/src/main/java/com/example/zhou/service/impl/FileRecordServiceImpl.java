package com.example.zhou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zhou.entity.Archive;
import com.example.zhou.mapper.ArchiveMapper;
import com.example.zhou.service.IFileRecordService;
import org.springframework.stereotype.Service;

/**
 * @author ZhouQuan
 * @desciption 文件记录服务实现类
 * @date 2024/6/10 7:58
 */
@Service
public class FileRecordServiceImpl extends ServiceImpl<ArchiveMapper, Archive> implements IFileRecordService {

}
