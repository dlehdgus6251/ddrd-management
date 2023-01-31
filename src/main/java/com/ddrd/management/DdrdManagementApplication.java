package com.ddrd.management;

import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DdrdManagementApplication {
    public static void main(String[] args) {

        SpringApplication.run(DdrdManagementApplication.class, args);
    }

}
