package com.company.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.company.test.service.ListPagingData;
import com.company.test.service.OneMemoDTO;
import com.company.test.service.OneMemoService;
import com.company.test.service.PagingUtil;

@Service("memoService")
public class OneMemoServiceImpl implements OneMemoService {

	@Resource(name="oneMemoDAO")
	private  OneMemoDAO dao;
	
	@Override
	public boolean isLogin(Map map) {
		
		return dao.isLogin(map);
	}
	//@Value("${PAGE_SIZE}")
	private int pageSize = 5;
	//@Value("${BLOCK_PAGE}")
	private int blockPage = 5;

	@Override
	public ListPagingData<OneMemoDTO> selectList(Map map,HttpServletRequest req,int nowPage) {	
		int totalRecordCount=dao.getTotalRecord(map);		
		int totalPage =(int)Math.ceil((double)totalRecordCount/pageSize);		
		int start = (nowPage -1)*pageSize+1;
		int end = nowPage * pageSize;	
		map.put("start", start);
		map.put("end", end);
		List lists=dao.selectList(map);		
		String pagingString=PagingUtil.pagingBootStrapStyle(totalRecordCount,pageSize, blockPage, nowPage,req.getContextPath()+"/OneMemo/BBS/List.do?");
		
		ListPagingData<OneMemoDTO> listPagingData = 
				ListPagingData.builder()
					.lists(lists)
					.nowPage(nowPage)
					.pageSize(pageSize)
					.pagingString(pagingString)
					.TotalRecordCount(totalRecordCount)
					.build();
		
		return listPagingData;
	}
	@Override
	public int getTotalRecord(Map map) {		
		return dao.getTotalRecord(map);
	}
	@Override
	public OneMemoDTO selectOne(Map map) {		
		return dao.selectOne(map);
	}

	@Override
	public int insert(Map map) {		
		return dao.insert(map);
	}

	@Override
	public int delete(Map map) {		
		return dao.delete(map);
	}

	@Override
	public int update(Map map) {		
		return dao.update(map);
	}

	@Override
	public String findNameById(String id) {		
		return dao.findNameById(id);
	}

}
