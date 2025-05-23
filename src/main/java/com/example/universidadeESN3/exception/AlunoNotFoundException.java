package com.example.universidadeESN3.exception;

public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(Long id) {
        super("Aluno com ID " + id + " não encontrado.");
    }
}
