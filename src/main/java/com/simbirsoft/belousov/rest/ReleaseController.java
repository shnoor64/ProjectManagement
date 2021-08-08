package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.servise.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag(name = "Управление релизами")
@RequestMapping("/api/management/releases")
@RestController
public class ReleaseController {
    private final ReleaseService releaseService;
    private static final Logger LOG = Logger.getLogger(ReleaseController.class.getName());

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Получить список редизов")
    @GetMapping
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<List<ReleaseResponseDto>> getReleases() {

        List<ReleaseResponseDto> results = releaseService.getAllReleases();
        LOG.log(Level.INFO, "Вызван метод: getReleases");
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить релиз")
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<ReleaseResponseDto> getRelease(@PathVariable int id) {
        ReleaseResponseDto result = releaseService.getReleaseById(id);
        LOG.log(Level.INFO, "Вызван метод: getRelease");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto result = releaseService.addRelease(requestDto);
        LOG.log(Level.INFO, "Вызван метод: createRelease");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить релиз")
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<ReleaseResponseDto> partialUpdateRelease(@PathVariable int id,
                                                                   @RequestBody ReleaseRequestDto requestDto) throws IOException {
        ReleaseResponseDto result = releaseService.updateRelease(requestDto, id);
        LOG.log(Level.INFO, "Вызван метод: partialUpdateRelease");
        throw new IOException();
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity partialDeleteRelease(@PathVariable int id) {
        releaseService.deleteRelease(id);
        LOG.log(Level.INFO, "Вызван метод: partialDeleteRelease");
        return ResponseEntity.ok().build();
    }


}
