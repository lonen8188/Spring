관련 프로그램 설치
1. jdk(11버전) -> 환경변수(JAVA_HOME)
2. 톰켓(9버전) -> 포트번호(ADMIN : 8000, HTTP 1.1 : 80)
3. 이클립스 설치 안됨(마켓플레이스 SPRING 지원 종료) -> sts 3버전
4. lombok.jar(홈페이지에서 다운) -> d: 저장
   -> cmd -> d: 엔터 -> java -jar lombok.jar -> 팝업에 install 클릭 -> close
5. sts 구동 -> d:\sts-workspace 경로 -> sts 구동 완료
6. new -> server 셋팅 -> tomcat 9.0 연동

프로젝트 생성시 처음 해야 할 것 

0. 이클립스 utf-8 인코딩(html, css, js)변경 -> 폰트 설치(d2 Coding 폰트) 
1. mvc 프로젝트 생성 (프로젝트 우클릭 -> properties -> Resource (utf-8))
  (sts인 경우 기존 프로젝트를 프로젝트 익스플로러에서 copy -> paste 프로젝명 변경 -> pom.xml에 8행 변경)
2. web.xml(2행)을 찾아서 톰켓 web.xml(17행)과 버전 일치
3. pom.xml을 찾아서 버전 관리 
   - 스프링 버전 5버전 이후로 설정 (12행)
   - jdk 버전 11버전 이후로 설정 (11, 141, 142행)
4. 톰켓에 add -> 프로젝트 연결 -> 톰켓 더블클릭 -> Modules 탭에 / 컨텍스트패스 확인
5. 톰켓 start -> 크롬 -> http://ip주소:포트/컨텍스트루트명(www) 
   -> http://192.168.111.105/www (초기화면 나옴)
6. 오라클 설치 -> 포트번호 1521 -> system/oracle
   -> cmd -> sqlplus system/oracle 
   -> 사용할 계정 생성, 권한 부여 (이클립스에 있는 dataSource explorer를 활용)
7. 프로젝트에 ojdbc8.jar 연결 
   -> 프로젝트 우클릭 -> Build Path -> Libraries -> Classpath : add 
   -> Web DeploymentAssembly 확인

프로젝트 기본 셋팅
1. lombok을 프로젝트에 적용 (35행)
	<!-- lombok 실행 코드 주입 -->
	<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
	<dependency>
	    <groupId>org.projectlombok</groupId>
		    <artifactId>lombok</artifactId>
		    <version>1.18.24</version>
		    <scope>provided</scope>
	</dependency>


2. spring-test 코드 주입
	<!-- spring-test 코드 주입 -> log를 작성 log4j를 log4j2로 변경-->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<version>${org.springframework-version}</version> <!-- 위에 정의된 버전 활용-->
	</dependency>


3. spring은 system.out.println안씀 -> log.info (log4j2) -> resources 폴더에 log4.xml 삭제 -> log4j2.xml 교체
	<!-- log4j2 활성화 : resources log4j2.xml 변경 https://logging.apache.org/log4j/2.x/maven-artifacts.html -->
	<dependency> 
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-api</artifactId>
		    <version>2.18.0</version>
	</dependency>
	<dependency>
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-core</artifactId>
		    <version>2.18.0</version>
	</dependency>


4. junit 버전 상향 137행
	<!-- Test -->
	<dependency> <!-- 메스드별 테스트 진행용 -->
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency> 

5. sts에서 pom.xml 첫줄 오류 해결 (plugins 아래쪽에 삽입)
	<plugin>
	<!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-war-plugin -->
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-war-plugin</artifactId>
		<version>3.3.2</version>
	</plugin>	






