package com.api.advApp.repositories;

import com.api.advApp.models.ProcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepositoty extends JpaRepository<ProcessoModel, Long> {
}
