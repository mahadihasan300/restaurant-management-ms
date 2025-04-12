package com.example.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {
    private Long id;
    private String name;
    private String location;
    private String phoneNumber;
    private Long organizationId;
}

