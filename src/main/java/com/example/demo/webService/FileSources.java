package com.example.demo.webService;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlRootElement(name = "FileSources")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({FileSources.class})
public class FileSources implements Serializable {

    private static final long serialVersionUID = -5236565563763834569L;

    private int id;
    private String fileName;// 文件名
    private String contentType;// 文件类型
    private DataHandler handler;//大型文件上传所需

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public DataHandler getHandler() {
        return handler;
    }

    public void setHandler(DataHandler handler) {
        this.handler = handler;
    }
}
