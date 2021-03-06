package com.simbirsoft.belousov.repository;

import com.simbirsoft.belousov.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>, JpaSpecificationExecutor<TaskEntity> {
    @Query("select t from TaskEntity t where t.releaseId.releaseId=:releaseId and (t.statusTask='BACKLOG' or  t.statusTask='IN_PROGRESS')")
//    @Query("select t from TaskEntity t where t.releaseId.releaseId=:releaseId and t.statusTask in ('BACKLOG','IN_PROGRESS')")
    List<TaskEntity> getAllOutstandingTasksByRelease(int releaseId);

    @Query("select count(t) from TaskEntity t where t.releaseId.releaseId=:releaseId and (t.statusTask='BACKLOG' or  t.statusTask='IN_PROGRESS')")
    int countAllOutstandingTasksByRelease(int releaseId);

    @Query("select count(t) from TaskEntity t where t.projectId.projectId=:projectId and (t.statusTask='BACKLOG' or  t.statusTask='IN_PROGRESS')")
    int countAllNotDoneTasksByProject(int projectId);

}
