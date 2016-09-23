package com.esport.dao.inter;

import java.util.List;

import com.esport.dao.exception.DaoException;
import com.esport.domain.User;

/**
 * Provides a DAO-logic for the User entity.
 *
 * @author Anastasia Khitryk
 * @version 1.0
 */

public interface UserDao{
    /**
     * Adds an user to the data storage.
     *
     * @param user an user object
     * @throws DaoException
     */
	void addUser(User user) throws DaoException;
    /**
     * Updates an user in the data storage.
     *
     * @param user an user object
     * @throws DaoException
     */
	void updateUser(User user) throws DaoException;
    /**
     * Deletes an user from the data storage.
     *
     * @param id an id of the deleting user
     * @throws DaoException
     */
	void deleteUser(int id) throws DaoException;
    /**
     * Returns all the users from the data storage.
     *
     * @return all the users from
     * @throws DaoException
     */
	List<User> getAllUsers() throws DaoException;
    /**
     * Returns an user by id from the data storage.
     *
     * @param id an id of the needed user
     * @return an user by id
     * @throws DaoException
     */
	User getUserById(int id) throws DaoException;
    /**
     * Returns an users by the status from the data storage.
     *
     * @param status a status of the needed user
     * @return an users by the status
     * @throws DaoException
     */
	User getUserByEmail(String email) throws DaoException;
    /**
     * Returns an users by the status from the data storage.
     *
     * @param status a status of the needed user
     * @return an users by the status
     * @throws DaoException
     */
	List<User> getUsersByStatus(String status) throws DaoException;
}
