package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.dto.AlunoCreateDTO;
import com.example.universidadeESN3.dto.AlunoResponseDTO;
import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@Slf4j
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodos() {
        return ResponseEntity.ok(professorService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Professor> salvarProfessor(@Valid @RequestBody Professor professor){
//        log.info("salvarAluno() - aluno:{}", aluno );
        return ResponseEntity.ok(professorService.salvar(professor));
    }
}
