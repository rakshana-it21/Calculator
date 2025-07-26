package com.example.calculator.controller;

import com.example.calculator.Service.Calculation;
import com.example.calculator.model.Calculator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500")
public class Calculationcontroller {
    @Autowired
    private Calculation calculation;
    @GetMapping("/datas")
    public List<Calculator> getAllRecords()
    {

        return calculation.getAllRecords();
    }

    @PostMapping("/api/calculate/{num1}/{num2}/{res}")
    int calculate(@PathVariable Integer num1,@PathVariable Integer num2, @PathVariable Integer res)
    {
         return calculation.calculate(num1,num2,res);
    }
}
