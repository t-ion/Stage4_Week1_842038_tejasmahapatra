package com.cognizant.truyum.controller;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menuitem")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/all")
	public ArrayList<MenuItem> getAllMenuItems() {
		LOGGER.info("START Controller getAllMenuItems() START");

		ArrayList<MenuItem> menuItemsList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("MenuItem List: {}", menuItemsList);
		LOGGER.info("END Controller getAllMenuItems() END");
		return menuItemsList;
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItemId(@PathVariable long id) throws MenuItemNotFoundException {
		LOGGER.info("START Controller getMenuItemId");

		MenuItem menuItem = menuItemService.getMenuItem(id);
		LOGGER.debug("MenuItem: {}", menuItem);
		LOGGER.info("END Controller getMenuItemId");

		return menuItem;
	}

	@PutMapping("/edit")
	public ResponseEntity<Object> modifyMenuItem(@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException {
		
		LOGGER.info("START Controller modifyMenuItem");
		
		menuItemService.modifyMenuItem(menuItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(menuItem.getId())
                .toUri();
		LOGGER.info("END Controller modifyMenuItem");
		return ResponseEntity.created(location).build();
	}

}