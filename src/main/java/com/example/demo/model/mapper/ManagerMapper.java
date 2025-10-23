package com.example.demo.model.mapper;

import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.entity.AbsenceEntity;
import org.springframework.stereotype.Service;

@Service
public class ManagerMapper {

    public ManagerDto toDto(AbsenceEntity entity){
        ManagerDto managerDto = new ManagerDto();

        managerDto.setId(entity.getId());
        managerDto.setFirstName(entity.getFirstName());
        managerDto.setLastName(entity.getLastName());
        managerDto.setStartDate(entity.getStartDate());
        managerDto.setEndDate(entity.getEndDate());
        managerDto.setReason(entity.getReason());
        managerDto.setComments(entity.getComments());
        managerDto.setFeedback(entity.getFeedback());

        return managerDto;
    }

    public AbsenceEntity toEntity(ManagerDto request) {
        AbsenceEntity absenceEntity = new AbsenceEntity();
        absenceEntity.setId(request.getId());
        absenceEntity.setFirstName(request.getFirstName());
        absenceEntity.setLastName(request.getLastName());
        absenceEntity.setStartDate(request.getStartDate());
        absenceEntity.setEndDate(request.getEndDate());
        absenceEntity.setReason(request.getReason());
        absenceEntity.setComments(request.getComments());
        absenceEntity.setFeedback(request.getFeedback());

        return absenceEntity;
    }

}
