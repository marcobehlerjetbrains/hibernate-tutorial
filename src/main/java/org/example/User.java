package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;


public class User {

    private Long id;

    private String name;

    private LocalDate birthDate;

    public User() {
    }

    public User(String name, LocalDate birthDate) {
	   this.name = name;
	   this.birthDate = birthDate;
    }

    public Long getId() {
	   return id;
    }

    public void setId(Long id) {
	   this.id = id;
    }

    public String getName() {
	   return name;
    }

    public void setName(String name) {
	   this.name = name;
    }

    public LocalDate getBirthDate() {
	   return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	   this.birthDate = birthDate;
    }

}