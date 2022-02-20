package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public class AbstractPO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Integer id;

    @Column(name = "created_at")
    protected ZonedDateTime createdAt;

    @Column(name = "version")
    protected Integer version;
}
