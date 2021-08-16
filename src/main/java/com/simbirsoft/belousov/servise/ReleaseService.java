package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;

import java.util.List;

public interface ReleaseService {

    /**
     * Метод позволяет получить все релизы
     *
     * @return List<ReleaseResponseDto> - лист релизов
     */
    List<ReleaseResponseDto> getAllReleases();

    /**
     * Метод позволяет получить релиз по id
     *
     * @param id - id релиза
     * @return ReleaseResponseDto - искомый релиз
     */
    ReleaseResponseDto getReleaseById(int id);

    /**
     * Метод позволяет добавить релиз
     *
     * @param releaseRequestDto - добавляемый релиз,
     * @return ReleaseResponseDto -добавленный релиз
     */
    ReleaseResponseDto addRelease(ReleaseRequestDto releaseRequestDto);

    /**
     * Метод позволяет обновить релиз
     *
     * @param releaseRequestDto - релиз для обновления,
     * @param id- id релиза
     * @return ReleaseResponseDto -обновленный релиз
     */
    ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto, int id);

    /**
     * Метод позволяет удалить релиз
     *
     * @param id- id релиза
     */
    void deleteRelease(int id);


}
