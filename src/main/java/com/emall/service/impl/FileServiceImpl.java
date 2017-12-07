package com.emall.service.impl;

import com.emall.service.IFileService;
import com.emall.util.FTPUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/2.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);

        File fileDir = new File((path));
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            // 文件已经上传成功

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            // 将targetFile上传到FTP服务器上

            // 上传完后删除upload目录下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return  null;
        }

        //A:abc.jpg
        //B:abc.jpg
        return targetFile.getName();
    }

    public static void main(String[] args) {
        String fileName = "abc.jpg";
        System.out.println( fileName.substring(fileName.lastIndexOf(".") + 1));
    }
}
