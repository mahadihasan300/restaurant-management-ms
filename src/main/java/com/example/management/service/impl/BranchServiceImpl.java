package com.example.management.service.impl;

import com.example.management.entity.Branch;
import com.example.management.dto.BranchDto;
import com.example.management.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.management.repository.BranchRepository;
import com.example.management.service.BranchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    private BranchDto mapToDto(Branch branch) {
        return new BranchDto(branch.getId(), branch.getFirstName(), branch.getLastName());
    }

    private Branch mapToEntity(BranchDto dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setFirstName(dto.getFirstName());
        branch.setLastName(dto.getLastName());
        return branch;
    }

    @Override
    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch = mapToEntity(branchDto);
        Branch saved = branchRepository.save(branch);
        return mapToDto(saved);
    }

    @Override
    public BranchDto getBranchById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with ID: " + id));
        return mapToDto(branch);
    }

    @Override
    public List<BranchDto> getAllBranches() {
        return branchRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with ID: "+ id));

        branch.setFirstName(branchDto.getFirstName());
        branch.setLastName(branchDto.getLastName());

        Branch updated = branchRepository.save(branch);
        return mapToDto(updated);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}

