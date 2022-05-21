package com.gabriel.martins.assembly.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.gabriel.martins.assembly.enums.AssemblyStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "AssemblyDto", description = "Dados de pauta finalizada")
public class AssemblyDto {

    @ApiModelProperty(notes = "Id da pauta recebida no Kafka", example = "1")
    private Long id;

    @ApiModelProperty(notes = "Id da pauta fechada no serviço de votação", example = "2")
    private Long idClosedAssembly;

    @ApiModelProperty(notes = "Descrição da pauta", example = "Pauta para mudança do síndico do prédio XPTO")
    private String description;

    @ApiModelProperty(notes = "Data de criação da pauta", example = "2022-05-18")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredDate;

    @ApiModelProperty(notes = "Status final da pauta", example = "Indica o status final de uma pauta")
    private AssemblyStatus status;

    @ApiModelProperty(notes = "Data de início da votação", example = "2022-05-18")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startingDate;

    @ApiModelProperty(notes = "Data de finalização da votação", example = "2022-05-31")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endingDate;
}
