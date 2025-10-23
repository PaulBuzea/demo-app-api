package com.example.demo.repository;

import com.example.demo.model.entity.AbsenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<AbsenceEntity, Long> {
}
