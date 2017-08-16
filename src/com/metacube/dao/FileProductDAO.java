package com.metacube.dao;
import java.util.HashMap;
import com.metacube.models.Product;

/**
 * FileProductDAO perform action on Product in File System
 * @author Rahul Kumar
 *
 */
public class FileProductDAO implements ProductDAO{
	private static FileProductDAO productsDAO;
	HashMap<String,Product> totalProducts = new HashMap<>();

	/**
	 * Private Constructor of Class FileProductDAO
	 */
	private FileProductDAO() {
		
	}
	
	/**
	 * getInstance method to get object 
	 * @return
	 */
	public static FileProductDAO getInstance() {
		if(productsDAO == null) {
			synchronized (FileProductDAO.class) {
				if(productsDAO == null) {
					productsDAO = new FileProductDAO();
				}
			}
		}
		
		return productsDAO;
	}
	
	/**
	 * method returns the all product
	 * @return
	 */
	public HashMap<String, Product> getAllProducts(){
		
		return totalProducts;
	}

	/**
	 * adds to file
	 * @return
	 */
	@Override
	public void add(String productCode, Product product) {
		totalProducts.put(productCode, product);
	}

	/**
	 * update to file
	 * @return
	 */
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * modify to file
	 * @return
	 */
	@Override
	public boolean modify() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * deletes to file
	 * @return
	 */
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * adds to file
	 * @return
	 */
	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}
}
