package com.example.universidadeESN3.exception;

public class AlunoAlreadyExistsException extends RuntimeException{
    public AlunoAlreadyExistsException(Long matricula) {
        super("Aluno com Matricula " + matricula + " já existe.");
    }
}
