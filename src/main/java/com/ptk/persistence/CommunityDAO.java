package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.CommunityVO;

public interface CommunityDAO {

	public void CommunityPost(CommunityVO co); //글쓰기
	public List<CommunityVO> getCommunityList(CommunityVO co); //글불러오기
	public CommunityVO getPostingDetail(int uid);
}
