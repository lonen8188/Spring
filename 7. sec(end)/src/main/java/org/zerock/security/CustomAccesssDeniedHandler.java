package org.zerock.security;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomAccesssDeniedHandler implements AccessDeniedHandler { // 내가만든 접근차단핸들러

	@Override
	public void handle(
			HttpServletRequest request, HttpServletResponse response, 
			AccessDeniedException accessException) throws IOException, ServerException{
		
		log.error("CustomAccesssDeniedHandler에 handle메서드 실행 ");
		log.error("Redirect ...... ");
		response.sendRedirect("/accessError"); 
	}
}
