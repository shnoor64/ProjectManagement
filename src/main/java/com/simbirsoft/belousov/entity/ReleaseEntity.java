package com.simbirsoft.belousov.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "release")
public class ReleaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int releaseId;

    @Column(name = "version")
    private int version;

    @Column(name = "start_time_release")
    private LocalDateTime startTimeRelease;

    @Column(name = "end_time_release")
    private LocalDateTime endTimeRelease;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "releaseId")
    private List <TaskEntity> tasks;


    public ReleaseEntity(int releaseId, int version, LocalDateTime startTimeRelease, LocalDateTime endTimeRelease, List<TaskEntity> releases) {
        this.releaseId = releaseId;
        this.version = version;
        this.startTimeRelease = startTimeRelease;
        this.endTimeRelease = endTimeRelease;
        this.tasks = releases;
    }


    public ReleaseEntity() {

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

    public List<TaskEntity> getReleases() {
        return tasks;
    }

    public void setReleases(List<TaskEntity> releases) {
        this.tasks = releases;
    }
}
