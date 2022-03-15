package com.company.daos;

import java.util.List;

public interface IDao<T> {
    public T registrar(T t);
    public void modificar(Long id, String marca);
    public void darBaja(Long id);
    public List<T> verFlota();
}
