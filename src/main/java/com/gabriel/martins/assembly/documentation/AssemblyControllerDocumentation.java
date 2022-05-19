package com.gabriel.martins.assembly.documentation;

import com.gabriel.martins.assembly.dto.AssemblyDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface AssemblyControllerDocumentation {

    @ApiOperation(value = "Requisição para listagem paginada de pautas finalizadas")
    @ApiResponses({ @ApiResponse(code = 200, message = "Pautas finalizadas.") })
    ResponseEntity<Page<AssemblyDto>> getAssemblies(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                    @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                    @RequestParam(name = "sortParameter", defaultValue = "id") String sortParameter,
                                                    @RequestParam(name = "sortDirection", defaultValue = "ASC") String sortDirection);

    @ApiOperation(value = "Requisição para busca de uma pautas específica")
    @ApiResponses({ @ApiResponse(code = 200, message = "Pauta encontrada.") })
    ResponseEntity<AssemblyDto> findAssembly(@PathVariable(value = "id") Long assemblyId);
}
