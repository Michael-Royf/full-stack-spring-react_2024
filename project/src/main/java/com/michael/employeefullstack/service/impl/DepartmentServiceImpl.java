package com.michael.employeefullstack.service.impl;

import com.michael.employeefullstack.entity.Department;
import com.michael.employeefullstack.payload.request.DepartmentRequest;
import com.michael.employeefullstack.payload.response.DepartmentResponse;
import com.michael.employeefullstack.repository.DepartmentRepository;
import com.michael.employeefullstack.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;


    @Override
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .departmentName(departmentRequest.getDepartmentName())
                .departmentDescription(departmentRequest.getDepartmentDescription())
                .build();
        department = departmentRepository.save(department);
        return mapper.map(department, DepartmentResponse.class);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long departmentId) {
        return mapper.map(findDepartmentInDB(departmentId), DepartmentResponse.class);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(department -> mapper.map(department, DepartmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse updateDepartment(Long departmentId, DepartmentRequest departmentRequest) {
        Department department = findDepartmentInDB(departmentId);
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setDepartmentDescription(departmentRequest.getDepartmentDescription());
        department = departmentRepository.save(department);
        return mapper.map(department, DepartmentResponse.class);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = findDepartmentInDB(departmentId);
        departmentRepository.delete(department);
    }

    private Department findDepartmentInDB(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Department with id: %s not found", departmentId)));
    }


}
