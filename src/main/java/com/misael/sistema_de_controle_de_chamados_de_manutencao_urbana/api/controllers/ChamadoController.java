package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.controllers;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.ChamadoRequestDTO;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.ChamadoResponseDTO;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.ChamadoResumoResponseDTO;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/chamado/{id}")
    public ChamadoResponseDTO buscarChamadoPorId(@PathVariable Long id) {
        Chamado chamado = chamadoService.buscarChamadoPorId(id);
        return new ChamadoResponseDTO(chamado);
    }

    @GetMapping
    public List<ChamadoResumoResponseDTO> listarTodos() {
        List<Chamado> chamados = chamadoService.listarChamados();
        List<ChamadoResumoResponseDTO> chamadoResponseDTOS = new ArrayList<>();
        for (Chamado chamado : chamados) {
            chamadoResponseDTOS.add(new ChamadoResumoResponseDTO(chamado));
        }

        return chamadoResponseDTOS;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadoResponseDTO salvarChamado(@RequestBody @Valid ChamadoRequestDTO chamadoRequestDTO) {
        Chamado chamado = new Chamado(chamadoRequestDTO);
        chamadoService.salvarChamado(chamado);
        return new ChamadoResponseDTO(chamado);
    }
}
