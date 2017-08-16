package com.metacube.dao;
import java.util.HashMap;
import com.metacube.models.ProductPromo;

/**
 * FileProductPromoDAO perform action on ProductPromo in File System
 * @author Rahul Kumar
 *
 */
public class FileProductPromoDAO implements ProductPromoDAO{
	private static FileProductPromoDAO productPromoDAO;
	HashMap<Integer,ProductPromo> totalProductPromos = new HashMap<>();

	/**
	 * FileProductPromoDAO private constructor
	 */
	private FileProductPromoDAO() {
		
	}
	
	/**
	 * getInstance Method of class FileProductPromoDAO
	 * @return
	 */
	public static FileProductPromoDAO getInstance() {
		if(productPromoDAO == null) {
			synchronized (FileProductPromoDAO.class) {
				if(productPromoDAO == null) {
					productPromoDAO = new FileProductPromoDAO();
				}
			}
		}
		
		return productPromoDAO;
	}
	
	/**
	 * returns all Product level Promos
	 * @return
	 */
	public HashMap<Integer, ProductPromo> getAllProductPromos(){
		
		return totalProductPromos;
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
	 * updates to file
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
	public void add(int promoID, ProductPromo productPromo) {
		// TODO Auto-generated method stub
		totalProductPromos.put(promoID, productPromo);
	}

}
