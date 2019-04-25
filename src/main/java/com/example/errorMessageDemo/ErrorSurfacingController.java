package com.example.errorMessageDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo/example/v0")
public class ErrorSurfacingController {
    private RestTemplate rest;

    @Autowired
    public ErrorSurfacingController(RestTemplate rest) {
        this.rest = rest;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity findLaunchMetric() {
        return rest.getForEntity("http://localhost:8085/my/backend/service", Object.class);
    }
}
