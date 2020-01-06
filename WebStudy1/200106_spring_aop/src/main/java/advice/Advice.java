package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice{
	
	@Autowired
	HttpServletRequest request;
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
		System.out.println("----before:" + s);
		
		long start = System.currentTimeMillis(); 
		request.setAttribute("start", start);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		System.out.println("----after:" + s.toLongString());
		
		long end = System.currentTimeMillis();
		long start = (Long) request.getAttribute("start");
		System.out.println(end-start);
	}
}
