package com.example.management.entity;

import com.example.management.model.BaseModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "organization")
public class Organization extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "branch_count")
    private Long branchCount;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches = new ArrayList<>();
}
