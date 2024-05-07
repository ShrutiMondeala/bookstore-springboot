package com.example.demo.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    boolean result = false;
    String DIR_PATH = "D:\\learning\\SpringBoot\\VsCodespringboot\\mainclasstest\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile file){
        try{

            // InputStream is = file.getInputStream();
            
            // byte[] output = new byte[is.available()];

            // is.read(output);
            // //output

            // FileOutputStream fos = new FileOutputStream(DIR_PATH+"/"+file.getOriginalFilename())
            // fos.write(output);
        
            // fos.close();
            // fos.flush();

             Files.copy(file.getInputStream(), Paths.get(DIR_PATH+"/"+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        
             result = true ;
                   }
        catch(Exception e){
           
            e.printStackTrace();
        }

        return result;
    }

}
