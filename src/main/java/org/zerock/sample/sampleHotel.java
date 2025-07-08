package org.zerock.sample;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor // 모든 필드값을 이용하여 생성자 주입 
@RequiredArgsConstructor //@NonNull 만 생성자로 넣음. All은 다때려박는거고 , @RequiredArgsConstructor 은 필요한것만 
public class sampleHotel {
	//묵시적 자동 주입 : 
	// 스프링의 의존성 주입은 생성자 주입과 세터 주입을 자주 사용한다.
	// 생성자 주입은 롬복이 알아서 파라미터를 만들어 줌. 
	// 생성자 주입의 경우 객체 생성 시 의존성 주입이 필요하므로 좀더 엄격하게 의존성 주입을 체크함. 
	// 세터 주입은 값을 저장시 자동으로 생성해줌. @Setter(onMethod_ = @Autoowired)
	@NonNull
	private Chef chef; //필드 
	
	private Restaurant restaurant;
	private String name;
	
}