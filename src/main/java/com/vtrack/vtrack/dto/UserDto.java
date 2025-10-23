package com.vtrack.vtrack.dto;

import com.vtrack.vtrack.validation.MobileNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "First name should not be empty")
    private String firstName;
    @NotNull(message = "Last name should not be empty")
    private String lastName;
    private Integer role;
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Enter Valid mobile")
    @Column(unique = true)
    @MobileNumberValidation
    private String mobile;
    @Email(message = "Email format is incorrect")
    private String email;
}
