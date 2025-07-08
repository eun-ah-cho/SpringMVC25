package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //스프링이 알아서 의존성 처리 해줘! 
@Data //import lombok.Data; dto 처리용 get/setter /toString, equals 등 을 자동화 시켜줌 

public class Chef {
	private String name;
	private int age;
	
	
}
