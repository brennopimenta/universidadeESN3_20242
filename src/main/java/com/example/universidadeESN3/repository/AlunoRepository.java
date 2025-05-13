package com.example.universidadeESN3.repository;

import com.example.universidadeESN3.entity.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);

    List<Aluno> findByNomeStartingWith(String nome);

//    @Query(value = "SELECT a FROM Aluno a WHERE a.nome LIKE :nome%", nativeQuery = true)
//    List<Aluno> findByNomeStartingWith(@Param("nome") String nome);

    @Query(value = "SELECT * FROM aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT(:nome, '%'))", nativeQuery = true)
    List<Aluno> findByNomeStartingWithIgnoreCase(@Param("nome") String nome);

    @Query("SELECT a FROM Aluno a WHERE a.active = true")
    Page<Aluno> findAlunosAtivos(Pageable pageable);

}
