package com.example.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    private String name;
    private String ownerName;
    private String phoneNumber;
    private String billingAddress;
    private Long branchCount;
    private List<BranchDto> branches;
}
