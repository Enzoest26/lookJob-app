package com.jobSearch.webSite.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_jobpost", schema = "public")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jpost")
    private Long Id;

    @Column(name = "title_jpost")
    private String title;

    @Column(name = "id_company")
    private int idCompany;

    @Column(name= "direction")
    private String direction;

    @Transient
    private List<Integer> typesJob;

    @Column(name = "content_jpost")
    private String content;

    @Transient
    private List<String> requirements;

}
