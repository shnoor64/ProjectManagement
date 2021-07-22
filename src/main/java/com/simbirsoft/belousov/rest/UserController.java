package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление пользователями")
@RequestMapping("/api/management")
@RestController
public class UserController {
    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        UserResponseDto user1 = new UserResponseDto(6, "Oleg", "Belousov", 3);
        UserResponseDto user2 = new UserResponseDto(1, "Ekaterina", "Dilekeeva", 4);

        List<UserResponseDto> results = List.of(user1, user2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить пользователя")
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id,
                                                   @RequestBody UserRequestDto requestDto) {
        UserResponseDto user1 = new UserResponseDto(6, "Oleg", "Belousov", 3);
        UserResponseDto user2 = new UserResponseDto(1, "Ekaterina", "Dilekeeva", 4);
        //Времянка, перепешу после создания сервиса
        final UserResponseDto[] result = new UserResponseDto[1];
        Stream.of(user1, user2).filter(userResponseDto -> userResponseDto.getUserId() == id).forEach(x -> result[0] = x);
        return ResponseEntity.ok().body(result[0]);
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

}
