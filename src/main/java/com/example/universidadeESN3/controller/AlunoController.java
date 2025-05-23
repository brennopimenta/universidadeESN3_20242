package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.service.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@Slf4j
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodos() {
        return ResponseEntity.ok(alunoService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable String nome){

        List<Aluno> response = alunoService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Aluno>> listarAlunosPaginado(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Aluno> alunos = alunoService.listarPaginado(pageable);
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno){
        log.info("salvarAluno() - aluno:{}", aluno );
        return ResponseEntity.ok(alunoService.salvar(aluno));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Aluno aluno){
        return alunoService.atualizar(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Aluno response = alunoService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        alunoService.excluir(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<?> desativar(@PathVariable Long id) {
        Aluno response = alunoService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        alunoService.desativar(response);
        return ResponseEntity.ok(null);
    }


}
