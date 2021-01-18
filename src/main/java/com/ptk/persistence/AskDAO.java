package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.AskVO;

public interface AskDAO {
	public void insertAsk(AskVO ask);
	public List<AskVO> getAskList();
	public AskVO getAskPage(Integer askUID);
}
