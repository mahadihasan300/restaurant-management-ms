package com.example.management.service.impl;

import com.example.management.dto.BranchDto;
import com.example.management.dto.OrganizationDto;
import com.example.management.entity.Branch;
import com.example.management.entity.Organization;
import com.example.management.exception.ResourceNotFoundException;
import com.example.management.repository.BranchRepository;
import com.example.management.repository.OrganizationRepository;
import com.example.management.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final BranchRepository branchRepository; // Needed if you want to do extra logic

    public OrganizationServiceImpl(OrganizationRepository organizationRepository,
                                   BranchRepository branchRepository) {
        this.organizationRepository = organizationRepository;
        this.branchRepository = branchRepository;
    }

    private OrganizationDto mapToDto(Organization org) {
        List<BranchDto> branchDtos = org.getBranches().stream().map(branch -> {
            BranchDto dto = new BranchDto();
            dto.setId(branch.getId());
            dto.setName(branch.getName());
            dto.setLocation(branch.getLocation());
            dto.setPhoneNumber(branch.getPhoneNumber());
            dto.setOrganizationId(org.getId());
            return dto;
        }).collect(Collectors.toList());

        return new OrganizationDto(
                org.getId(),
                org.getName(),
                org.getOwnerName(),
                org.getPhoneNumber(),
                org.getBillingAddress(),
                org.getBranchCount(),
                branchDtos
        );
    }

    private Organization mapToEntity(OrganizationDto dto) {
        Organization org = new Organization();
        org.setId(dto.getId());
        org.setName(dto.getName());
        org.setOwnerName(dto.getOwnerName());
        org.setPhoneNumber(dto.getPhoneNumber());
        org.setBillingAddress(dto.getBillingAddress());
        org.setBranchCount(dto.getBranchCount());

        // Optional: if creating with branches
        if (dto.getBranches() != null) {
            List<Branch> branches = dto.getBranches().stream().map(branchDto -> {
                Branch branch = new Branch();
                branch.setName(branchDto.getName());
                branch.setLocation(branchDto.getLocation());
                branch.setPhoneNumber(branchDto.getPhoneNumber());
                branch.setOrganization(org); // set owning side
                return branch;
            }).collect(Collectors.toList());
            org.setBranches(branches);
        }

        return org;
    }

    @Override
    public OrganizationDto createOrganization(OrganizationDto dto) {
        Organization org = mapToEntity(dto);
        Organization saved = organizationRepository.save(org);
        return mapToDto(saved);
    }

    @Override
    public OrganizationDto getOrganizationById(Long id) {
        Organization org = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with ID: " + id));
        return mapToDto(org);
    }

    @Override
    public List<OrganizationDto> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDto updateOrganization(Long id, OrganizationDto dto) {
        Organization org = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with ID: " + id));

        org.setName(dto.getName());
        org.setOwnerName(dto.getOwnerName());
        org.setPhoneNumber(dto.getPhoneNumber());
        org.setBillingAddress(dto.getBillingAddress());
        org.setBranchCount(dto.getBranchCount());

        // Optional: Update branches logic (depends on use case)

        Organization updated = organizationRepository.save(org);
        return mapToDto(updated);
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}

