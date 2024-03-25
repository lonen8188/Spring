package org.zerock.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
// MemberVO를 UsersDetails 타입으로 변환하기
	
	private static final long serialVersionUID = 1L;

	private MemberVO member;
	// VO 객체 생성
	
	//CustomUser의 매개변수의 다형성
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	} // username, password, authorities를 받아 부모 객체에게 전달 

	public CustomUser(MemberVO vo) {

		super(vo.getUserid(), vo.getUserpw(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		//AuthVO인스턴스틑 GrantedAuthority 객체로 변환해야 되므로 .stream().map() 이용해 처리
		this.member = vo;
	} // vo 객체를 받아 vo로 생성
	
}
