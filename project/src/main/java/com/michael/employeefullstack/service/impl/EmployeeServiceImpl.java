package com.michael.employeefullstack.service.impl;

import com.michael.employeefullstack.entity.Employee;
import com.michael.employeefullstack.payload.request.EmployeeRequest;
import com.michael.employeefullstack.payload.response.EmployeeResponse;
import com.michael.employeefullstack.repository.EmployeeRepository;
import com.michael.employeefullstack.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        //TODO: check email
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .build();

        employee = employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long employeeId) {
        return modelMapper.map(findEmployeeInDB(employeeId), EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
        Employee employee = findEmployeeInDB(employeeId);
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee = employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = findEmployeeInDB(employeeId);
        employeeRepository.delete(employee);
    }


    private Employee findEmployeeInDB(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Employee with id %s not found", id)));
    }
}
