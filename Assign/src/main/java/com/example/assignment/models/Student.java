package com.example.assignment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "The length should be in between 2 and 50")
    private String studentName;

    @NotNull(message = "The DOB is required")
    @Past(message = "The DOB must be a past date")
    private LocalDate studentDob;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String studentEmail;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "The contact number must be a valid 10 digit number")
    private String studentMobile;

    @NotBlank(message = "Course is required")
    @Size(min=2, max = 50, message = "The length of course name should be in between 2 and 50")
    private String studentCourse;

}
