package com.example.management.dto;

import lombok.Data;

@Data
public class BranchDto {
    private Long id;
    private String firstName;
    private String lastName;

    public BranchDto() {}

    public BranchDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
}

