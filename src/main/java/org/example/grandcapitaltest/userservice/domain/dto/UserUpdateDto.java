package org.example.grandcapitaltest.userservice.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    @NotNull
    @Email
    private List<String> emails;

    @NotNull
    @Pattern(regexp = "\\+?[0-9]{7,15}")
    private List<String> phones;
}
