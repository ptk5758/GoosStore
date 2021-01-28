package com.ptk.persistence;

import com.ptk.domain.CartVO;

public interface CartDAO {
	
	public void insertCart(CartVO cart);
	public boolean checkCart(CartVO cart);
	public void addCart(CartVO cart);
}
