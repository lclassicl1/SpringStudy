package com.mycom.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.HomeController;

/*Interceptor 클래스
특정 URL을 요청할때 컨트롤러로 가는 요청 도중 특정 작업을 처리하는것을 의미한다
따라서 컨트롤러가 응답(response)하기 전에 handler interceptor 라고도 칭한다

컨트롤러에 들어오는 요청(Request)과 응답(response)를 가로채는 역활을 한다
인터셉터는 
컨트롤러의 요청이 들어가기 전!에 실행하게 할수도있고 
요청이 완료된 이후에 실행이 되게 할수도있다
혹은 요청을 수행하여 view를 보여준후에도 실행 가능하다

* 사용예 - 
* spooling : 응답페이지를 출력하기전에 서버에서 미리 데이터가져오기 기능
* 요청이 처리되기전에 파일을 업로드(multipart)기능
* logging : 각 요청에 대한 상세내역을 기록하는 기능
* validation : 유효성 검사 기능
* 폼에서 제출(submit)이 중복으로 일어나는것을 막는 기능
*/
 
/*1. 인터셉터 등록
servlet-context.xml 파일에
<interceptors>
<beans:bean class="com.mycom.app.interceptor.ExInterceptor"></beans:bean>
</interceptors>로 등록

*2. 등록된 인터셉터빈 내용 구현
*여기에서는 HandlerInterseptor 인터페이스를 구현하여 진행
* -HandlerInterserptor인터페이스
* preHandle() : 컨트롤러에서 요청이 들어가기 전에 호출.  false를 리턴하면 이후의 내용을 수행하지않는다
* postHandle(): 컨트롤러에 요청을 처리한후 호출, 컨트롤러에서 예외가 발생하면 더이상 실행하지 않는다
* afterCompletion() : 컨트롤러에 요청을 수행한후 view를 보여준후 호출. 
*/
public class ExInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(ExInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("aftercompletion");
	}
	
	

}
