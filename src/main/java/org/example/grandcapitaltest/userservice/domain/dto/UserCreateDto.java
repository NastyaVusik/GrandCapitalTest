package org.example.grandcapitaltest.userservice.domain.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO for creating new user
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @NotBlank
    @Size(max = 500)
    private String name;

    @NotNull
    @Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{4}", message = "Date must be in the format dd.MM.yyyy")
    private LocalDate dateOfBirth;

    @NotBlank
    @Size(min = 8, max = 500)
    private String password;

    @NotEmpty
    @Email
    private List<String> emails;

    @NotEmpty
    @Pattern(regexp = "\\+?[0-9]{7,15}")
    private List<String> phones;
}
