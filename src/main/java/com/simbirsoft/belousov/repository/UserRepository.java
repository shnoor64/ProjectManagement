package com.simbirsoft.belousov.repository;

import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
