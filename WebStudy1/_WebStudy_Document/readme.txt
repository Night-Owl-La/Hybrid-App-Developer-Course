---------------환경설정------------------
[tomcat환경설정]
1.(이전체크사항)

 #Java설치환경
  JAVA_HOME=c:\Program files\Java\....

2.톰캣설치경로 등록
  CATALINA_HOEM=C:\apache-tomcat-8.5.47

##[오라클 web 포트변경]
 1)sqlplus system/oracle  
   SQL>exec dbms_xdb.sethttpport(9000);
   SQL>exec dbms_xdb.sethttpport(8080);

3.톰캣서버환경설정
  1)서비스port와 인코딩설정
    톰캣설치폴더\conf\server.xml
    C:\apache-tomcat-8.5.47\conf\server.xml
    <Connector URIEncoding="utf-8"  port="9090" ..>

  2)웹컨텐츠의 접근권한/갱신속성지정
    톰캣설치폴더\conf\context.xml 
    <Context privileged="true" reloadable="true">
    </Context>
 

----------------------------------------

---------------JSP EL------------------

#정의 : EL (Expression Language) : JSP 내의 값을 출력하는 언어.
 - 별도의 Import 작업 없이 JSP에서 바로 사용가능.
#기능 : Servlet과 JSP 사이 공유하는 파라미터 값을 JSP에서 핸들링하는 기능.

#형식 : ${ 영역이름.값 }

#참조순서
pageScope [자기자신만 사용 할 수 있는 영역]
-> requestScope [request만 사용 할 수 있는 영역]
-> sessionScope [user별 사용 할 수 있는 영역]
-> applicationScope [서버 시작~서버 종료까지 모두가 사용 할 수 있는 영역]

#생략식 :  ${ 값 }

---------------JSP JSTL------------------

#정의 : JSTL (JSP Standard Tag Library) : JSP 내에서 사용되는 Tag 라이브러리.
 - 필수조건 : 톰캣에 'JSTL Tag 라이브러리' 추가해야 사용가능.
	C:\apache-tomcat-8.5.47\webapps\examples\WEB-INF\lib
	 taglibs-standard-impl-1.2.5.jar
	 taglibs-standard-spec-1.2.5.jar
위의 파일 2개를 여기에 복사해놓는다
C:\apache-tomcat-8.5.47\lib

 - 필수조건2 : <%@taglib prefix="API명" uri="라이브러리 경로"%> 선언.
	ex) <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

Core : <c:if> = if forEach choose ... set
Fmt : <fmt:formatNumber> = 숫자, 날짜 포맷 //Formator.
Fn : <.. value=${ fn:substring(NAME,0,3) } //Function.