package com.esport.dao.factory;

import java.util.ResourceBundle;

import com.esport.dao.exception.DaoException;

public abstract class DaoFactory {
    private static final String RESOURCE_BUNDLE_NAME = "dao-factory";
    private static final String FACTORY_CLASS_KEY = "factory-class";

	private static DaoFactory instance;
	
	public static synchronized DaoFactory getInstance() throws DaoException {
        if(instance == null){
            try {
                ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
                String factoryClassName = resourceBundle.getString(FACTORY_CLASS_KEY);
                instance = (DaoFactory) Class.forName(factoryClassName).newInstance();
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                throw new DaoException("Cannot init a DaoFactory", e);
            }
        }
        return instance;
    }
}
