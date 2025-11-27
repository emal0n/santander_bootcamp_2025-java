package me.dio.mapper;

import me.dio.domain.model.User;
import me.dio.dto.UserRequestDTO;
import me.dio.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAccount(user.getAccount());
        dto.setCard(user.getCard());
        dto.setFeatures(user.getFeatures());
        dto.setNews(user.getNews());
        return dto;
    }

    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAccount(dto.getAccount());
        user.setCard(dto.getCard());
        user.setFeatures(dto.getFeatures());
        user.setNews(dto.getNews());
        return user;
    }
}

