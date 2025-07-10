package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller //servlet-context.xml에서 <context:component-scan base-package="org.zerock.controller" /> 넣어서 자동으로 자바파일이 서블릿 반영
@RequestMapping("/sample/*") //요청이왔을때 1:1매칭. http://192.168.111.104:80/controller/sample/ 모든것에 반응 
@Log4j2 // resources 폴더에 log4j2.xml 필수 
public class SampleController {
	@RequestMapping("") //http://192.168.111.104:80/controller/sample/
	
	public void basic() {
		log.info("SampleController.basic() 메서드 실행......");
		log.info("리턴이 void이기 때문에 basic.jsp 파일을 찾습니다. ");
		log.info("현재/WEB-INF/View/basic.jsp가 없음으로 크롬에는 오류가 납니다.");
		//리턴이 void임 . 기본적으로 url에 경로에 대한 jsp를 찾으려고 한다.
		} 
	@RequestMapping(value="/basic", method= {RequestMethod.GET,RequestMethod.POST})
	//http://192.168.111.104:80/controller/sample/basic -> get메서드와 post 메서드에 동작
	public void basicGet() { 
		log.info("SampleController.basicGet() 메서드 실행........");
		log.info("get방식과 post 방식 둘다 반응한다.................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void baseicGet2() { 
		log.info("SampleController.basicGet2() 메서드 실행........");
		log.info("get방식 반응한다.................");
	}
	@PostMapping("/basicOnlyPost")
	public void basicPost2() {
		log.info("SampleController.basicpost() 메서드 실행........");
		log.info("get방식 반응한다.................");
	}

	@GetMapping("/ex01") //http://192.168.111.104:80/controller/sample/ex01?name=kkkw&age=33
	public String ex01(SampleDTO dto) { //SampleDTO dto= new SampleDTO(); 
		
		
		log.info("SampleController.ex01() 메서드 실행........");
		log.info("get방식 반응한다.................");
		log.info("입력 dto 확인 : " + dto);
		
		return "ex01"; //WEB-INF/views/ex01.jsp ->servlet-context.xml이 하는일 
	}	
	
	@GetMapping("/ex02")  //http://192.168.111.104:80/controller/sample/ex02
	private String ex02(@RequestParam("name") String name, @RequestParam("age") int age ) {
	//프론트의 변수의 백엔드의 변수가 다를때!!!(초보자는 일치 시킬것!) 
		log.info("name + "+ name );
		log.info("age + " + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	//http://192.168.111.104:80/controller/sample/ex02List?ids=1111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		//리스트로 넘어오는 데이터를 처리해보자.
		
		log.info("리스트로 넘어온 데이터 처리 :" + ids );
		log.info("리스트로 2번째 값 확인:" + ids.get(1) );
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		//url  경로에 배열로 들어오는 파라미터 
		// /ex02Bean? list[0].name=kkw&list[2].age=33
		log.info("list SampleDTOs : " + list); 
		
		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo : " + todo); 
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto:" + dto); // name, age
		log.info("page:" + page);
		return "/sample/ex04"; //views/sample/ex04.jsp
	}
	
	@GetMapping("/ex05")
	public void ex05() { 
		log.info("SampleController.ex05메서드 실행....");
		//리턴이 void인 경우에는 자동으로 찾는다.
		//초보자 사용금지!!!void는 이제 쓰지마아 
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		//@ResponseBody SampleDTO :응답바디에 객체를 담아 리턴을 한다. 
		log.info("SampleController.ex06메서드 실행....");
		
		SampleDTO dto= new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("SampleController.ex07메서드 실행....");
		String msg = "{\"name\": \"홍길동\"}"; //json으로 { name:홍길동} 
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
}
