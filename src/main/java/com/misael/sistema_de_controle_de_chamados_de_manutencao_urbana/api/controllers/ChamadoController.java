package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.controllers;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.*;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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

    @PutMapping("/atualizarStatusChamado/{id}")
    public ChamadoResponseDTO atualizarStatus(@PathVariable Long id, @RequestBody ChamadoAtualizarStatusDTO atualizacaoDTO) {

        Chamado chamado = chamadoService.atualizarStatus(
                id, atualizacaoDTO.getStatusChamado(), atualizacaoDTO.getComentarioServidor());

        return new ChamadoResponseDTO(chamado);
    }

    @GetMapping("/filtrarStatusChamado")
    public List<ChamadoResumoResponseDTO> filtrarStatusChamado(@RequestParam StatusChamado statusChamado) {
        List<Chamado> listaChamadoFiltrado = chamadoService.filtrarPorStatusChamado(statusChamado);
        List<ChamadoResumoResponseDTO> chamadoResponse = new ArrayList<>();

        for (Chamado chamado : listaChamadoFiltrado) {
            chamadoResponse.add(new ChamadoResumoResponseDTO(chamado));
        }

        return chamadoResponse;
    }

    @GetMapping("/filtrarChamadoPorBairro")
    public List<ChamadoResumoResponseDTO> filtrarChamadoPorBairro(@RequestParam String bairro) {
        List<Chamado> listaChamadoFiltrado = chamadoService.filtrarChamadoPorBairro(bairro);
        List<ChamadoResumoResponseDTO> chamadoResponse = new ArrayList<>();

        for (Chamado chamado : listaChamadoFiltrado) {
            chamadoResponse.add(new ChamadoResumoResponseDTO(chamado));
        }

        return chamadoResponse;
    }

    @GetMapping("/filtrarChamadoPorCidade")
    public List<ChamadoResumoResponseDTO> filtrarChamadoPorCidade(@RequestParam String cidade) {
        List<Chamado> listaChamadoFiltrado = chamadoService.filtrarChamadoPorCidade(cidade);
        List<ChamadoResumoResponseDTO> chamadoResponse = new ArrayList<>();

        for (Chamado chamado : listaChamadoFiltrado) {
            chamadoResponse.add(new ChamadoResumoResponseDTO(chamado));
        }

        return chamadoResponse;
    }

    @DeleteMapping("/deletarChamado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarChamado(@PathVariable Long id) {
        chamadoService.deletarChamado(id);
    }

    @PutMapping("/atualizarChamado/{id}")
    public ChamadoResumoResponseDTO atualizarChamado(@PathVariable Long id, @RequestBody @Valid ChamadoRequestDTO chamadoRequestDTO) {
        Chamado chamado = chamadoService.buscarChamadoPorId(id);
        BeanUtils.copyProperties(chamadoRequestDTO, chamado, "id", "dataAbertura", "dataResolucao");

        chamadoService.salvarChamado(chamado);
        return new ChamadoResumoResponseDTO(chamado);
    }

    @GetMapping("/contarPorStatus")
    public ChamadoStatusCountDTO Chamada(@RequestParam StatusChamado statusChamado) {
        Long contadorChamado = chamadoService.contarChamadosPorStatus(statusChamado);
        return new ChamadoStatusCountDTO(statusChamado, contadorChamado);

    }
}
