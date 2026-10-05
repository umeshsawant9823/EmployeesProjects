package org.app.entity;

import jakarta.persistence.*;
import lombok.*;
// Employee table
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false, unique = true)
    private String email;
}
