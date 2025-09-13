package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Api (tags = "公共接口")
@Slf4j
public class CommonController {
    @Value("${sky.file.upload-dir}")
    private String uploadDir;

    @Value("${sky.file.access-url}")
    private String accessUrl;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) {
        log.info("上传文件：{}", file);
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + extension;
        File dest = new File(uploadDir, File.separator + newFileName);
        try {
            file.transferTo(dest);
            String fileUrl = accessUrl + File.separator + newFileName;
            return Result.success(fileUrl);
        } catch (IOException e) {
            log.error("文件上传失败", e);
            return Result.error(MessageConstant.UPLOAD_FAILED);
        }
    }
}
