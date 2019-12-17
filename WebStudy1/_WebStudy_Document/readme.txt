---------------환경설정------------------
[tomcat환경설정]
1.(이전체크사항)

 #Java설치환경
  JAVA_HOME=c:\Program files\Java\....

2.톰캣설치경로 등록
  CATALINA_HOEM=C:\apache-tomcat-8.5.47

##[오라클 web 포트변경]
  sqlplus system/oracle  
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