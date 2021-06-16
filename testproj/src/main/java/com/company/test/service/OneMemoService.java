package com.company.test.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface OneMemoService {
	//로그인 용]
	boolean isLogin(Map map);
	//목록용]
	ListPagingData<OneMemoDTO> selectList(Map map,HttpServletRequest req,int nowPage);
	//전체 레코드 수]
	int getTotalRecord(Map map);
	//상세보기용]
	OneMemoDTO selectOne(Map map);
	//입력/수정/삭제용]
	int insert(Map map);
	int delete(Map map);
	int update(Map map);
	
	//아이디로 이름 찾기
	String findNameById(String id);
}
