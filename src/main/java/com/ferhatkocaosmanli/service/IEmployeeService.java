package com.ferhatkocaosmanli.service;

import com.ferhatkocaosmanli.dto.DtoEmployee;
import com.ferhatkocaosmanli.model.Employee;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);

}
