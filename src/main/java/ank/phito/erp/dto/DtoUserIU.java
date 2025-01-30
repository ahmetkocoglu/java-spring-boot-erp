package ank.phito.erp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoUserIU {
    @NotEmpty(message = "First Name field cannot be left blank!")
    @Min(value = 3 , message = "First Name must be at least 3 characters")
    @Max(value = 100 , message = "The First Name field must be a maximum of 50 characters.")
    private String firstName;

    @NotEmpty(message = "Last Name field cannot be left blank!")
    @Min(value = 3 , message = "Last Name must be at least 3 characters")
    @Max(value = 100 , message = "The Last Name field must be a maximum of 50 characters.")
    private String lastName;

    @NotEmpty(message = "Email field cannot be left blank!")
    @Min(value = 3 , message = "Email must be at least 3 characters")
    @Max(value = 100 , message = "The Email field must be a maximum of 50 characters.")
    private String email;

    @NotEmpty(message = "password field cannot be left blank!")
    @Min(value = 8 , message = "password must be at least 3 characters")
    @Max(value = 100 , message = "The password field must be a maximum of 50 characters.")
    private String password;
}
