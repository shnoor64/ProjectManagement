package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.mappers.UserMapper;
import com.simbirsoft.belousov.rest.dto.*;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.UserService;
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

    private UserService userService;

    @Operation(summary = "Получить список пользователей")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {

        List<UserResponseDto> results = userService.getAllUsers();
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить пользователя")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id) {
        UserResponseDto result = userService.getUserById(id);
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить пользователя")
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto result = userService.addUser(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> partialUpdateUser(@PathVariable int id,
                                                             @RequestBody UserRequestDto requestDto) throws IOException {
        UserResponseDto result = userService.updateUser(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
