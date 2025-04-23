package org.example.grandcapitaltest.userservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * DTO for user authentication
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto {
    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
