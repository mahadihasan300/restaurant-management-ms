package com.example.management.controller;

import com.example.management.dto.OrganizationDto;
import com.example.management.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> create(@RequestBody OrganizationDto dto) {
        return new ResponseEntity<>(organizationService.createOrganization(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAll() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> update(@PathVariable Long id, @RequestBody OrganizationDto dto) {
        return ResponseEntity.ok(organizationService.updateOrganization(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}

