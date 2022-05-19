package com.gabriel.martins.assembly.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.martins.assembly.converter.AssemblyConverter;
import com.gabriel.martins.assembly.dto.AssemblyDto;
import com.gabriel.martins.assembly.entity.AssemblyEntity;
import com.gabriel.martins.assembly.repository.AssemblyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssemblyService {

    private static final Logger LOG = LoggerFactory.getLogger(AssemblyService.class);

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private AssemblyRepository repository;

    @Autowired
    private AssemblyConverter converter;

    @Async
    public void process(String dto, Acknowledgment acknowledgment) {
        try{
            LOG.info("Uma pauta finalizada foi recebida!");
            AssemblyEntity entity = converter.convertToEntity(mapper.readValue(dto, AssemblyDto.class));
            entity.setId(null);
            entity.setCreatedDate(LocalDateTime.now());

            repository.save(entity);
            LOG.info("Uma pauta foi registrada!");
            acknowledgment.acknowledge();
        } catch (Exception e) {
            acknowledgment.acknowledge();
            LOG.error("Não foi possível processar a pauta recebida. {}", e.getMessage());
        }
    }

    public Page<AssemblyDto> findAssemblies(Integer pageSize, Integer pageNumber, String sortParameter, String sortDirection){
        try{
            LOG.info("Buscando pautas finalizadas.");
            PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,
                    Sort.Direction.valueOf(sortDirection), sortParameter);

            Page<AssemblyDto> assemblies = repository.findAll(pageRequest).map(a -> converter.convertToDto(a));
            return assemblies;
        } catch (Exception e){
            LOG.error("Não foi possível buscar as pautas. {}", e.getMessage());
            return null;
        }
    }

    public AssemblyDto findAssembly(Long assemblyId){
        try {
            LOG.info("Buscando pauta {}", assemblyId);
            Optional<AssemblyEntity> assemblyOp = repository.findById(assemblyId);

            if(assemblyOp.isPresent()){
                return converter.convertToDto(assemblyOp.get());
            } else {
                LOG.info("Pauta não encontrada {}", assemblyId);
                return null;
            }
        } catch (Exception e) {
            LOG.error("Não foi possível buscar a pauta. {}", e.getMessage());
            return null;
        }
    }
}
