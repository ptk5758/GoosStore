package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.ShopVO;

public interface ShopDAO {

	public void shopPosting(ShopVO shop);
	public List<String> getCategory(String itemMidCategory);
	public List<ShopVO> getShopList();
	public List<ShopVO> getShopListMidselect(String itemMidCategory);
	public List<ShopVO> getShopListBottomSelect(String itemBottomCategory);
}
