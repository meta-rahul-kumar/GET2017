package com.metacube.dao;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.metacube.models.OrderPromo;
import com.metacube.utils.ReadFromFile;

/**
 * FileOrderPromoDAO perform action on OrderPromo in File System
 * @author Rahul Kumar
 *
 */
public class FileOrderPromoDAO implements OrderPromoDAO{
	private static FileOrderPromoDAO orderPromoDAO;
	HashMap<Integer,OrderPromo> totalOrderPromos = new HashMap<>();

	/**
	 * FileOrderPromoDAO Constructor
	 */
	private FileOrderPromoDAO() {
		
	}
	
	/**
	 * method creates the instance of FileOrderPromoDAO
	 * @return
	 */
	public static FileOrderPromoDAO getInstance() {
		if(orderPromoDAO == null) {
			synchronized (FileOrderPromoDAO.class) {
				if(orderPromoDAO == null) {
					orderPromoDAO = new FileOrderPromoDAO();
				}
			}
		}
		
		return orderPromoDAO;
	}
	
	/**
	 * Returns all Order Level Promos
	 * @return
	 */
	public HashMap<Integer, OrderPromo> getAllOrderPromos(){
		
		return totalOrderPromos;
	}
	
	/**
	 * adds to Database or file
	 * @return
	 */
	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * update to Database or file
	 * @return
	 */
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * modify to Database or file
	 * @return
	 */
	@Override
	public boolean modify() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * delete to Database or file
	 * @return
	 */
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	public void getAllOrderPromoFromFilePath(String filepath) {
		// TODO Auto-generated method stub
		ReadFromFile read = new ReadFromFile();
		int lineNo = 0;
		for(String altu : read.ReadCsvFile(filepath)) {
			StringTokenizer tokenizer = new StringTokenizer(altu, "\t");
			while(tokenizer.hasMoreTokens()) {
				OrderPromo orderPromo = new OrderPromo();
				orderPromo.setOrderPromo(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				totalOrderPromos.put(lineNo++, orderPromo);
			}
		}
	}
	
}
