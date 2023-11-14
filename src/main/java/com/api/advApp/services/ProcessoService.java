package com.api.advApp.services;

import com.api.advApp.dtos.ProcessoDto;
import com.api.advApp.dtos.mappers.ProcessoMapper;
import com.api.advApp.exception.RecordNotfoundException;
import com.api.advApp.repositories.ProcessoRepositoty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class ProcessoService {
    final ProcessoRepositoty processoRepositoty;
    final ProcessoMapper processoMapper;

    public ProcessoService(ProcessoRepositoty processoRepositoty,ProcessoMapper processoMapper) {
        this.processoRepositoty = processoRepositoty;
        this.processoMapper = processoMapper;
    }

    @Transactional
    public ProcessoDto save(@Valid @NotNull ProcessoDto processoDto) {
        return processoMapper.toDTO(processoRepositoty.save(processoMapper.toEntity(processoDto)));
    }


    public List<ProcessoDto> findAll() {
        return processoRepositoty.findAll().stream()
                .map(processoMapper :: toDTO)
                .collect(Collectors.toList());
    }


    public ProcessoDto findById(Long id) {
        return processoRepositoty.findById(id)
                .map(processoMapper::toDTO)
                .orElseThrow(() -> new RecordNotfoundException(id));
    }

    @Transactional
    public void delete(@PathVariable @NotNull Long id) {

        processoRepositoty.delete(processoRepositoty.findById(id)
                .orElseThrow(() -> new RecordNotfoundException(id)));
    }


    public ProcessoDto update(@PathVariable(value = "id") @NotNull @Positive Long id,
                                @RequestBody @Valid @NotNull ProcessoDto processoDto) {
        return processoRepositoty.findById(id)
                .map(recordFound ->{
                    recordFound.setNumero(processoDto.numero());
                    recordFound.setDigito(processoDto.digito());
                    recordFound.setAno(processoDto.ano());
                    recordFound.setJustica(processoDto.justica());
                    recordFound.setTribunal(processoDto.tribunal());
                    recordFound.setVara(processoDto.vara());
                    recordFound.setClienteNome(processoDto.clienteNome());
                    return processoMapper.toDTO(processoRepositoty.save(recordFound));
                })
                .orElseThrow(() -> new RecordNotfoundException(id));
    }
}
