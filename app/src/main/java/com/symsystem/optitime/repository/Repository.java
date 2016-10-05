package com.symsystem.optitime.repository;

/**
 * @author sym
 */

interface Repository<T, I> {

    String nextIdentity();

    void save(T entity);

    boolean exists(I entity);

    T find(I id);
}
