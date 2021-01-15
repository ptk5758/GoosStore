package com.ptk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ptk.domain.AttendVO;
import com.ptk.domain.UserVO;

public interface AttendDAO {
	
	public void insertAttend(AttendVO attend);
	public List<String> getLastAttend(AttendVO attend);
	public void updateLastAttend(AttendVO attend);
	public List<AttendVO> getAttendList(String date);
	public void attendUpdate(AttendVO attend);
	public void attendDelete(AttendVO attend);
	public int getAttendCount(String date);
	
}
