package com.tpflug.java;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
      String httpPort = System.getenv("HTTP_PORT");
      int servicePort = (httpPort != null) ? Integer.parseInt(httpPort) : 8080;
      SpringApplication app = new SpringApplication(DemoApplication.class);
      app.setDefaultProperties(Collections.singletonMap("server.port", servicePort));
      app.run(args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
}
