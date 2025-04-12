package com.example.management.service;

import com.example.management.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationDto dto);
    OrganizationDto getOrganizationById(Long id);
    List<OrganizationDto> getAllOrganizations();
    OrganizationDto updateOrganization(Long id, OrganizationDto dto);
    void deleteOrganization(Long id);
}
