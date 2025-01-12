package org.example.library.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ZewnetrzneAPI", url = "http://localhost:8081")
public interface ExternalServiceClient {

    @GetMapping("/info/{type}")
    String getGeneralInfo(@PathVariable String type);
}
