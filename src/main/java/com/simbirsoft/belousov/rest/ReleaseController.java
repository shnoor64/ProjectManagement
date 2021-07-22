package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Operation(summary = "Получить список релизов")
    @GetMapping
    public ResponseEntity<List<ReleaseResponseDto>> getReleases() {
        ReleaseResponseDto release1 = new ReleaseResponseDto(3, 15, LocalDateTime.of(2020, Month.APRIL, 18, 8, 0), LocalDateTime.of(2021, Month.FEBRUARY, 18, 8, 0));
        ReleaseResponseDto release2 = new ReleaseResponseDto(4, 17, LocalDateTime.of(2020, Month.MAY, 15, 7, 0), LocalDateTime.of(2020, Month.DECEMBER, 13, 8, 0));


        List<ReleaseResponseDto> results = List.of(release1, release2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить релиз")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> getReleas(@PathVariable int id,
                                                        @RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto release1 = new ReleaseResponseDto(3, 15, LocalDateTime.of(2020, Month.APRIL, 18, 8, 0), LocalDateTime.of(2021, Month.FEBRUARY, 18, 8, 0));
        ReleaseResponseDto release2 = new ReleaseResponseDto(4, 17, LocalDateTime.of(2020, Month.MAY, 15, 7, 0), LocalDateTime.of(2020, Month.DECEMBER, 13, 8, 0));

        //Времянка, перепешу после создания сервиса
        final ReleaseResponseDto[] result = new ReleaseResponseDto[1];
        Stream.of(release1, release2).filter(releaseResponseDto -> releaseResponseDto.getReleaseId() == id).forEach(x -> result[0] = x);
        return ResponseEntity.ok().body(result[0]);
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping
    public ResponseEntity<ReleaseResponseDto> createReleas(@RequestBody ReleaseRequestDto requestDto) {
        return ResponseEntity.ok().body(new ReleaseResponseDto(
                requestDto.getReleaseId(),
                requestDto.getVersion(),
                requestDto.getStartTimeRelease(),
                requestDto.getEndTimeRelease()
        ));
    }

    @Operation(summary = "Обновить релиз")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> partialUpdateReleas(@PathVariable int id,
                                                                  @RequestBody ReleaseRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateReleas(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

}
