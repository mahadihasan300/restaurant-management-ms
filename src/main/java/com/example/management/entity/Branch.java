package com.example.management.entity;

import com.example.management.model.BaseModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "branch")
@Data
public class Branch extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "org_id")
    private Long orgId;
}
