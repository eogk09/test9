//package com.company.test.web;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.HttpSessionRequiredException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.company.test.service.LineCommentDTO;
//import com.company.test.service.ListPagingData;
//import com.company.test.service.OneMemoDTO;
//import com.company.test.service.OneMemoService;
//
//
//
//@SessionAttributes("id")
//@RequestMapping("/OneMemo/BBS/")
//@Controller
//public class OneMemoController {
//	
//	//서비스 주입]
//	@Resource(name="memoService")
//	private OneMemoService memoService;
//	
//	@ExceptionHandler({HttpSessionRequiredException.class})
//	public String notLogin(Model model) {
//		model.addAttribute("NotMember", "로그인후 이용 바람....");
//		//로그인이 안된경우 로그인 페이지로
//		return "onememo10/member/Login.tiles";
//	}
//	
//	@RequestMapping("List.do")
//	public String list(
//			@ModelAttribute("id") String id,
//			@RequestParam Map map,
//			@RequestParam(required = false,defaultValue = "1") int nowPage,
//			HttpServletRequest req,
//			Model model) {
//		ListPagingData listPagingData= memoService.selectList(map,req,nowPage);
//		model.addAttribute("listPagingData", listPagingData);
//		return "bbs";
//	}/////////
//	//입력폼으로 이동]
//	@RequestMapping(value = "Write.do",method = RequestMethod.GET)
//	public String write(
//			@ModelAttribute("id") String id
//			) {
//		return "onememo10/bbs/Write.tiles";
//	}/////////////
//	//입력처리]
//	@RequestMapping(value = "Write.do",method = RequestMethod.POST)
//	public String writeoK(
//			@ModelAttribute("id") String id,
//			@RequestParam Map map) {
//		
//		map.put("id", id);
//		memoService.insert(map);		
//		return "forward:/OneMemo/BBS/List.do";
//	}/////////////
//	
//	//상세보기]
//	@RequestMapping("View.do")
//	public String view(
//			@ModelAttribute("id") String id,
//			@RequestParam Map map,Model model) {
//		OneMemoDTO record=memoService.selectOne(map);
//		record.setContent(record.getContent().replace("\r\n","<br/>"));
//		model.addAttribute("record", record);
//		List<LineCommentDTO> comments=record.getComments();
//		return "onememo10/bbs/View.tiles";
//	}
//	//삭제처리]
//	@RequestMapping("Delete.do")
//	public String delete(@RequestParam Map map,Authentication auth) {
//		//서비스 호출
//		memoService.delete(map);
//		//뷰정보 반환]
//		return "forward:/OneMemo/BBS/List.do";
//	}
//	//수정폼으로 이동 및 수정처리]
//	@RequestMapping("Edit.do")
//	public String edit(@ModelAttribute("id") String id,HttpServletRequest req,@RequestParam Map map) {
//		if(req.getMethod().equals("GET")) {
//			OneMemoDTO record=memoService.selectOne(map);
//			req.setAttribute("record", record);
//			return "onememo10/bbs/Edit.tiles";
//		}
//		memoService.update(map);
//		return "forward:/OneMemo/BBS/View.do";
//	}/////////////////////
//	
//}
