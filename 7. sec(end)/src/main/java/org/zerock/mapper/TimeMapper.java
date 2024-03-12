package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual") //주의사항 sql문 뒤에 ; 사용하면 오류
	public String getTime();
	
	public String getTime2(); // xml로 매핑하는 sql 문
}
