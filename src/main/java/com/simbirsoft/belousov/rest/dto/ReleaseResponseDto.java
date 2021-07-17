package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Релиз")
public class ReleaseResponseDto {

    @Schema(description = "Версия релиза")
    private int version;

    @Schema(description = "Время начала выполнения редиза")
    private LocalDateTime startTimeRelease;

    @Schema(description = "Время окончания выполнения релиза")
    private LocalDateTime endTimeRelease;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getStartTimeRelease() {
        return startTimeRelease;
    }

    public void setStartTimeRelease(LocalDateTime startTimeRelease) {
        this.startTimeRelease = startTimeRelease;
    }

    public LocalDateTime getEndTimeRelease() {
        return endTimeRelease;
    }

    public void setEndTimeRelease(LocalDateTime endTimeRelease) {
        this.endTimeRelease = endTimeRelease;
    }

    public ReleaseResponseDto(int version, LocalDateTime startTimeRelease, LocalDateTime endTimeRelease) {
        this.version = version;
        this.startTimeRelease = startTimeRelease;
        this.endTimeRelease = endTimeRelease;
    }
}
