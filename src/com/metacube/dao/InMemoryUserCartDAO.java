package com.metacube.dao;
import java.util.HashMap;

/**
 * InMemoryUserCartDAO perform action on UserCart in File System
 * @author Rahul Kumar
 *
 */
public class InMemoryUserCartDAO implements UserCartDAO{
	private static InMemoryUserCartDAO userCartDAO;
	HashMap<Integer,Integer> userCartProducts=new HashMap<Integer,Integer>();  
	
	/**
	 * private InMemoryUserCartDAO constructor
	 */
	private InMemoryUserCartDAO() {
		
	}
	
	/**
	 * getInstance method of InMemoryUserCartDAO
	 * @return
	 */
	public static InMemoryUserCartDAO getInstance() {
		if(userCartDAO == null) {
			synchronized (InMemoryUserCartDAO.class) {
				if(userCartDAO == null) {
					userCartDAO = new InMemoryUserCartDAO();
				}
			}
		}
		
		return userCartDAO;
	}
	
	/**
	 * returns all cart products
	 * @return
	 */
	public HashMap<Integer, Integer> getAllCartProducts(){
		
		return userCartProducts;
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
	 * delete to file
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
	public void add(int productCode, int productQuantity) {
		// TODO Auto-generated method stub
		userCartProducts.put(productCode, productQuantity);
	}

}
