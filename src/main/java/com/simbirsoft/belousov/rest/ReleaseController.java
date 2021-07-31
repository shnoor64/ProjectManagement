package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление релизами")
@RequestMapping("/api/management/releases")
@RestController
public class ReleaseController {
    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Получить список редизов")
    @GetMapping
    public ResponseEntity<List<ReleaseResponseDto>> getReleases() {

        List<ReleaseResponseDto> results = releaseService.getAllReleases();
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить релиз")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> getRelease(@PathVariable int id) {
        ReleaseResponseDto result = releaseService.getReleaseById(id);
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить релиз")
    @PostMapping
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto result = releaseService.addRelease(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить релиз")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> partialUpdateRelease(@PathVariable int id,
                                                                   @RequestBody ReleaseRequestDto requestDto) throws IOException {
        ReleaseResponseDto result = releaseService.updateRelease(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateRelease(@PathVariable int id) {
        releaseService.deleteRelease(id);
        return ResponseEntity.ok().build();
    }


}
