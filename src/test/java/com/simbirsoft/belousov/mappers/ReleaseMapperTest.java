package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class ReleaseMapperTest {

    @Test
    void ReleaseRequestDtoMappingEntity() {
        ReleaseMapper releaseMapper = new ReleaseMapperImpl();
        ReleaseRequestDto releaseRequestDto = new ReleaseRequestDto(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));

        ReleaseEntity releaseEntity = releaseMapper.releaseRequestDtoToEntity(releaseRequestDto);

        Assertions.assertEquals(releaseRequestDto.getReleaseId(), releaseEntity.getReleaseId());
        Assertions.assertEquals(releaseRequestDto.getVersion(), releaseEntity.getVersion());
        Assertions.assertEquals(releaseRequestDto.getStartTimeRelease(), releaseEntity.getStartTimeRelease());
        Assertions.assertEquals(releaseRequestDto.getEndTimeRelease(), releaseEntity.getEndTimeRelease());
    }
}
