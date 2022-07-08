package com.zjl.legou.upload.controller;

import com.zjl.legou.upload.config.FileDfsUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/14 15:24
 */
@RestController
@CrossOrigin
public class FileController {
    @Autowired
    private FileDfsUtil fileDfsUtil;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, headers="content-type=multipart/form-data")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        String result = "";

        try {
            String path = fileDfsUtil.upload(file); //"/group1/M00/00/00/wKjcZF8ekIWAEyMAAABzzes71pI891.jpg"
            if (StringUtils.isEmpty(path)){
                result = "上传失败";
            } else {
                result = path;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "服务器异常";
        }
        return ResponseEntity.ok(result);
    }

    /**
     *
     * @param filePathName "/group1/M00/00/00/wKjcZF8ekIWAEyMAAABzzes71pI891.jpg"
     * @return
     */
    @RequestMapping(value = "/deleteByPath", method = RequestMethod.GET)
    public ResponseEntity<String> deleteByPath(String filePathName){
        fileDfsUtil.deleteFile(filePathName);
        return ResponseEntity.ok("success delete");
    }
}

