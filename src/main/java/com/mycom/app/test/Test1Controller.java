package com.mycom.app.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.emp.UserDTO;

//컨트롤러 역활을 하는 클래스. 따라서 @Controller 어노테이션을 붙여주자.
@Controller
public class Test1Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	//	RequestMapping의 속성
	//	value="요청주소"
	//	method="요청방식"
	//	method=RequestMethod.GET
	//	method=RequestMethod.POST
	//	method=RequestMethod.PUT
	
	@RequestMapping("logtest")
	public String logTest() {
		logger.trace("trace 메세지");
		logger.debug("debug 메세지");
		logger.info("info 메세지");
		logger.warn("warn메시지");
		logger.error("error 메시지");
		
		return "test/logtest";
	}
	
	//Exinterceptor를 이용하여 로깅작업을 수행하는 Method
	@RequestMapping("logtest2")
	public String logtest2() {
		logger.info("logtest2 진입");
		return "test/resultView";
	}
	
	
	@RequestMapping("logtest3")
	public String logtest3() {
		logger.info("logtest3 진입");
		return "test/resultView";
	}
	
	
	@RequestMapping(value="/requestMethod1", method=RequestMethod.GET)
	public String requestMethod1(Model model) {
		
		model.addAttribute("m1","맥은 m1pro칩이지");
		return "test/resultView";
	}
	
	
	
	
	/*
	 * 스프링 4.3 부터 지원하기 시작한 @GetMapping HTTP요청 방식을 단순화하고, 요청처리 메서드의 의미를 좀더 명확하게 표현
	 */
	//get요청방식 Spring 4.3.0 버전 이상부터 사용가능한 Annotation
	@GetMapping("requestMethod2")
	public String requestMethod2(Model model) {
		model.addAttribute("m2","아니야 맥은 신형 m2 pro칩이 최고지");
		return "test/resultView";
	}
	
	//@PathVariable 경로변수
	//그때그때 달라지는 요청 url을 효과적으로 변경하기위해 변수를 사용하여 그때그때 알맞은 url 맵핑을 도와준다
	@GetMapping("requestMethod3/{dName}")
	public String requestMethod3(Model model, @PathVariable String dName) {
		model.addAttribute("m3","@PathVariable 테스트");
		model.addAttribute("dName",dName);
		return "test/resultView";
	}
	
	//@Pathvariable 경로변수 응용편
	//요청주소 : localhost:포트번호/컨패/requestMethod4/sales/loc/seoul
	//요청주소 : localhost:포트번호/컨패/requestMethod4/marketing/loc/busan
	//요청주소 : localhost:포트번호/컨패/requestMethod4/develop/loc/jeju
	@GetMapping("requestMethod4/{dName}/loc/{location}")
	public String requestMethod4(Model model, @PathVariable String dName, @PathVariable String location) {
		model.addAttribute("m4","@PathVariable 테스트");
		model.addAttribute("dName",dName);
		model.addAttribute("location",location);
		return "test/resultView";
	}
	
	
	//model 처리
	//model.addAttribute(String 속성명,Object 값);
	//model.addAttribute(String 속성명,null); : null값을 허용함
	@GetMapping("requestMethod5")
	public String requestMethod5(Model model) {
		model.addAttribute("m5","model 테스트");
		model.addAttribute("m6", null);
		
		return "test/resultView";
	}
	
	//ModelandView
	//url mapping과 뷰를 한번에 설정해줄수도 있다.
	@GetMapping("requestMethod6")
	public ModelAndView requestMethod6(ModelAndView mv) {
		mv.addObject("m1", "modelView실습");
		mv.setViewName("test/resultView");
		
		return mv;
	}
	
	//파라미터값 관련
	@GetMapping("requestMethod7")
	public String requestMethod7(Model model, @RequestParam int bno, @RequestParam String title) {
		
		model.addAttribute("m10", "@RequestParam 테스트");
		model.addAttribute("m11", bno);
		model.addAttribute("m12", title);
		return "test/resultView";
	}
	
	//넘어오는 parameter 값이 있을경우 기존엔 request.getparameter를 이용하여 일일히 받았으나 
	//@requestParam을 이용하여 받아줄수있다.
	//요청주소 : localhost:포트번호/컨패/requestMethod7-1?no=?/
	@GetMapping("requestMethod7-1")  
	public String requestMethod7_1(Model model, HttpServletRequest req, 
									@RequestParam(name="no", required = false, defaultValue = "2") int no, 
									@RequestParam(name="name", defaultValue = "마케팅") String name) {
		
		//기존 parameter 받아오는 방식
		/*
		 * String strNo = req.getParameter("no"); no = Integer.parseInt(strNo);
		 * logger.info("no",no);
		 */
		
		model.addAttribute("m71", no*12);
		model.addAttribute("m72", name);
		
		return "test/resultView";
	}
	
	
	//여러개의 파라미터 한번에 받아오는 방법
	//요청주소 : localhost:포트번호/컨패/requestMethod8?name=??&
	@GetMapping("requestMethod8")
	public String requestMethod8(Model model, @RequestParam(name="name", defaultValue = "id") String name,
											  @RequestParam(name="email",defaultValue = "h@test.com") String email,
											  @RequestParam(name="age") int age,
											  @RequestParam(name="gender") String gender){
		
		
		
		model.addAttribute("m8_name",name);
		model.addAttribute("m8_email",email);
		model.addAttribute("m8_age",age);
		model.addAttribute("m8_gender",gender);
		return "test/resultView";
	}
	
	@GetMapping("requestMethod9")
	public String requestMethod9(Model model, UserDTO userDTO) {
		
		
		model.addAttribute("userDTO",userDTO);
		return "test/resultView";
	}
	
	
	//user정보를 입력할수있는 폼요청처리
	
	@GetMapping("userFRM")
	public String userFRM() {
		
		return "test/userFRM";
	}
	
	//동일한 파라미터의 여러개의 값
	@RequestMapping(value="requestMethod10")
	public String requestMethod10(Model model, @RequestParam String[] hobby) {
		model.addAttribute("hobby", hobby);
		return "test/resultView";
	}
	
	@RequestMapping(value="requestMethod11")
	public String requestMethod11(Model model, @RequestParam ArrayList<String> hobby) {
		
		System.out.println(hobby);
		model.addAttribute("hobby", hobby);
		return "test/resultView";
	}
	
	//@RequestMapping(value="reqMethod12", method = RequestMethod.GET) //밑의 GETMapping과 동일
	@GetMapping("reqMethod12") //4.3ver 이상부터 지원하는 GETMapping
	public String reqMethod12(@ModelAttribute("member") Member member) {
		logger.info("get방식");
		return "test/memberFrm";
	}
	
	@PostMapping("reqMethod12")
	public String reqMethod12(Model model, @ModelAttribute("member") Member member) {
		logger.info("post방식");
		System.out.println(member);
		model.addAttribute("member", member);
		return "test/memberInfo";
	}
	
	@GetMapping("addmember")
	public String addmember(@ModelAttribute("newMember") Member member) {
		logger.info("memberFrm2 get방식 진입");
		return "test/memberFrm2";
	}
	
	@ModelAttribute("newMember")
	public void addAttributes(Model model) {
		model.addAttribute("addMember","신규회원등록");
	}
	
	@PostMapping("addmember")
	public String postAddmember(@ModelAttribute("newMember") Member member , Model model) {
		logger.info("멤버정보:"+member.toString());
		model.addAttribute("member", member);
		return "test/memberInfo2";
	}
	
	
	//한묶음 메서드레벨의 @ModelAttribute
	/*
	 * 컨트롤러의 요청처리 메서드가 호출되고 view를 리턴해주기전에 modelattribute으로 선언된 메서드를 먼저 호출해준다 호출후
	 * 반환받은 값을 view의 모델로 넘겨준다
	 */
	@GetMapping("testModelAttribute")
	public String reqMethod16() {
		return "test/resultView";
	}
	@ModelAttribute("m1")
	public String setM1() {
		return "m1임";
	}
	
	//모델명 이름을 Annotation에 지정하지않는 방법
	//메서드 내부에서 model 값을 직접 지정
	@ModelAttribute
	public void setM2(Model model) {
		model.addAttribute("m2","m2라는뎁쇼");
	}
	//한묶음
	
	
	@RequestMapping(value="getMemberList", method= {RequestMethod.GET, RequestMethod.POST})
	public String getMemberList(Model model) {
		List<Member> memberList = new ArrayList<Member>();
		
		for(int i=1; i<6; i++) {
			Member member = new Member(i,"1234","서울시","남성");
			memberList.add(member);
		}
		
		model.addAttribute("member", memberList);
		return "test/memberList";
	}
	
	/*
	 * 요청메서드에서 view지정 view redirection(뷰 리다이렉션) 클라이언트가 요청하면 현재뷰에서 다른뷰페이지로 페이지 강제이동
	 * 
	 * @requestmapping("원래 최초 요청 url") public String adasdffdsa() { 
	 * return "정상적으로 보여주려던 jsp문서"; 가 아닌 
	 * return "redirect:강제페이지 이동할 url"; 혹은 
	 * return "forward:강제페이지이동할 url";
	 * }
	 * 1.redirect 방식
	 * 2.forward 방식
	 */
	
	@RequestMapping(value="getMembers", method= {RequestMethod.POST,RequestMethod.GET})
	public String getMembers(Model model, @ModelAttribute("newMember") Member member) {
		logger.info("member:"+member.toString());
		model.addAttribute("member",member);
		return "forward:getMemberList";
	}
}
