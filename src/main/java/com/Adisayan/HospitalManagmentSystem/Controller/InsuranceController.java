package com.Adisayan.HospitalManagmentSystem.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class InsuranceController {

    @PostMapping("/insurance")
    public void createInsurance() {

    }

    @GetMapping("/insurance")
    public void getinsurance() {

    }

    @GetMapping("/insurance/{id}")
    public void getInsuranceById(@PathVariable long id) {

    }

    @PutMapping("/insurance/{id}")
    public void putInsurance(@PathVariable long id) {

    }

    @DeleteMapping("/insurance/{id}")
    public void deleteInsurance(@PathVariable long id) {

    }
}
