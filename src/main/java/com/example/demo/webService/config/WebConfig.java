package com.example.demo.webService.config;

import com.example.demo.webService.Service;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@Configuration
public class WebConfig {
    @Autowired
    private Bus bus;

    @Autowired
    Service service;

    /*jax-ws*/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/Service");
        return endpoint;
    }
}
