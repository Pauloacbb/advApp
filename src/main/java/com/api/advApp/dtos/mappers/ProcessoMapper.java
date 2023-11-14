package com.api.advApp.dtos.mappers;

import com.api.advApp.dtos.ProcessoDto;
import com.api.advApp.models.ProcessoModel;
import org.springframework.stereotype.Component;

@Component
public class ProcessoMapper {
    public ProcessoDto toDTO(ProcessoModel processoModel){
        if(processoModel == null){
            return null;
        }
        return new ProcessoDto(processoModel.getId(),
                processoModel.getNumero(),
                processoModel.getDigito(),
                processoModel.getAno(),
                processoModel.getJustica(),
                processoModel.getTribunal(),
                processoModel.getVara(),
                processoModel.getClienteNome()
                );
    }

    public ProcessoModel toEntity(ProcessoDto processoDto){
        if(processoDto == null){
            return null;
        }
        ProcessoModel processoModel = new ProcessoModel();
        if(processoDto.id() != null){
            processoModel.setId(processoDto.id());
        }
        processoModel.setNumero(processoDto.numero());
        processoModel.setDigito(processoDto.digito());
        processoModel.setAno(processoDto.ano());
        processoModel.setJustica(processoDto.justica());
        processoModel.setTribunal(processoDto.tribunal());
        processoModel.setVara(processoDto.vara());
        processoModel.setClienteNome(processoDto.clienteNome());
        return processoModel;
    }
}
