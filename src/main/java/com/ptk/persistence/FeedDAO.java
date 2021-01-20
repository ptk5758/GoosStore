package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.FeedVO;

public interface FeedDAO {
	public void insertFeed(FeedVO feed);
	public List<FeedVO> getFeedList(Integer askUID);
}
