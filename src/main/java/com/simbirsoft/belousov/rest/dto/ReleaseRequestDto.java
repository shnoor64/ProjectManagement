package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Релиз")
public class ReleaseRequestDto {

    @Schema(description = "ID релиза")
    private int releaseId;

    @Schema(description = "Версия релиза")
    private int version;

    @Schema(description = "Время начала выполнения редиза")
    private LocalDateTime startTimeRelease;

    @Schema(description = "Время окончания выполнения релиза")
    private LocalDateTime endTimeRelease;

    public ReleaseRequestDto(int releaseId, int version, LocalDateTime startTimeRelease, LocalDateTime endTimeRelease) {
        this.releaseId = releaseId;
        this.version = version;
        this.startTimeRelease = startTimeRelease;
        this.endTimeRelease = endTimeRelease;
    }

    public ReleaseRequestDto() {

    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

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
}
