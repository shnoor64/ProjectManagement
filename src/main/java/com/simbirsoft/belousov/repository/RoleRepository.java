package com.simbirsoft.belousov.repository;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName();
}
