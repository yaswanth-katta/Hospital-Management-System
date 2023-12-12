package com.hackathon.patientHackathon.feign;

import com.hackathon.patientHackathon.models.LoginDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Employee-Authorization", url = "localhost:8400/auth")
public interface AuthFeignClient {
    @PostMapping(value = "/addLoginDetalils")
    public LoginDetails addLoginDetails(@RequestBody LoginDetails user);
}
