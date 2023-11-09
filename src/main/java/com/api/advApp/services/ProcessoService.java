package com.api.advApp.services;

import com.api.advApp.dtos.ProcessoDto;
import com.api.advApp.exception.RecordNotfoundException;
import com.api.advApp.models.ProcessoModel;
import com.api.advApp.repositories.ProcessoRepositoty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class ProcessoService {
    final ProcessoRepositoty processoRepositoty;

    public ProcessoService(ProcessoRepositoty processoRepositoty) {
        this.processoRepositoty = processoRepositoty;
    }

    @Transactional
    public ProcessoModel save(ProcessoModel processoModel) {
        return processoRepositoty.save(processoModel);
    }


    public List<ProcessoModel> findAll() {
        return processoRepositoty.findAll();
    }


    public ProcessoModel findById(Long id) {
        return processoRepositoty.findById(id).orElseThrow(() -> new RecordNotfoundException(id));
    }

    @Transactional
    public void delete(@PathVariable @NotNull Long id) {

        processoRepositoty.delete(processoRepositoty.findById(id)
                .orElseThrow(() -> new RecordNotfoundException(id)));
    }


    public ProcessoModel update(@PathVariable(value = "id") @NotNull @Positive Long id,
                                @RequestBody @Valid ProcessoDto processoDto) {
        ProcessoModel processoModel = processoRepositoty.findById(id).orElseThrow(() -> new RecordNotfoundException(id));
        BeanUtils.copyProperties(processoDto, processoModel);
        return processoRepositoty.save(processoModel);
    }
}
