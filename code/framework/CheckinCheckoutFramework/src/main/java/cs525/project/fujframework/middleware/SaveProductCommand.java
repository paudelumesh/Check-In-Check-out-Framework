/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 * 
 */

package cs525.project.fujframework.middleware;

import cs525.project.fujframework.core.Product;
import cs525.project.fujframework.core.ProductFacade;
import cs525.project.fujframework.core.ProductFacadeImpl;

/**
 * concrete command for product save operation
 * 
 * @author Jivan Nepali
 * 
 * @version 1.0.0
 *
 */
public class SaveProductCommand implements Command {

	private Product product;
	private ProductFacade facade;

	public SaveProductCommand(Product product) {
		this.product = product;
		facade = new ProductFacadeImpl();
	}

	@Override
	public boolean execute() {
		int affectedRows = facade.saveProduct(product);
		return affectedRows == 1 ? true : false;
	}

	@Override
	public boolean undo() {
		int affectedRows = facade.removeProduct(product);
		return affectedRows == 1 ? true : false;
	}

}
