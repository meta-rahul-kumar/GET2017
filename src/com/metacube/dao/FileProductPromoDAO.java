package com.metacube.dao;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.metacube.models.ProductPromo;
import com.metacube.utils.ReadFromFile;

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

	public void addData(String filepath) {
		ReadFromFile read = new ReadFromFile();
		int lineNo = 0;
		
		for(String altu : read.ReadCsvFile(filepath)) {
			StringTokenizer tokenizer = new StringTokenizer(altu, "\t"); // splits using \t seperator
			
			while(tokenizer.hasMoreTokens()) {
				ProductPromo productPromo = new ProductPromo();
				productPromo.setProductPromo(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				totalProductPromos.put(lineNo++, productPromo);
			}
			
		}
	}

}
