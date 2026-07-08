package com.ferhatkocaosmanli.controller.impl;

import com.ferhatkocaosmanli.controller.RestEmplyoeeController;
import com.ferhatkocaosmanli.dto.DtoEmployee;
import com.ferhatkocaosmanli.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl implements RestEmplyoeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list/{id}")
    @Override
    public DtoEmployee findEmplyoeeById(@PathVariable(value = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }
}
