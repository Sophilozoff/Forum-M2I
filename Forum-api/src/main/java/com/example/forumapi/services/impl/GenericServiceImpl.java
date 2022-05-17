package com.example.forumapi.services.impl;

import com.example.forumapi.dao.GenericDao;
import com.example.forumapi.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl<E, K> implements GenericService<E, K> {

    public GenericDao<E, K> genericDao;

    public GenericServiceImpl(GenericDao<E,K> genericDao) {
        this.genericDao=genericDao;
    }

    public GenericServiceImpl() {}

    @Override
    public void add(E entity) {
        genericDao.add(entity);
    }

    @Override
    public void save(E entity) {
        genericDao.save(entity);
    }

    @Override
    public E update(E entity) {
        return genericDao.update(entity);
    }

    @Override
    public void delete(E entity) {
        genericDao.delete(entity);
    }

    @Override
    public E findById(K key) {
        return genericDao.findById(key);
    }

    @Override
    public List<E> findAll() {
        return genericDao.findAll();
    }
}
