package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
//인터페이스는 단독으로 사용할수 없는 객체임 
//여기서 선언한 메서드는 추상메서드로 사용된다.(실행문이 없이 끝난다.)
//인터페이스를 사용하려면 구현 클래스를 만들고 실행문을 넣게 된다.
//인터페이스를 사용하는 이유는 조장이 메서드명을 강제로 셋팅하기 위함
	
	//조장이 만든 메서드명(시그니처)
	
	public void register(BoardVO board); // 게시판 등록용 메서드 
	
	
	public BoardVO get(Long bno); //게시글 자세히 보기 (번호를 넣으면 객체가 나와야한다.) 
	
	public boolean modify(BoardVO board);//게시글 수정 객체가 들어가서 수정됬는지 t/f
	
	public boolean remove(Long bno); //게시글 삭제하기 (번호가 들어가서 삭제됬는지 true or false)

	public List<BoardVO> getList(); 
	// 이메서드가 호출되면 리스타 타입으로 BoardVO객체들이 넘어온다.
	// List : 동적리스트 / < > 제네릭 : 강제로 객체타입을 정한다 
	
	
}
