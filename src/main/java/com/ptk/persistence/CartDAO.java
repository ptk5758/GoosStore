package com.ptk.persistence;

import java.util.List;
import java.util.Map;

import com.ptk.domain.CartVO;
import com.ptk.domain.ShopVO;

public interface CartDAO {
	public void addToCart(CartVO vo);
	public int itemuid(int uid);
	public void updateAmount(CartVO vo);
	public void incartupdateAmount(Map<String,Object> paramap);
	public int cartamount(String sessionid);
	public List<CartVO> cartlist(String sessionid);
	public int deletecart(int uid);
	
}
