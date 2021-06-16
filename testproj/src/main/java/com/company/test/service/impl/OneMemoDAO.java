package com.company.test.service.impl;


import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.company.test.service.OneMemoDTO;


@Repository
public class OneMemoDAO  {
	
	@Resource(name="template")
	private SqlSessionTemplate sqlMapper;
	
	

	public boolean isLogin(Map map) {
		System.out.println("sqlMapper:"+sqlMapper);
		System.out.println(map.get("id"));
		return (Integer)sqlMapper.selectOne("memoIsLogin", map) ==1 ? true : false;
	}

	
	public List<OneMemoDTO> selectList(Map map) {
		
		return sqlMapper.selectList("memoSelectList",map);
	}

	
	public int getTotalRecord(Map map) {
		
		return sqlMapper.selectOne("memoTotalCount",map);
	}

	
	public OneMemoDTO selectOne(Map map) {		
		return sqlMapper.selectOne("memoSelectOne", map);
	}

	
	public int insert(Map map) {
		
		return sqlMapper.insert("memoInsert", map);
	}

	
	public int delete(Map map) {
		
		return sqlMapper.delete("memoDelete",map);
	}

	
	public int update(Map map) {		
		return sqlMapper.update("memoUpdate",map);
	}
	public String findNameById(String id) {
		return sqlMapper.selectOne("memoFindNameById", id);
	}////////////////////////
	
}
