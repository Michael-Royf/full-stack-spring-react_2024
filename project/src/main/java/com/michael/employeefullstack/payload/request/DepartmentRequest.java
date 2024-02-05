package com.michael.employeefullstack.payload.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentRequest {
    //TODO validation
    private String departmentName;
    private String departmentDescription;
}
