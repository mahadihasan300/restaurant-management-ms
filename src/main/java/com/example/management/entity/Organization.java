package com.example.management.entity;

import com.example.management.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

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
}
