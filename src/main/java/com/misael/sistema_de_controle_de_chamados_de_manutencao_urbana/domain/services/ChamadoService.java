package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.services;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories.IChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository chamadoRepository;

    public Chamado salvarChamado(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }
}
