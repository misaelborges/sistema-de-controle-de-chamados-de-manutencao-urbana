package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChamadoRepository extends JpaRepository<Chamado, Long> {

    @Query("SELECT c FROM Chamado c ORDER BY c.dataAbertura ASC")
    List<Chamado> listarChamados();

    List<Chamado> findChamadoBystatusAtual(StatusChamado statusChamado);

    List<Chamado> findChamadoByEnderecoBairroIgnoreCase(String bairro);

    List<Chamado> findChamadoByEnderecoCidadeIgnoreCase(String cidade);

    Long countByStatusAtual(StatusChamado statusChamado);

}
