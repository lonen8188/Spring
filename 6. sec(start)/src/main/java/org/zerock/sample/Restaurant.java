package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired ) //객체 자동 주입 후 연결
	private Chef chef ; //필드 값으로 chef 객체를 생성
}
