package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public class DeletableAbstractPO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Integer id;

    @Column(name = "created_at")
    protected ZonedDateTime createdAt;

    @Column(name = "is_deleted")
    protected Boolean isDeleted;

    public DeletableAbstractPO() {
        this.createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
