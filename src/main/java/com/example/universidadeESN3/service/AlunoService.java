package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Optional<Aluno> response = alunoRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
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
    public void atualizar(Aluno aluno) {
        log.info("atualizar() - aluno:{}", aluno );
        alunoRepository.save(aluno);
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
