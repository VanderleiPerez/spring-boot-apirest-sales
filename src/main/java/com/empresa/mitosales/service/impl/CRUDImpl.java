package com.empresa.mitosales.service.impl;

import com.empresa.mitosales.repo.IGenericRepo;
import com.empresa.mitosales.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T create(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null); //  null: de momento, luego se cambiará| INTERCEPTADOR: si fuera orElseThrow se puede personalizar el mensaje  para 'NoSuchElementException'
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
