package test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.service.ServiceExample;

import java.net.MalformedURLException;
import java.net.URL;

public class CallMethods {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8081/service");
        QName qName = new QName("http://soap.com/", "ServiceExampleImpl");
        Service service = Service.create(url, qName);
        ServiceExample serviceExample = service.getPort(ServiceExample.class);
        System.out.println("PersonById: " + serviceExample.getPersonById(2));


    }
}
