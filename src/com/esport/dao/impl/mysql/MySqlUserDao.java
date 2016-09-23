package com.esport.dao.impl.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.esport.dao.exception.DaoException;
import com.esport.dao.inter.UserDao;
import com.esport.domain.User;

public class MySqlUserDao implements UserDao{

	@Override
	public void addUser(User user) throws DaoException {
		
		MySqlConnectionPool mySQLConnectionPool = MySQLConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
		    connection = mySQLConnectionPool.getConnection();
		
		    statement = connection.prepareStatement(ADD_USER_QUERY);
		    statement.setString(1, user.getEmail());
		    statement.setString(2, user.getPassword());
		    statement.setString(3, user.getFirstName());
		    statement.setString(4, user.getLastName());
		    statement.setDate(5, new Date(user.getDateOfRegistry().getTime()));
		    statement.setString(6, user.getPhoto());
		    statement.setInt(7, user.getRating());
		    statement.setString(8, user.getStatus());
		    statement.setString(9, user.getLanguageId());
		
		    statement.executeUpdate();
		} catch (InterruptedException | MySQLConnectionPoolException e) {
		    throw new DaoException("Cannot get a connection from Connection Pool", e);
		} catch (SqlException e) {
		    throw new DaoException("Exception in DAO layer when adding user", e);
		} finally {
		    try {
		        if (statement != null) {
		            statement.close();
		        }
		    } catch (SqlException e) {
		        throw new DaoException("Cannot free a connection from Connection Pool", e);
		} finally {
		    if (connection != null){
		        try {
		            mySQLConnectionPool.freeConnection(connection);
		        } catch (SqlException | MySqlConnectionPoolException e) {
		            throw new DaoException("Cannot free a connection from Connection Pool", e);
		            }
		        }
		    }
		}
		
	}

	@Override
	public void updateUser(User user) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByStatus(String status) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
