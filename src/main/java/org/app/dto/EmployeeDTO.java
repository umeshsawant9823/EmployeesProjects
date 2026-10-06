package org.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Salary is mandatory")
    @Positive(message = "Salary must be greater than zero")
    private Double salary;
    @NotBlank(message = "Department cannot be blank")
    private String department;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email format")
    private String email;


}