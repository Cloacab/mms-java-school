package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends AbstractPO{
    @Column(name = "name")
    private String name;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
