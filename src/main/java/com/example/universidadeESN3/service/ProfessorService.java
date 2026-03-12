package com.example.universidadeESN3.service;

import com.example.universidadeESN3.dto.ProfessorDTO;
import com.example.universidadeESN3.dto.ProfessorRequestDTO;
import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return professorRepository.findByActiveTrue();
    }

    @Override
    public Professor salvar(ProfessorRequestDTO professorRequestDTO) {
        Professor professor = new Professor();
        professor.setNome(professorRequestDTO.getNome());
        professor.setMatricula(professorRequestDTO.getMatricula());
        professor.setActive(Boolean.TRUE);
        return professorRepository.save(professor);
    }

    @Override
    public ResponseEntity<?> atualizar(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.getReferenceById(id);
        if (professor == null){
            return ResponseEntity.badRequest().build();
        }
        professor.setNome(professorDTO.getNome());
        professorRepository.save(professor);
        return ResponseEntity.ok(null);

    }

    @Override
    public ResponseEntity<?> excluir(Long id) {
        Professor professor = professorRepository.getReferenceById(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        professor.setActive(Boolean.FALSE);
        professorRepository.save(professor);
        return ResponseEntity.ok(null);
    }
}
