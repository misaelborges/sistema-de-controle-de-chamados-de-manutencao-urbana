package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChamadoRepository extends JpaRepository<Chamado, Long> {

    @Query("SELECT c FROM Chamado c ORDER BY c.dataAbertura ASC")
    public List<Chamado> listarChamados();
}
