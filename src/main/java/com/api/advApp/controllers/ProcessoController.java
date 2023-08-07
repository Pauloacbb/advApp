package com.api.advApp.controllers;

import com.api.advApp.dtos.ProcessoDto;
import com.api.advApp.models.ProcessoModel;
import com.api.advApp.services.ProcessoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> saveProcesso (@RequestBody @Valid ProcessoDto processoDto){

        var processoMoldel = new ProcessoModel();

        BeanUtils.copyProperties(processoDto,processoMoldel);

        return ResponseEntity.status(HttpStatus.CREATED).body(processoService.save(processoMoldel));

    }

    @GetMapping
    public ResponseEntity<List<ProcessoModel>> getAllProcessos(){
        return ResponseEntity.status(HttpStatus.OK).body(processoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProcesso(@PathVariable(value = "id")@NotNull @Positive Long id) {
        Optional<ProcessoModel> processoModelOptional = processoService.findById(id);
        if (!processoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(processoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcesso(@PathVariable(value = "id")@NotNull @Positive Long id){
        Optional<ProcessoModel> processoModelOptional = processoService.findById(id);
        if (!processoModelOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processoService.delete(processoModelOptional.get());
        return ResponseEntity.noContent().<Void>build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProcesso(@PathVariable(value = "id")@NotNull @Positive Long id,
                                                 @RequestBody @Valid ProcessoDto processoDto){
        Optional<ProcessoModel> processoModelOptional = processoService.findById(id);
        if (!processoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado.");
        }

        var processoModel = new ProcessoModel();
        BeanUtils.copyProperties(processoDto,processoModel);
        processoModel.setId(processoModelOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(processoService.save(processoModel));
    }
}
