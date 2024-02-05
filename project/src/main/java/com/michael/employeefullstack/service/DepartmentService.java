package com.michael.employeefullstack.service;

import com.michael.employeefullstack.payload.request.DepartmentRequest;
import com.michael.employeefullstack.payload.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse getDepartmentById(Long departmentId);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse updateDepartment(Long departmentId, DepartmentRequest departmentRequest);

    void deleteDepartment(Long departmentId);
}
