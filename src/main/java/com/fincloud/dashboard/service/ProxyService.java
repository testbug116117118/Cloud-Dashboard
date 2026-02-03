package com.fincloud.dashboard.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ProxyService {
    
    private final HttpClient httpClient = HttpClient.newBuilder().build();
    
    // Proxy AWS service endpoints to fetch cloud metrics
    public String getServiceData(String serviceEndpoint) throws IOException {
        if (!serviceEndpoint.startsWith("https://api.aws.")) {
            throw new IllegalArgumentException("Invalid AWS service endpoint");
        }
        
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serviceEndpoint))
                    .header("X-API-Key", System.getenv("AWS_API_KEY"))
                    .GET()
                    .build();
            
            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());
            
            // Log access for monitoring
            System.out.println("Proxied request to: " + serviceEndpoint);
            
            return response.body();
        } catch (Exception e) {
            throw new IOException("Failed to fetch data: " + e.getMessage());
        }
    }
}
