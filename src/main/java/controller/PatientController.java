package controller;

import model.Patient;
import repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable String id) {
        return patientRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@Valid @RequestBody Patient patient) {
        try {
            Patient savedPatient = patientRepository.save(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error creating patient: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        return patientRepository.findById(id)
            .map(existingPatient -> {
                patient.setId(id);
                return ResponseEntity.ok(patientRepository.save(patient));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable String id) {
        return patientRepository.findById(id)
            .map(patient -> {
                patientRepository.delete(patient);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPatients(
            @RequestParam(required = false) String condition,
            @RequestParam(required = false) String assignedTherapist) {
        try {
            if (condition != null && assignedTherapist != null) {
                return ResponseEntity.ok(patientRepository
                    .findByConditionAndAssignedTherapist(condition, assignedTherapist));
            } else if (condition != null) {
                return ResponseEntity.ok(patientRepository.findByCondition(condition));
            } else if (assignedTherapist != null) {
                return ResponseEntity.ok(patientRepository.findByAssignedTherapist(assignedTherapist));
            }
            return ResponseEntity.ok(patientRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error searching patients: " + e.getMessage());
        }
    }
}
