package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class ReleaseMapperTest {
    private ReleaseMapper releaseMapper;
    @BeforeEach
    void prepare() {
        releaseMapper = new ReleaseMapperImpl();
    }
    @Test
    void ReleaseRequestDtoMappingEntity() {
        ReleaseRequestDto releaseRequestDto = new ReleaseRequestDto(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));

        ReleaseEntity releaseEntity = releaseMapper.releaseRequestDtoToEntity(releaseRequestDto);

        Assertions.assertEquals(releaseRequestDto.getReleaseId(), releaseEntity.getReleaseId());
        Assertions.assertEquals(releaseRequestDto.getVersion(), releaseEntity.getVersion());
        Assertions.assertEquals(releaseRequestDto.getStartTimeRelease(), releaseEntity.getStartTimeRelease());
        Assertions.assertEquals(releaseRequestDto.getEndTimeRelease(), releaseEntity.getEndTimeRelease());
    }

    @Test
    void ReleaseEntityMappingResponseDto() {
        ReleaseEntity releaseEntity = new ReleaseEntity(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));

        ReleaseResponseDto releaseResponseDto = releaseMapper.releaseEntityToResponseDto(releaseEntity);

        Assertions.assertEquals(releaseEntity.getReleaseId(), releaseResponseDto.getReleaseId());
        Assertions.assertEquals(releaseEntity.getVersion(), releaseResponseDto.getVersion());
        Assertions.assertEquals(releaseEntity.getStartTimeRelease(), releaseResponseDto.getStartTimeRelease());
        Assertions.assertEquals(releaseEntity.getEndTimeRelease(), releaseResponseDto.getEndTimeRelease());
    }
}

