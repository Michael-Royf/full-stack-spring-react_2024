package com.michael.employeefullstack.controller;

import com.michael.employeefullstack.payload.request.DepartmentRequest;
import com.michael.employeefullstack.payload.response.DepartmentResponse;
import com.michael.employeefullstack.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentRequest), CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable(name = "id") Long departmentId) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId), OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable(name = "id") Long departmentId,
                                                               @RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentId, departmentRequest), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable(name = "id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(String.format("Department with id: %s was deleted", departmentId), OK);
    }
}
