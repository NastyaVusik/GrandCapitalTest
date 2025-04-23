package org.example.grandcapitaltest.userservice.mapper;

import org.example.grandcapitaltest.userservice.domain.dto.UserCreateDto;
import org.example.grandcapitaltest.userservice.domain.dto.UserReadDto;
import org.example.grandcapitaltest.userservice.domain.dto.UserUpdateDto;
import org.example.grandcapitaltest.userservice.domain.entity.EmailData;
import org.example.grandcapitaltest.userservice.domain.entity.PhoneData;
import org.example.grandcapitaltest.userservice.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserReadDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "emails", expression = "java(toEmailDataList(dto.getEmails(), user))")
    @Mapping(target = "phones", expression = "java(toPhoneDataList(dto.getPhones(), user))")
    User toEntity(UserCreateDto dto);

    default List<EmailData> toEmailDataList(List<String> emails, User user) {
        return emails.stream()
                .map(e -> EmailData.builder().email(e).user(user).build())
                .toList();
    }

    default List<PhoneData> toPhoneDataList(List<String> phones, User user) {
        return phones.stream()
                .map(p -> PhoneData.builder().phone(p).user(user).build())
                .toList();
    }

    @Mapping(target = "emails", expression = "java(toEmailDataList(dto.getEmails(), user))")
    @Mapping(target = "phones", expression = "java(toPhoneDataList(dto.getPhones(), user))")
    void updateUserFromDto(UserUpdateDto dto, @MappingTarget User user);
}