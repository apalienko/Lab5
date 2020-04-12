package test;

import javax.xml.ws.Endpoint;

import com.service.ServiceExampleImpl;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/service", new ServiceExampleImpl());
    }
}
