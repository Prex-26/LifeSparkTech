package service;

import model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(String id);
    Patient updatePatient(String id, Patient patient);
    void deletePatient(String id);
    List<Patient> searchPatients(String condition, String therapist);
}