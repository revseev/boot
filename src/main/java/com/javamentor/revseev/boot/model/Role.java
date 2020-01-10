package com.javamentor.revseev.boot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", nullable = false, unique = true)
    private String type;


    public Role() {
    }

    //TODO  additional constructors if needed
    public Role(String type) {
        this.type = type;
    }

    //TODO Long?
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return getType().equals(role.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
