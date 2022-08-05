package com.peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="users" )
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details details;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;




}
