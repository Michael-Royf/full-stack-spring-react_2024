package com.michael.employeefullstack.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRequest {

    @NotBlank(message = "First name should not be empty")
    @Pattern(regexp = "^(?!\\s)(.*\\S)$", message = "The firstName should not start or end with a space")
    private String firstName;

    @NotBlank(message = "Last name should not be empty")
    @Pattern(regexp = "^(?!\\s)(.*\\S)$", message = "The lastName should not start or end with a space")
    private String lastName;

    @Email
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "Does not match the pattern")
    @NotBlank(message = "Email should not be empty")
    private String email;
}
