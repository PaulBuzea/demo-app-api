package com.example.demo.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CoWorkerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String feedback;

}
