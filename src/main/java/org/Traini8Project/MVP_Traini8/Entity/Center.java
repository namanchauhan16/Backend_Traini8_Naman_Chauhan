package org.Traini8Project.MVP_Traini8.Entity;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

// Entity class for Training Centers
@Document("Training Center")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Center {

    @Id
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @NotBlank(message = "Center code is required")
    private String centerCode;

    @Size(max = 40, message = "Center name must be less than 40 characters")
    @NotBlank(message = "Center name is required")
    private String centerName;

    @NotNull(message = "Address is required")
    private Address address;

    private int studentCapacity;

    private List<String> coursesOffered;

    private long createdOn = Instant.now().getEpochSecond();

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    @NotBlank(message = "Contact phone is required")
    private String contactPhone;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Address {

    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid pin code format")
    private String pinCode;
}

