package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.mappers.UserMapper;
import com.simbirsoft.belousov.rest.dto.*;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление пользователями")
@RequestMapping("/api/management/users")
@RestController
public class UserController {
    private  final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Operation(summary = "Получить список пользователей")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        UserResponseDto user1 = new UserResponseDto(6, "Oleg", "Belousov", new RoleResponseDto());
        UserResponseDto user2 = new UserResponseDto(1, "Ekaterina", "Dilekeeva", new RoleResponseDto());

        List<UserResponseDto> results = List.of(user1, user2);
//        UserEntity userEntity= userMapper.UserRequestDtoToEntity(new UserRequestDto(6, "Oleg", "Belousov","24342", new RoleRequestDto()));

        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить пользователя")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id,
                                                   @RequestBody UserRequestDto requestDto) {
        UserResponseDto user1 = new UserResponseDto(6, "Oleg", "Belousov", new RoleResponseDto());
        UserResponseDto user2 = new UserResponseDto(1, "Ekaterina", "Dilekeeva", new RoleResponseDto());
        //Времянка, перепешу после создания сервиса
        UserResponseDto result;
        result = Stream.of(user1, user2)
                .filter(userResponseDto -> userResponseDto.getUserId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchException("Пользователь не найден"));
        return ResponseEntity.ok().body(result);
    }

//    @Operation(summary = "Добавить пользователя")
//    @PostMapping
//    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
//        return ResponseEntity.ok().body(new UserResponseDto(
//                requestDto.getUserId(),
//                requestDto.getName(),
//                requestDto.getSurname(),
//                requestDto.getRole()
//        ));
//    }

    @Operation(summary = "Обновить пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> partialUpdateUser(@PathVariable int id,
                                                             @RequestBody UserRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateUser(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

}
