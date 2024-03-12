package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component //스프링이 관리해라!!!
@ToString //객체를 문자열로 표시
@Getter   //게터 생성
@RequiredArgsConstructor //생성자 자동 주입
public class SampleHotel {	
	
	//필드
	private Chef chef ;
	@NonNull //생성자 자동으로 하지 말아라
	private Restaurant restaurant;
	//생성자 (단일 생성자 작성 : @Autowired 없이 수동 주입)
	/*
	 * public SampleHotel(Chef chef) { this.chef = chef; }
	 */
	
	
	//메서드

}
