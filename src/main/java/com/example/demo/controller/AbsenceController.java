package com.example.demo.controller;

import com.example.demo.model.AbsenceEntity;
import com.example.demo.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absence")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<AbsenceEntity> createAbsence(@RequestBody AbsenceEntity request) {
        AbsenceEntity response = absenceService.createAbsence(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AbsenceEntity>> getAllAbsences() {
        List<AbsenceEntity> absences = absenceService.getAllAbsences();
        return ResponseEntity.ok(absences);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbsenceEntity> updateAbsence(@PathVariable Long id, @RequestBody AbsenceEntity request) {
        return ResponseEntity.ok(absenceService.updateAbsence(request));
    }

}
