package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.AttendVO;

public interface AttendDAO {
	
	public void insertAttend(AttendVO attend);
	public List<String> getLastAttend(AttendVO attend);
	public void updateLastAttend(AttendVO attend);
}
