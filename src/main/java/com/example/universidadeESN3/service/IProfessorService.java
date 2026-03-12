package com.example.universidadeESN3.service;

import com.example.universidadeESN3.dto.ProfessorDTO;
import com.example.universidadeESN3.dto.ProfessorRequestDTO;
import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.entity.Professor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProfessorService {

    Professor buscarPorId(Long id);

    List<Professor> buscarTodos();

    Professor salvar(ProfessorRequestDTO professor);

    ResponseEntity<?> atualizar(Long id, ProfessorDTO professorDTO);

    ResponseEntity<?> excluir(Long id);
}
