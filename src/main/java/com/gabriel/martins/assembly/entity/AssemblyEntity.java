package com.gabriel.martins.assembly.entity;

import com.gabriel.martins.assembly.enums.AssemblyStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "assembly", uniqueConstraints = { @UniqueConstraint(name = "constraint_closed_assembly", columnNames = { "id_closed_assembly" }) })
@Entity
@Data
public class AssemblyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "registered_date", nullable = false)
    private LocalDateTime registeredDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "assembly_status", length = 10, nullable = false)
    private AssemblyStatus status;

    @Column(name = "ending_date", nullable = false)
    private LocalDate endingDate;

    @Column(name = "starting_date", nullable = false)
    private LocalDate startingDate;

    @Column(name = "id_closed_assembly", nullable = false)
    private Long idClosedAssembly;
}
