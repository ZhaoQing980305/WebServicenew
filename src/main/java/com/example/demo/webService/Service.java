package com.example.demo.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(name = "Service", targetNamespace = "http://www.webService.demo.example.com")//服务名称及命名空间
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public interface Service {

    @WebMethod(operationName = "upload")
    String upload(@WebParam(name = "file") FileSources file);

}
