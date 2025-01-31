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
public class DtoMovementIU {
    @NotEmpty(message = "Title field cannot be left blank!")
    @Min(value = 3 , message = "Title must be at least 3 characters")
    @Max(value = 10 , message = "The title field must be a maximum of 50 characters.")
    private String title;

    @NotEmpty(message = "Title field cannot be left blank!")
    @Min(value = 3 , message = "Title must be at least 3 characters")
    @Max(value = 10 , message = "The title field must be a maximum of 50 characters.")
    private String description;
}
