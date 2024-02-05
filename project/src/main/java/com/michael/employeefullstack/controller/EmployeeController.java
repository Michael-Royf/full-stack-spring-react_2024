package com.michael.employeefullstack.controller;

import com.michael.employeefullstack.payload.request.EmployeeRequest;
import com.michael.employeefullstack.payload.response.EmployeeResponse;
import com.michael.employeefullstack.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequest), CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(name = "id") Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable(name = "id") Long employeeId,
                                                           @Valid @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employeeRequest), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(String.format("Employee with id: %s was deleted", employeeId), OK);
    }
}
