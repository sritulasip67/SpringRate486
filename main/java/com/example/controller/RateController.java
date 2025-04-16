package com.example.controller;

import com.example.dto.RateRequestDTO;
import com.example.dto.RateResponseDTO;
import com.example.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping("/calculate")
    public RateResponseDTO calculate(@RequestBody RateRequestDTO request) {
        return rateService.calculateRate(request);
    }

}
