package com.bridgelabz.addressbook;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDTO {
    private Long id;

    @NotNull(message = "Name is required")
    @Pattern(regexp = "[A-Za-z ]{2,50}", message = "Name must be 2-50 characters and contain only letters and spaces")
    private String name;

    @NotNull(message = "Street cannot be null")
    @Size(min = 5, max = 100, message = "Street must be between 5 and 100 characters")
    private String street;

    @NotNull(message = "City cannot be null")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;
}