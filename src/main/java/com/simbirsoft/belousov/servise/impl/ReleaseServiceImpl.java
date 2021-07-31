package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.mappers.ReleaseMapperImpl;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    private final ReleaseRepository releaseRepository;
    private final ReleaseMapperImpl releaseMapper;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository, ReleaseMapperImpl releaseMapper) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }

    @Transactional
    @Override
    public List<ReleaseResponseDto> getAllReleases() {
        List<ReleaseResponseDto> releaseResponseDtoList = new ArrayList<>();
        List<ReleaseEntity> releaseEntityList = releaseRepository.findAll();
        return releaseEntityList
                .stream()
                .map(releaseEntity -> releaseMapper.releaseEntityToResponseDto(releaseEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public ReleaseResponseDto getReleaseById(int id) {
        ReleaseEntity releaseEntity = releaseRepository.findById(id).orElseThrow(() -> new NoSuchException("Релиз не найден"));
        return releaseMapper.releaseEntityToResponseDto(releaseEntity);
    }

    @Transactional
    @Override
    public ReleaseResponseDto addRelease(ReleaseRequestDto releaseRequestDto) {
        ReleaseEntity releaseEntity = releaseMapper.releaseRequestDtoToEntity(releaseRequestDto);
        releaseRepository.save(releaseEntity);
        return releaseMapper.releaseEntityToResponseDto(releaseEntity);
    }

    @Transactional
    @Override
    public ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto, int id) {
        ReleaseEntity releaseEntity = releaseRepository.findById(id).orElseThrow(() -> new NoSuchException("Релиз не найден"));
        releaseEntity = releaseMapper.releaseRequestDtoToEntity(releaseRequestDto);
        releaseRepository.save(releaseEntity);
        return releaseMapper.releaseEntityToResponseDto(releaseEntity);
    }

    @Transactional
    @Override
    public void deleteRelease(int id) {
        ReleaseEntity releaseEntity = releaseRepository.findById(id).orElseThrow(() -> new NoSuchException("Релиз не найден"));
        releaseRepository.delete(releaseEntity);
    }
}