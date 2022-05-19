package com.gabriel.martins.assembly.repository;

import com.gabriel.martins.assembly.entity.AssemblyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssemblyRepository extends JpaRepository<AssemblyEntity, Long> {
}
