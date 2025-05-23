package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.exception.AlunoNotFoundException;
import com.example.universidadeESN3.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno buscarPorId(Long id) {
        try {
            return alunoRepository.findById(id)
                    .orElseThrow(() -> new AlunoNotFoundException(id));
        } catch (Exception e) {
            log.error("salvar() - ERRO Inesperado :{}", e.getMessage(), e );
            throw new RuntimeException("Erro ao buscar o aluno por ID", e);
        }
    }

    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        log.info("salvar() - aluno:{}", aluno );
        return alunoRepository.save(aluno);
    }

    @Override
    public ResponseEntity<?> atualizar(Aluno aluno) {
        log.info("atualizar() - aluno:{}", aluno );
        Aluno original = buscarPorId(aluno.getId());
        if (original == null) {
            return ResponseEntity.notFound().build();
        }

        original.setNome(aluno.getNome());
        alunoRepository.save(original);
        return ResponseEntity.ok(null);
    }

    @Override
    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }

    public void desativar(Aluno aluno) {
        aluno.setActive(Boolean.FALSE);
        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarPorNome(String nome) {
//        return alunoRepository.findByNome(nome);
        return alunoRepository.findByNomeStartingWithIgnoreCase(nome);
    }

    public Page<Aluno> listarPaginado(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }
}
