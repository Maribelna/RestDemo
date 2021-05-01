package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.Objects;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Integer age;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}