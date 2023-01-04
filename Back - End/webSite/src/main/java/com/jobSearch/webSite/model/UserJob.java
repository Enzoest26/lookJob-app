package com.jobSearch.webSite.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tb_userjob", schema = "public")
public class UserJob {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "lastname_user")
    private String lastName;
    @Column(name = "age_user")
    private int age;

    @Transient
    private List<Integer> idJobCategories;
}
