package com.example.management.service.impl;

import com.example.management.dto.OrganizationDto;
import com.example.management.entity.Organization;
import com.example.management.exception.ResourceNotFoundException;
import com.example.management.repository.OrganizationRepository;
import com.example.management.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    private OrganizationDto mapToDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getOwnerName(),
                organization.getPhoneNumber(),
                organization.getBillingAddress(),
                organization.getBranchCount()
        );
    }

    private Organization mapToEntity(OrganizationDto dto) {
        Organization organization = new Organization();
        organization.setId(dto.getId());
        organization.setName(dto.getName());
        organization.setOwnerName(dto.getOwnerName());
        organization.setPhoneNumber(dto.getPhoneNumber());
        organization.setBillingAddress(dto.getBillingAddress());
        organization.setBranchCount(dto.getBranchCount());
        return organization;
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
        return organizationRepository.findAll()
                .stream().map(this::mapToDto)
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

        Organization updated = organizationRepository.save(org);
        return mapToDto(updated);
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}

