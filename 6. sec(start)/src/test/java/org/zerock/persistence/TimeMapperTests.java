package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //참고할 파일
@Log4j2 //Log4j2를 이용해서 로그 출력(콘솔에 찍히는 로그)
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
		
	@Test
	public void testGetTime() {
		
		log.info(timeMapper.getClass().getName()); // 인터페이스아래에.클래스명아래.이름출력
		log.info(timeMapper.getTime()); // select 메서드 실행
		
		
	}
	
	@Test
	public void testGetTime2() {
		
		
		log.info("getTime2");
		log.info(timeMapper.getTime2());
		
	}
	
	
}
