package com.example.demo.service;

import com.example.demo.model.dto.CoWorkerDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.entity.AbsenceEntity;
import com.example.demo.model.mapper.CoWorkerMapper;
import com.example.demo.model.mapper.ManagerMapper;
import com.example.demo.repository.AbsenceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final ManagerMapper managerMapper;
    private final CoWorkerMapper coWorkerMapper;

    @Transactional
    public AbsenceEntity getAbsenceById(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    @Transactional
    public AbsenceEntity createAbsence(AbsenceEntity request) {
        return absenceRepository.save(request);
    }

    @Transactional
    public List<ManagerDto> getAllAbsencesManager() {
        return absenceRepository.findAll()
                .stream()
                .map(managerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ManagerDto updateAbsenceManager(ManagerDto request) {
        AbsenceEntity responseEntity = absenceRepository.save(managerMapper.toEntity(request));
        return managerMapper.toDto(responseEntity);
    }

    @Transactional
    public List<CoWorkerDto> getAllAbsencesCoWorker() {
        return absenceRepository.findAll()
                .stream()
                .map(coWorkerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CoWorkerDto updateAbsenceCoWorker(CoWorkerDto request) {
        AbsenceEntity currentEntity = absenceRepository.findById(request.getId()).orElse(null);
        AbsenceEntity requestEntity = coWorkerMapper.toEntity(request);

        // Set additional fields, which are not visible for co-worker
        if(currentEntity.getReason() != null) {
            requestEntity.setReason(currentEntity.getReason());
        }
        if(currentEntity.getComments() != null) {
            requestEntity.setComments(currentEntity.getComments());
        }

        return coWorkerMapper.toDto(absenceRepository.save(requestEntity));
    }

}