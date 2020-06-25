package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	private CartDaoCollectionImpl cartDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("START CartService addCartItem");

		cartDaoCollectionImpl.addCartItem(userId, menuItemId);

		LOGGER.info("END CartService addCartItem");
	}

	public ArrayList<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("START CartService  getAllCartItems");

		LOGGER.info("END CartService  getAllCartItems");
		return cartDaoCollectionImpl.getAllCartItems(userId);
	}
	
	public void removeCartItem(String userId, long menuItemId) {
		
		LOGGER.info("START CartService removeCartItem");

		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);

		LOGGER.info("END CartService removeCartItems");
	}
}
