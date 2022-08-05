package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


@Entity
@Table(name = "USERS")
public class User {
    private Long id;

    private String name;
    private LocalDate birthDate;

    public User() {
	   // this form used by Hibernate
    }

    public User(String name,LocalDate birthDate) {
	   // for application use, to create new events
	   this.name = name;
	   this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
	   return id;
    }

    private void setId(Long id) {
	   this.id = id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTH_DATE")
    public LocalDate getBirthDate() {
	   return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	   this.birthDate = birthDate;
    }

    public String getName() {
	   return name;
    }

    public void setName(String name) {
	   this.name = name;
    }
}

