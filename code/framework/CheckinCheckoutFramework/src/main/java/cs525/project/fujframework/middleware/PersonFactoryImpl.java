/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 * 
 */
package cs525.project.fujframework.middleware;

import cs525.project.fujframework.core.Customer;

/**
 * factory method implementation to create persons
 * 
 * @author paudelumesh
 *
 * @version 1.0.0
 */
public class PersonFactoryImpl implements PersonFactory {
	private static PersonFactory factory = new PersonFactoryImpl();

	/**
	 * private constructor to avoid instantiation
	 */
	public PersonFactoryImpl() {
	}

	public static PersonFactory getFactory() {
		return factory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cs525.project.fujframework.middleware.PersonFactory#createPerson(java.
	 * lang.String)
	 */
	@Override
	public Person createPerson(String type) {
		Person person = null;
		if (type.equals("customer")) {
			person = new Customer();
		} else if (type.equals("sysuser")) {
			person = new SysUser();
		}
		return person;
	}

}
