package com.gabriel.martins.assembly.controller;

import com.gabriel.martins.assembly.dto.AssemblyDto;
import com.gabriel.martins.assembly.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consult/assembly")
public class AssemblyController {

    @Autowired
    private AssemblyService service;

    @GetMapping
    public ResponseEntity<Page<AssemblyDto>> getAssemblies(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                           @RequestParam(name = "sortParameter", defaultValue = "id") String sortParameter,
                                                           @RequestParam(name = "sortDirection", defaultValue = "ASC") String sortDirection){
        return ResponseEntity.ok(service.findAssemblies(pageSize, pageNumber, sortParameter, sortDirection));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssemblyDto> findAssembly(@PathVariable(value = "id") Long assemblyId) {
        return ResponseEntity.ok(service.findAssembly(assemblyId));
    }
}
