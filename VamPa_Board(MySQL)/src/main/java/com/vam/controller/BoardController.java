package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.model.PageMakerDTO;
import com.vam.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	
	/* 게시판 목록 페이지 접속 */
	/*
	@GetMapping("/list")
	// => @RequestMapping(value="list", method=RequestMethod.GET)
	public void boardListGET(Model model) {
		
		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list", bservice.getList());
		
	}
	*/
	
	/* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		
		log.info("boardListGET");
		
		log.info("cri : " + cri);
		
		model.addAttribute("list", bservice.getListPaging(cri));
		
		int total = bservice.getTotal(cri);
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMake);
		
	}	
	
	/* 게시판 등록 페이지 접속 */
	@GetMapping("/enroll")
	// => @RequestMapping(value="enroll", method=RequestMethod.GET)
	public void boardEnrollGET() {
		
		log.info("게시판 등록 페이지 진입");
		
	}
	
	/* 게시판 등록 */
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		
		log.info("BoardVO : " + board);
		
		bservice.enroll(board);
		
		log.info("BoardVO : " + board);
		
		rttr.addFlashAttribute("result", "enrol success");
		
		return "redirect:/board/list";
		
	}
	
	/* 게시판 조회 */
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model, Criteria cri) {
		
		model.addAttribute("pageInfo", bservice.getPage(bno));
		
		model.addAttribute("cri", cri);
		
	}
	
	
	/* 수정 페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model, Criteria cri) {
		
		model.addAttribute("pageInfo", bservice.getPage(bno));
		
		model.addAttribute("cri", cri);
		
	}
	
	/* 페이지 수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		
		bservice.modify(board);
		
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/board/list";
		
	}

	/* 페이지 삭제 */
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
		
		bservice.delete(bno);
		
		rttr.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list";
	}	
	
}
