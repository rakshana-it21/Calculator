package com.example.calculator.Service;

import com.example.calculator.model.Calculator;
import com.example.calculator.repository.Calculationrepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
@Data

public class Calculation {
@Autowired
   private Calculationrepo calculationrepo;
    public int add(Integer num1, Integer num2) {
        int res=num1+num2;
        Calculator calculator=new Calculator(num1,num2,res);
        calculationrepo.save(calculator);
        return res;
    }

    public List<Calculator> getAllRecords() {

        return calculationrepo.findAll();
    }

    public int calculate(Integer num1,  Integer num2,Integer res) {
        Calculator cal=new Calculator(num1,num2,res);
        calculationrepo.save(cal);
        return res;
    }
}
