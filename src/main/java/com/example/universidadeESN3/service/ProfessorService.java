package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor buscarPorId(Long id) {
        Optional<Professor> professorOpt = professorRepository.findById(id);
        if (professorOpt.isEmpty()){
            return null;
        }
        return professorOpt.get();
    }

    @Override
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    @Override
    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void atualizar(Professor professor) {

    }

    @Override
    public void excluir(Long id) {

    }
}
