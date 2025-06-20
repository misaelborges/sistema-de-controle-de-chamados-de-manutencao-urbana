package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.services;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions.ErroAoDeletarChamadoException;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions.ErroAoEncontrarChamadoException;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions.ErroAoSalvarChamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Endereco;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories.IChamadoRepository;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository chamadoRepository;

    public Chamado salvarChamado(Chamado chamado) {
        try {
            return chamadoRepository.save(chamado);
        } catch (UnexpectedTypeException e) {
            throw new ErroAoSalvarChamado(
                    "Erro ao salvar o clinete: Verifique se os campos não estão em branco.", e.getCause());
        }
    }

    public Chamado buscarChamadoPorId(Long id) {
        return chamadoRepository.findById(id).orElseThrow(
                () -> new ErroAoEncontrarChamadoException("Não foi encontrado nenhum chamado com esse identificador"));
    }

    public List<Chamado> listarChamados() {
        return chamadoRepository.listarChamados();
    }

    public Chamado atualizarStatus(Long id, StatusChamado novoStatus, String comentarioServidor) {
        Chamado chamadoExistente = buscarChamadoPorId(id);
        chamadoExistente.setStatusAtual(novoStatus);
        chamadoExistente.setComentarioServidor(comentarioServidor);

        return chamadoRepository.save(chamadoExistente);
    }

    public List<Chamado> filtrarPorStatusChamado(StatusChamado statusChamado) {
        return chamadoRepository.findChamadoBystatusAtual(statusChamado);
    }

    public List<Chamado> filtrarChamadoPorBairro(String bairro) {
        return chamadoRepository.findChamadoByEnderecoBairroIgnoreCase(bairro);
    }

    public List<Chamado> filtrarChamadoPorCidade(String cidade) {
        return chamadoRepository.findChamadoByEnderecoCidadeIgnoreCase(cidade);
    }

    public void deletarChamado(Long id) {
        Chamado chamado = buscarChamadoPorId(id);
        if (!StatusChamado.RESOLVIDO.equals(chamado.getStatusAtual())) {
            throw new ErroAoDeletarChamadoException("Chamado só pode ser excluído se estiver com status RESOLVIDO.");
        }

        chamadoRepository.delete(chamado);
    }

    public Long contarChamadosPorStatus(StatusChamado statusChamado) {
        return chamadoRepository.countByStatusAtual(statusChamado);
    }
}
