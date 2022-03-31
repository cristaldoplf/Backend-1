package com.example.MVCMapping.daos;

import java.util.List;

public interface IDao<T> {
    //db_estudiantes
    public T guardar(T t);
    public void eliminar(int id);
    public T buscar(int id);
    public List<T> buscarTodos();
    public T update(T t);
}
