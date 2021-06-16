//package com.company.test.web;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.company.test.service.LineCommentService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//
//@SessionAttributes({"id"})
//@RestController
//public class CommentController {
//	@Resource(name="commentService")
//	private  LineCommentService commentService;
//	
//	@Autowired
//	private ObjectMapper mapper;
//	
//	@GetMapping(value="/OneMemo/Comment/List.do",produces = "text/plain;charset=UTF-8")	
//	public String list(
//			@ModelAttribute("id") String id, 
//			@RequestParam Map map) throws JsonProcessingException {
//		List<Map> list=commentService.selectList(map);
//		for(Map comment:list) {
//			comment.put("LPOSTDATE",comment.get("LPOSTDATE").toString().substring(0, 10) );
//		}
//		
//		String comments=mapper.writeValueAsString(list);
//		return comments;
//	}
//	@PostMapping(value="/OneMemo/Comment/Write.do",produces = "text/plain;charset=UTF-8")
//	public String write(
//			@ModelAttribute("id") String id,
//			@RequestParam Map map) {
//		map.put("id", id);
//		String name=commentService.insert(map);		
//		
//		return name;
//	}////////////////////
//	@PostMapping(value="/OneMemo/Comment/Edit.do",produces = "text/plain;charset=UTF-8")
//	public String update(
//			@ModelAttribute("id") String id,
//			@RequestParam Map map) {
//		System.out.println("댓글의 키값:"+map.get("lno"));
//		System.out.println("CommentController:"+map.get("lno"));
//		commentService.update(map);
//		return map.get("lno").toString();
//	}
//	
//	@PostMapping(value="/OneMemo/Comment/Delete.do",produces = "text/plain;charset=UTF-8")
//	public String delete(
//			@ModelAttribute("id") String id,
//			@RequestParam  Map map) {		
//		System.out.println("삭제할 키:"+map.get("lno"));
//		commentService.delete(map);	
//		return "삭제 성공";
//	}
//}////////////////
