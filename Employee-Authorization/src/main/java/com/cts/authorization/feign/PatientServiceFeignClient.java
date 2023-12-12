package com.cts.authorization.feign;

import com.cts.authorization.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Patient-Microservice", url = "localhost:5200/patient")
public interface PatientServiceFeignClient {
    @GetMapping(value = "/getPatientLoginDetails/{userName}")
    public User getPatientLoginDetails(@PathVariable String userName);
}
