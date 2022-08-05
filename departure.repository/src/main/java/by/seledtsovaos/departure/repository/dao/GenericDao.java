package by.seledtsovaos.departure.repository.dao;

import java.util.List;

import by.seledtsovaos.departure.repository.exception.DaoException;

/**
 * Generic interface, determining main database operations as create, read, update, delete of all entities.
 * @param <I> value of a primitive types of entity fields
 * @param <T> type of entity
 */
public interface GenericDao<I, T> {

    /**
     * Adds new {@link T} to entity table.
     * @param entity  {@link T} object with new data and ID to put data to
     * @throws DaoException if impossible to save new {@link T}
     */
    void add(T entity);

    /**
     * Obtains collection of {@link T} objects with data from database.
     * @return collection of {@link T} objects
     * @throws DaoException if impossible to get {@link T}
     */
    List<T> findAll();

    /**
     * Deletes specified {@link T} entry.
     * @param id ID of entry to look for and delete {@link T}
     * @throws DaoException if not in the database specified {@link T}
     */
    void delete(I id);

    /**
     * Obtains {@link T} object with data of specified entity from database by its ID.
     * @param id ID of specified {@link T}
     * @return {@link T} object
     * @throws DaoException if not in the database specified {@link T}
     */
    T findById(I id);

    /**
     * Updates specified {@link T} entry.
     * @param entity {@link T} object that is being updated
     * @throws DaoException if not in the database specified {@link T}
     */
    void update(T entity);

}
