package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private MenuItemDao menuItemDao;
	@Autowired 
	private MenuItemDaoCollectionImpl menuItemDaoImpl;
	
	public ArrayList<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("START MenuItemService getMenuItemListCustomer");
		ArrayList<MenuItem> listOfMenuItem = menuItemDaoImpl.getMenuItemListCustomer();
		
		LOGGER.debug("List:", listOfMenuItem);
		LOGGER.info("END MenuItemService getMenuItemListCustomer");
		return listOfMenuItem;
	}
	
	public MenuItem getMenuItem(long id)
	{
		LOGGER.info("START MenuItemService getMenuItem");
		MenuItem menuItem = menuItemDaoImpl.getMenuItem(id);
		
		LOGGER.debug("MenuItem: {}",menuItem);		
		LOGGER.info("END MenuItemService getMenuItem");
		return menuItem;
	}
	
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("START MenuItemService modifyMenuItem");
		
		menuItemDaoImpl.modifyMenuItem(menuItem);
		
		LOGGER.info("END MenuItemService modifyMenuItem");
		return;
	}
}
