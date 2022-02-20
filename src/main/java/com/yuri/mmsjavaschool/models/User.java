package com.yuri.mmsjavaschool.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User extends AbstractPO {
    @Column(name = "username", unique = true)
    String username;

    @Column(name = "password")
    String password;

    @Email
    @Column(name = "email", unique = true)
    String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
