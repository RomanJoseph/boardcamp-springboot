package boardcampapi.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GameDTO {
    @NotNull
    @NotBlank
    @Size(max = 255, message = "Name must have a maximum of 255 characters")
    private String name;

    @NotNull
    @NotBlank
    private String image;

    @NotNull
    @Min(value = 0, message = "Stock must be a positive number")
    private Integer stockTotal;
    
    @NotNull
    @Min(value = 0, message = "Price per day must be a positive number")
    private Integer pricePerDay;
}