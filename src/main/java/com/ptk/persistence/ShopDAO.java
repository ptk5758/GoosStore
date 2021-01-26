package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;
import com.ptk.domain.UserVO;

public interface ShopDAO {

	public void insertSeller(SellerVO seller);
	public List<SellerVO> getSeller();
	public UserVO getSellerOne(String sessionID);
}
