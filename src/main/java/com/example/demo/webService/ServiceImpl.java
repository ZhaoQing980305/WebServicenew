package com.example.demo.webService;


import com.example.demo.webService.controller.testInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import java.io.*;


@Component
public class ServiceImpl implements Service {
    @Autowired
    private testInt test;

    @Override
    public String upload(FileSources file) {
        DataHandler handler = file.getHandler();
        InputStream is = null;
        OutputStream os = null;
        try {
            System.out.println("文件开始上传。。。。。。");
            is = handler.getInputStream();
            os = new FileOutputStream("D:/" + file.getFileName() + "."
                    + file.getContentType());
            int n = 0;
            byte[] b = new byte[1024];
            while ((n = is.read(b)) != -1) {
                os.write(b, 0, n);
            }

            os.flush();
            System.out.println("文件上传成功!");
            test.input("D://test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "上传成功！";
    }
}
