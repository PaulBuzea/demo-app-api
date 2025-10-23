package com.example.demo.controller;

import com.example.demo.model.dto.CoWorkerDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.entity.AbsenceEntity;
import com.example.demo.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/absence")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceEntity> getAbsenceById(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.getAbsenceById(id));
    }

    @GetMapping("/manager")
    public ResponseEntity<List<ManagerDto>> getAllAbsencesManager() {
        List<ManagerDto> absences = absenceService.getAllAbsencesManager();
        return ResponseEntity.ok(absences);
    }

    @PutMapping("/manager")
    public ResponseEntity<ManagerDto> updateAbsenceManager(@RequestBody ManagerDto request) {
        return ResponseEntity.ok(absenceService.updateAbsenceManager(request));
    }

    @GetMapping("/co-worker")
    public ResponseEntity<List<CoWorkerDto>> getAllAbsencesCoworker() {
        List<CoWorkerDto> absences = absenceService.getAllAbsencesCoWorker();
        return ResponseEntity.ok(absences);
    }

    @PutMapping("/co-worker")
    public ResponseEntity<CoWorkerDto> updateAbsenceCoWorker(@RequestBody CoWorkerDto request) {
        return ResponseEntity.ok(absenceService.updateAbsenceCoWorker(request));
    }

    @PostMapping
    public ResponseEntity<AbsenceEntity> createAbsence(@RequestBody AbsenceEntity request) {
        AbsenceEntity response = absenceService.createAbsence(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
