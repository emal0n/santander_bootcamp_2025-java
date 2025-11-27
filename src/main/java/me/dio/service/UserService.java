package me.dio.service;

import me.dio.dto.UserRequestDTO;
import me.dio.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO create(UserRequestDTO userToCreate);

    UserResponseDTO update(Long id, UserRequestDTO userToUpdate);

    void delete(Long id);
}
