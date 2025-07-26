package com.example.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.lang.Integer;
@Data
@Entity


public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer num1;
    Integer num2;
    Integer res;


    public Calculator(Integer num1, Integer num2, int res) {
      this.num1=num1;
      this.num2=num2;
      this.res=res;
    }

//    public Calculator(Integer id, Integer num1, Integer num2, Integer res) {
//        this.id = id;
//        this.num1 = num1;
//        this.num2 = num2;
//        this.res = res;
//    }

    public Calculator() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }
}
