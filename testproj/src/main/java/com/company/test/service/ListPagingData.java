package com.company.test.service;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.javassist.compiler.ast.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ListPagingData<T> {
	private List<T> lists;
	private int TotalRecordCount;
	private int pageSize;
	private int blockPage;
	private int nowPage;
	private String pagingString;
		
}
