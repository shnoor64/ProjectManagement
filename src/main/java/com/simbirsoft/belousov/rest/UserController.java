package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление пользователями")
@RequestMapping("/api/projectManagement")
@RestController
public class UserController {
    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponseDto>> getTasks() {
        UserResponseDto user1 = new UserResponseDto(6,"Oleg", "Belousov", 3);
        UserResponseDto user2 = new UserResponseDto(1,"Ekaterina", "Dilekeeva", 4);

        List<UserResponseDto> results = List.of(user1, user2);
        return ResponseEntity.ok().body(results);
    }
    @Operation(summary = "Добавить пользователя")
    @PostMapping(value = "/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok().body(new UserResponseDto(
                requestDto.getUserId(),
                requestDto.getName(),
                requestDto.getSurname(),
                requestDto.getRole()
        ));
    }

    @Operation(summary = "Обновить пользователя")
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDto> partialUpdateUser(@PathVariable int id,
                                                             @RequestBody UserRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity partialUpdateUser(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
