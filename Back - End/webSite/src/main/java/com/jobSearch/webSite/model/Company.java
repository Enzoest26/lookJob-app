package com.jobSearch.webSite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "a")
public class Company {
    @Id
    @Column(name = "id_comp")
    private Long Id;

    @Column(name = "name_comp")
    private String name;


}
