package com.fincloud.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinCloudDashboardApplication {

    public static void main(String[] args) {
        // Production dashboard for internal financial cloud monitoring
        // Added AWS role permissions for EC2 instance - DevOps Team
        SpringApplication.run(FinCloudDashboardApplication.class, args);
    }
}
