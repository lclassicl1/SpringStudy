package com.mycom.app.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//스프링 프레임워크에있는 유틸리티 스탑워치
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StopWatch stopwatch = new StopWatch(handler.toString());
	
		stopwatch.start(handler.toString()); //stopwatch 시작
		stopWatchLocal.set(stopwatch);
		
		//logger.info("모니터링preHandler 진입");
		logger.info("접근경로"+getPath(request));
		logger.info("요청 처리 시작 시간:"+getCurrentTime());
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			//logger.info("모니터링postHandler 진입");
			logger.info("요청처리 종료 시간:"+getCurrentTime());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
			//logger.info("모니터링afterCompletion 진입");
			StopWatch stopwatch = stopWatchLocal.get();
			stopwatch.stop(); //stopwatch 종료
			logger.info("요청처리 소요시간:"+stopwatch.getTotalTimeMillis()+"/ms");
			stopWatchLocal.set(null); //초기화
			logger.info("============================");
	}
	
	//접근 경로 구하기
	//http://localhost:8083/app/qwert?q=1&w=123
	private String getPath(HttpServletRequest req) {
		String url = req.getRequestURI();
		String queryS = req.getQueryString();
		
		queryS = queryS == null ? "" : "?"+queryS;
		
		return url+queryS;
	}
	
	
	//현재 시스템의 시간 구하기
	private String getCurrentTime() {
		//현재시간
		//Calendar 클래스는 new 생성자가 아닌 getInstance로 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//밀리초세컨드로 변환
		cal.setTimeInMillis(System.currentTimeMillis());
		
		//포맷변경
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String nowTime = sFormat.format(cal.getTime());
		
		
		return nowTime;
	}
}



