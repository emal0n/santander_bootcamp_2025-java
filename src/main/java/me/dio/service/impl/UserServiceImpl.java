package me.dio.service.impl;

import me.dio.domain.exception.AccountAlreadyExistsException;
import me.dio.domain.exception.UserNotFoundException;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.dto.UserRequestDTO;
import me.dio.dto.UserResponseDTO;
import me.dio.mapper.UserMapper;
import me.dio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        logger.info("Buscando usuário com ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        logger.info("Usuário encontrado: {}", user.getName());
        return userMapper.toResponseDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        logger.info("Buscando todos os usuários");
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponseDTO create(UserRequestDTO userToCreate) {
        logger.info("Criando novo usuário: {}", userToCreate.getName());
        
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            logger.warn("Tentativa de criar usuário com número de conta já existente: {}", 
                    userToCreate.getAccount().getNumber());
            throw new AccountAlreadyExistsException(userToCreate.getAccount().getNumber());
        }
        
        User user = userMapper.toEntity(userToCreate);
        User savedUser = userRepository.save(user);
        logger.info("Usuário criado com sucesso. ID: {}", savedUser.getId());
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO userToUpdate) {
        logger.info("Atualizando usuário com ID: {}", id);
        
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        
        // Verifica se o número da conta está sendo alterado e se já existe
        if (!existingUser.getAccount().getNumber().equals(userToUpdate.getAccount().getNumber()) 
                && userRepository.existsByAccountNumber(userToUpdate.getAccount().getNumber())) {
            logger.warn("Tentativa de atualizar para número de conta já existente: {}", 
                    userToUpdate.getAccount().getNumber());
            throw new AccountAlreadyExistsException(userToUpdate.getAccount().getNumber());
        }
        
        existingUser.setName(userToUpdate.getName());
        existingUser.setAccount(userToUpdate.getAccount());
        existingUser.setCard(userToUpdate.getCard());
        existingUser.setFeatures(userToUpdate.getFeatures());
        existingUser.setNews(userToUpdate.getNews());
        
        User updatedUser = userRepository.save(existingUser);
        logger.info("Usuário atualizado com sucesso. ID: {}", updatedUser.getId());
        return userMapper.toResponseDTO(updatedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        logger.info("Deletando usuário com ID: {}", id);
        
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        
        userRepository.deleteById(id);
        logger.info("Usuário deletado com sucesso. ID: {}", id);
    }
}
