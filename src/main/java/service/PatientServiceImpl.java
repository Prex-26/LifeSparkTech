package service;

import model.Patient;
import repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient updatePatient(String id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> searchPatients(String condition, String therapist) {
        if (condition != null && therapist != null) {
            return patientRepository.findByConditionAndAssignedTherapist(condition, therapist);
        } else if (condition != null) {
            return patientRepository.findByCondition(condition);
        } else if (therapist != null) {
            return patientRepository.findByAssignedTherapist(therapist);
        }
        return getAllPatients();
    }
}