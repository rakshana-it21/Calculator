package com.example.calculator.repository;

import com.example.calculator.model.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface Calculationrepo extends JpaRepository<Calculator,Integer> {
}
