package com.ptk.persistence;

import java.util.List;
import java.util.Map;

import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;
import com.ptk.domain.UserVO;

public interface ShopDAO {

	public void insertSeller(SellerVO seller);
	public List<SellerVO> getSeller();
	public UserVO getSellerOne(String sessionID);
	public SellerVO getSellerVO(String sessionID);
	public void modifySeller(SellerVO seller);
	public void itemInsert(ShopVO shop);
	public List<String> getCategory();
	public void addCategory(String category);
	public List<ShopVO> getSellerItemList(String sellerID);
	public ShopVO getViewItemVO(Map<String, Object> map);
	
	/**
	 * 
	 * ## shopVO 를 가져오는 메서드 
	 * @param 아이템 유니크 아이디
	 * 
	 */
	public ShopVO getCartShopList(Integer itemUID);
}
