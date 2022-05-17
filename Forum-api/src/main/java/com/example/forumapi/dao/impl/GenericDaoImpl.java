package com.example.forumapi.dao.impl;

import com.example.forumapi.dao.GenericDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    @PersistenceContext
    EntityManager entityManager;

    protected Class<? extends E> daoType;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class<? extends E>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void add(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void save(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E findById(K key) {
        return (E) entityManager.find(daoType, key);
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery("from " + daoType.getName()).getResultList();
    }
}
