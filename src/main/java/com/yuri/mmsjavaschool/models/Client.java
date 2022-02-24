package com.yuri.mmsjavaschool.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class Client extends AbstractPO {
    @Column(name = "username", unique = true)
    String username;

    @Column(name = "password")
    String password;

    @Email
    @Column(name = "email", unique = true)
    String email;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "client")
    private Set<Address> addresses;
    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
