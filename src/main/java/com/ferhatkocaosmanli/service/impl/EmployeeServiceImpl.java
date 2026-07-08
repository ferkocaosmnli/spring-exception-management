package com.ferhatkocaosmanli.service.impl;

import com.ferhatkocaosmanli.dto.DtoDepartment;
import com.ferhatkocaosmanli.dto.DtoEmployee;
import com.ferhatkocaosmanli.exception.BaseException;
import com.ferhatkocaosmanli.exception.ErrorMessage;
import com.ferhatkocaosmanli.exception.MessageType;
import com.ferhatkocaosmanli.model.Department;
import com.ferhatkocaosmanli.model.Employee;
import com.ferhatkocaosmanli.repository.EmployeeRepository;
import com.ferhatkocaosmanli.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
