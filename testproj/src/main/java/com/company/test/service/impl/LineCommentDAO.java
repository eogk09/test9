//package com.company.test.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Repository;
//
//
//@Repository("commentDao")
//public class LineCommentDAO  {
//	
//	//SqlSessionTemplate객체 주입]
//	@Resource(name="template")
//	private SqlSessionTemplate sqlMapper;
//	
//
//	
//	public List<Map> selectList(Map map) {		
//		return sqlMapper.selectList("commentSelectList", map);
//	}
//	
//	public int insert(Map map) {		
//		//insert는 무조건 영향받은 행의 수 반환
//		sqlMapper.insert("commentInsert",map);
//		//map에 채워진 lno키의 값을 반환
//		return Integer.parseInt(map.get("lno").toString());
//	}
//	public String findNameById(String id) {
//		return sqlMapper.selectOne("memoFindNameById",id);
//	}
//
//	
//	public int delete(Map map) {		
//		return sqlMapper.delete("commentDelete",map);
//	}
//
//	
//	public int update(Map map) {
//		System.out.println("LineCommentDAO:"+map.get("lno"));
//		return sqlMapper.update("commentUpdate",map);
//	}
//
//	
//}
