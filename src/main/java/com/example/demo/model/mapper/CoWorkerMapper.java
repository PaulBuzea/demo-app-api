package com.example.demo.model.mapper;

import com.example.demo.model.dto.CoWorkerDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.entity.AbsenceEntity;
import org.springframework.stereotype.Service;

@Service
public class CoWorkerMapper {

    public CoWorkerDto toDto(AbsenceEntity entity){
        CoWorkerDto coWorkerDto = new CoWorkerDto();

        coWorkerDto.setId(entity.getId());
        coWorkerDto.setFirstName(entity.getFirstName());
        coWorkerDto.setLastName(entity.getLastName());
        coWorkerDto.setStartDate(entity.getStartDate());
        coWorkerDto.setEndDate(entity.getEndDate());
        coWorkerDto.setFeedback(entity.getFeedback());
        
        return coWorkerDto;
    }

    public AbsenceEntity toEntity(CoWorkerDto request) {
        AbsenceEntity absenceEntity = new AbsenceEntity();

        absenceEntity.setId(request.getId());
        absenceEntity.setFirstName(request.getFirstName());
        absenceEntity.setLastName(request.getLastName());
        absenceEntity.setStartDate(request.getStartDate());
        absenceEntity.setEndDate(request.getEndDate());
        absenceEntity.setFeedback(request.getFeedback());

        return absenceEntity;
    }

}
