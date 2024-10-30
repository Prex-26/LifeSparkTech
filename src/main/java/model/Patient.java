package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be positive")
    private int age;
    
    @NotBlank(message = "Condition is required")
    private String condition;
    
    @NotBlank(message = "Assigned Therapist is required")
    private String assignedTherapist;
    
    private String contactInfo;
}
