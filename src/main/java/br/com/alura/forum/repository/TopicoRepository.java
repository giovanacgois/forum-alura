package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    //Se tiver o atributo cursoNome na classe Topico, basta mudar o nome do método para finByCurso_Nome,
    // que o Spring entende que se trata de um relacionamento.
    List<Topico> findByCursoNome(String nomeCurso);

    @Query("SELECT t from Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
