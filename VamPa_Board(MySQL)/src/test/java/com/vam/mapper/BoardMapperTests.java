package com.vam.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	 @Test
	 public void testGetList() {
		 
		 
		 List list = mapper.getList();
		/* 일반적 for문 */
		/* for(int i = 0; i < list.size();i++) {
			 log.info("" + list.get(i));
		 }*/
		 
		 
		/* foreach문(향상된 for문) */
		 /*for(Object a : list) {
			 log.info("" + a);
		 }*/
		 
		 
		/* foreach문 & 람다식 */
		 list.forEach(board -> log.info("" + board));
		 
	 }
	 

}
