package repository;

import model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByNameContainingIgnoreCase(String name);
    List<Patient> findByCondition(String condition);
    List<Patient> findByAssignedTherapist(String assignedTherapist);
    List<Patient> findByConditionAndAssignedTherapist(String condition, String assignedTherapist);
}