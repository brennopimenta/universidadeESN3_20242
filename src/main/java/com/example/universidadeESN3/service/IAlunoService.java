package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAlunoService {

    Aluno buscarPorId(Long id);

    List<Aluno> buscarTodos();

    Aluno salvar(Aluno aluno);

    ResponseEntity<?> atualizar(Aluno aluno);

    void excluir(Long id);
}
