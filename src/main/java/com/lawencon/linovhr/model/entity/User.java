package com.lawencon.linovhr.model.entity;

import com.lawencon.linovhr.model.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_code", nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @Column(name = "annual_leave_quota", nullable = false)
    private Integer annualLeaveQuota;

    @PrePersist
    public void prePersist() {
        if (this.annualLeaveQuota == null) {
            this.annualLeaveQuota = 12;
        }
    }
}
