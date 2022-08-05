package com.peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    List<User > users;

    public void addUserToCompany(User user){
        if (users==null){
            users=new ArrayList<>();
        }
        users.add(user);
        user.setCompany(this);
    }

}
