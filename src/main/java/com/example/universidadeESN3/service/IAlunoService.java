package com.example.universidadeESN3.service;

import com.example.universidadeESN3.dto.AlunoCreateDTO;
import com.example.universidadeESN3.dto.AlunoResponseDTO;
import com.example.universidadeESN3.entity.Aluno;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAlunoService {

    Aluno buscarPorId(Long id);

    AlunoResponseDTO buscaAlunoReponseDTO(Long id);

    List<Aluno> buscarTodos();

    AlunoResponseDTO salvar(AlunoCreateDTO aluno);

    ResponseEntity<?> atualizar(Aluno aluno);

    void excluir(Long id);
}
