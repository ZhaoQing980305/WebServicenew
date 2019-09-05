package com.example.demo.webService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;

public class Client {

    public static void main(String[] args) {
        FileSources fs = new FileSources();
        fs.setFileName("test");
        fs.setContentType("txt");
        //加载文件
        DataSource source = new FileDataSource(new File("D:\\桌面\\testNumber\\test.txt"));
        fs.setHandler(new DataHandler(source));
        try {
            // 接口地址
            String address = "http://localhost:8080/services/Service?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(Service.class);
            // 创建一个代理接口实现
            Service cs = (Service) jaxWsProxyFactoryBean.create();
            // 调用代理接口的方法调用并返回结果
            String result = cs.upload(fs);

            System.out.println("调用服务器成功！");
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
