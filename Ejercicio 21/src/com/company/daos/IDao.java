package com.company.daos;

import java.util.List;

public interface IDao<T> {
    //db_estudiantes
    public T guardar(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
}
