package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	 private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
	 
	 @Autowired
	 private BoardMapper mapper;

	 /*
	 @Test
	 public void testEnroll() {
		 
		 BoardVO vo = new BoardVO();
		 
		 vo.setTitle("mapper test");
		 vo.setContent("mapper test");
		 vo.setWriter("mapper test");
		 
		 mapper.enroll(vo);
		 
	 }*/
	 
	 
	/* 게시판 목록 테스트 */
	 /*
	 @Test
	 public void testGetList() {
		 
		 
		 List list = mapper.getList();
		// 일반적 for문 
		// for(int i = 0; i < list.size();i++) {
		//	 log.info("" + list.get(i));
		// }
		 
		 
		// foreach문(향상된 for문) 
		// for(Object a : list) {
		//	 log.info("" + a);
		// }
		 
		 
		// foreach문 & 람다식 
		// list.forEach(board -> log.info("" + board));
		 
	 }
	 */
	 
	/* 게시판 조회 */
	 /*
	 @Test
	public void testGetPage() {
		
		// 실제 존재하는 페이지 
		int bno = 8;
		
		log.info("" + mapper.getPage(bno));
		
	}
	*/
	 
	 
		/* 게시판 수정 */
	 /*
	 @Test
	 public void testModify() {
		 
		 BoardVO board = new BoardVO();
		 board.setBno(8);
		 board.setTitle("수정페이지");
		 board.setContent("수정수정");
		 
		 int result = mapper.modify(board);
		 log.info("result : " +result);
		 
	 }	
	 */
	 
	/* 게시판 삭제 */
	@Test
	public void testDelete() {
		
		int result = mapper.delete(11);
		log.info("result : " + result);
		
	}
	 
	 
	 
}
