package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		log.warn("Login Success"); 
		// 콘솔에 성공 출력

		List<String> roleNames = new ArrayList<>(); 
		// 리스트(문자열) 권한리스트 등록

		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		}); 
		// security-context.xml에 있는 hasRole 값을 가져와 roleNames에 넣음
		// ROLE_MEMBER , ROLE_ADMIN 가 있음
		log.warn("ROLE NAMES: " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sample/admin");
			return;
		} //ROLE_ADMIN이면 response(응답을 /sample/admin으로 보냄)

		if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/sample/member");
			return;
		} // ROLE_MEMBER이면 response(응답을 /sample/member으로 보냄)

		response.sendRedirect("/");
		// 권한이 없으면 http://localhost/로 보냄
	}
}


