package org.example.grandcapitaltest.userservice.domain.dto;

import lombok.*;

/**
 * Response authentication DTO
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
}

