package com.example.demo.service;

import com.example.demo.model.AbsenceEntity;
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

    @Transactional
    public AbsenceEntity createAbsence(AbsenceEntity request) {
        return absenceRepository.save(request);
    }

    @Transactional
    public List<AbsenceEntity> getAllAbsences() {
        return absenceRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional
    public AbsenceEntity updateAbsence(AbsenceEntity request) {
        return absenceRepository.save(request);
    }

}