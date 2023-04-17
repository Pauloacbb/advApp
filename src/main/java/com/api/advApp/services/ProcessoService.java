package com.api.advApp.services;

import com.api.advApp.models.ProcessoModel;
import com.api.advApp.repositories.ProcessoRepositoty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {
    final ProcessoRepositoty processoRepositoty;

    public ProcessoService(ProcessoRepositoty processoRepositoty) {
        this.processoRepositoty = processoRepositoty;
    }

    @Transactional
    public ProcessoModel save(ProcessoModel processoModel){
        return processoRepositoty.save(processoModel);
    }


    public List<ProcessoModel> findAll() {
        return processoRepositoty.findAll();
    }


    public Optional<ProcessoModel> findById(Long id) {
        return processoRepositoty.findById(id);
    }
    @Transactional
    public void delete(ProcessoModel processoModel) {
        processoRepositoty.delete(processoModel);
    }
}
