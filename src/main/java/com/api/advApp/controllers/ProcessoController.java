package com.api.advApp.controllers;

import com.api.advApp.dtos.ProcessoDto;
import com.api.advApp.models.ProcessoModel;
import com.api.advApp.services.ProcessoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Validated
@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/processos")
public class ProcessoController {
    final ProcessoService processoService;


    public ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProcesso(@RequestBody @Valid ProcessoDto processoDto) {

        var processoMoldel = new ProcessoModel();

        BeanUtils.copyProperties(processoDto, processoMoldel);

        return ResponseEntity.status(HttpStatus.CREATED).body(processoService.save(processoMoldel));

    }

    @GetMapping
    public ResponseEntity<List<ProcessoModel>> getAllProcessos() {
        return ResponseEntity.status(HttpStatus.OK).body(processoService.findAll());
    }

    @GetMapping("/{id}")
    public ProcessoModel getOneProcesso(@PathVariable(value = "id") @NotNull @Positive Long id) {
        return processoService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProcesso(@PathVariable(value = "id") @NotNull @Positive Long id) {
        processoService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProcessoModel updateProcesso(@PathVariable(value = "id") @NotNull @Positive Long id,
                                                 @RequestBody @Valid ProcessoDto processoDto) {
        return processoService.update(id, processoDto);
    }

}
