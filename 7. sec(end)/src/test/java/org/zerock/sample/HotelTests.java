package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //참고할 파일
@Log4j2 //Log4j2를 이용해서 로그 출력(콘솔에 찍히는 로그)
public class HotelTests {

	@Setter(onMethod_ = @Autowired) // lombok 자동 주입
	private SampleHotel hotel ; // 테스트용 필드 생성 
	
	@Test // 메서드 단위로 테스트 됨
	public void testExist() {
		
		assertNotNull(hotel);
		log.info(hotel);
		log.info("--------------------------");
		log.info(hotel.getChef());
		
		
	}
	
	
	
}
