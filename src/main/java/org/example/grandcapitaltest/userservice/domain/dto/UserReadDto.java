package org.example.grandcapitaltest.userservice.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for reading user
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto {
    @Pattern(regexp = ".*", message = "Invalid name format")
    private String name;

    @Past
    @Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{4}", message = "Date must be in the format dd.MM.yyyy")
    private LocalDate dateOfBirth;

    @Email
    private List<String> emails;

    @Pattern(regexp = "\\+?[0-9]{7,15}")
    private List<String> phones;

    private BigDecimal balance;
}
