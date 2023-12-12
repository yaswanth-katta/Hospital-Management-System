package com.cts.authorization.feign;

import com.cts.authorization.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Employee-Microservice", url = "localhost:5100/employee")
public interface DoctorServiceFeignClient {
    @GetMapping(value = "/getDoctorLoginDetails/{userName}")
    public User getDoctorLoginDetails(@PathVariable String userName);

    @GetMapping(value = "/getEmployeeLoginDetails/{userName}")
    public User getEmployeeLoginDetails(@PathVariable String userName);
}
