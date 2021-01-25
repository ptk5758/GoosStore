package com.ptk.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.ShopVO;
import com.ptk.persistence.ShopDAO;

@RestController
@RequestMapping("/shopList/")
public class ShopRestController {

	@Inject
	private ShopDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopRestController.class);
	
	
}