package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import com.simbirsoft.belousov.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag(name = "Управление пользователями")
@RequestMapping("/api/management/users")
@RestController
public class UserController {
    private final UserService userService;
    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить список пользователей")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> results = userService.getAllUsers();
        LOG.log(Level.INFO, "Вызван метод: getUsers");
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить пользователя")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id) {
        UserResponseDto result = userService.getUserById(id);
        LOG.log(Level.INFO, "Вызван метод: getUser");
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить пользователя")
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto result = userService.addUser(requestDto);
        LOG.log(Level.INFO, "Вызван метод: createUser");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> partialUpdateUser(@PathVariable int id,
                                                             @RequestBody UserRequestDto requestDto) {
        UserResponseDto result = userService.updateUser(requestDto, id);
        LOG.log(Level.INFO, "Вызван метод: partialUpdateUser");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialDeleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        LOG.log(Level.INFO, "Вызван метод: partialDeleteUser");
        return ResponseEntity.ok().build();
    }


}
