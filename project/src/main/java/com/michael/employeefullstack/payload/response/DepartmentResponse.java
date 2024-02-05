package com.michael.employeefullstack.payload.response;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentResponse {
    private Long id;
    private String departmentName;
    private String departmentDescription;
}
