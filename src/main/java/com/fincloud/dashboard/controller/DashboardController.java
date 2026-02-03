package com.fincloud.dashboard.controller;

import com.fincloud.dashboard.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private ProxyService proxyService;

    @GetMapping("/metrics")
    public String getAwsMetrics(@RequestParam String serviceEndpoint) {
        try {
            return proxyService.getServiceData(serviceEndpoint);
        } catch (Exception e) {
            return "Error fetching metrics: " + e.getMessage();
        }
    }
}
