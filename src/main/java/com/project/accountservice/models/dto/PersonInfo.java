package com.project.accountservice.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PersonInfo {
    @NotBlank(message = "Field name must be required")
    private String name;
    @NotBlank(message = "Field lastname must be required")
    private String lastname;
    @NotBlank(message = "Field documentNumber must be required")
    private String documentNumber;
    @NotBlank(message = "Field mobileNumber must be required")
    private String mobileNumber;
    @NotBlank(message = "Field nationality must be required")
    private String email;
}