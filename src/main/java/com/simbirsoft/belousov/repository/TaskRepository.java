package com.simbirsoft.belousov.repository;

import com.simbirsoft.belousov.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    @Query("select t from TaskEntity t where t.releaseId.releaseId=:releaseId and (t.statusTask='BACKLOG' or  t.statusTask='IN_PROGRESS')")
List<TaskEntity> getAllOutstandingTasksByRelease (int releaseId);

    @Query("select count(t) from TaskEntity t where t.releaseId.releaseId=:releaseId and (t.statusTask='BACKLOG' or  t.statusTask='IN_PROGRESS')")
    int countAllOutstandingTasksByRelease (int releaseId);
}
