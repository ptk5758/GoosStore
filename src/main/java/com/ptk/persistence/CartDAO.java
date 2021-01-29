package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.CartVO;

public interface CartDAO {
	
	public void insertCart(CartVO cart);
	public boolean checkCart(CartVO cart);
	public void addCart(CartVO cart);
	public List<CartVO> getCartList(String userID);
	public void deleteCartItem(Integer cartUID);
}
