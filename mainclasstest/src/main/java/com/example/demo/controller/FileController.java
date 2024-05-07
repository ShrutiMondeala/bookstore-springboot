package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.FileUploadHelper;

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper uploadtest;

    @PostMapping("/upload-file")
    public ResponseEntity<String> upLoadFile(@RequestParam("file") MultipartFile file){


    

       System.out.println(file.getName());
       System.out.println(file.getContentType());
       System.out.println(file.getSize());

       if(!file.getContentType().equals("application/pdf")){
        System.out.println("gere");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong file format");
       }

       boolean test = uploadtest.uploadFile(file);
       if(test){
        return ResponseEntity.ok("done");
       }
       else{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception");
       }
      
    }

}
