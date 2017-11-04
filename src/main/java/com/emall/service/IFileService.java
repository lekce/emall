package com.emall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/11/2.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
