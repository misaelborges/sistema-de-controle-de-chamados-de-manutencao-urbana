package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.services;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions.ErroAoSalvarCliente;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories.IChamadoRepository;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository chamadoRepository;

    public Chamado salvarChamado(Chamado chamado) {
        try {
            return chamadoRepository.save(chamado);
        } catch (UnexpectedTypeException e) {
            throw new ErroAoSalvarCliente(
                    "Erro ao salvar o clinete: Verifique se os campos não estão em branco.", e.getCause());
        }
    }
}
