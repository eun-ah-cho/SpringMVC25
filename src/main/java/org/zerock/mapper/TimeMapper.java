package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper { 
//인터페이스는 추상메서드를 사용한다. 메서드가 있는데 메서드에 이름만있음. 안에 실행코드가 없음. 실행코드는 조원 (메서드명만 존재.실행문없음)
//사용하려면 클래스에 <implements + 인터페이스명> 을 사용한다.
	
	@Select("SELECT sysdate FROM dual") // 주의 사항! < ; 없다! >  
	public String getTime(); //인터페이스에 선언된 메서드는 추상메서드로 실행문이 없다. 
	//관례 : sql 쿼리문은 대문자로 쓰는게 관례다. 
	
	public String getTime2();
	//이메서드가 호출되면 마이바티스에서 xml을 찾음 
	//src/main/resources/zerock/mapper/TimeMapper.xml을 활용한다.
	
	
}
