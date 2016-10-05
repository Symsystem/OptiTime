package com.symsystem.optitime.repository;

/**
 * @author sym
 */

interface Repository<T, I> {

    void save(T entity);

    boolean exists(I entity);

    T find(I id);
}
