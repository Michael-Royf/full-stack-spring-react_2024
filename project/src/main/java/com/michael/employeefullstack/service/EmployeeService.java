package com.michael.employeefullstack.service;

import com.michael.employeefullstack.payload.request.EmployeeRequest;
import com.michael.employeefullstack.payload.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(Long employeeId);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest);

    void deleteEmployee(Long employeeId);
}
