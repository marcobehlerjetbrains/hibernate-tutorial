package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date")
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

    @Override
    public String toString() {
	   return "User{" +
			 "id=" + id +
			 ", name='" + name + '\'' +
			 ", birthDate=" + birthDate +
			 '}';
    }
}