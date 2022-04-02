package com.example.clinica.repository;

public interface IDaoPaciente<T> {
    public T buscarPorEmail(String email);

    public T editar(T t);

}
