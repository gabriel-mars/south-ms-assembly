package com.gabriel.martins.assembly.converter;

import com.gabriel.martins.assembly.dto.AssemblyDto;
import com.gabriel.martins.assembly.entity.AssemblyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface AssemblyConverter {

    AssemblyDto convertToDto(AssemblyEntity entity);

    AssemblyEntity convertToEntity(AssemblyDto dto);
}
