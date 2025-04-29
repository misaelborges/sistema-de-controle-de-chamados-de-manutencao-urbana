package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.repositories;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChamadoRepository extends JpaRepository<Chamado, Long> {
}
