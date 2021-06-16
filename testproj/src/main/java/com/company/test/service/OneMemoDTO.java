package com.company.test.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneMemoDTO {
	private String no;
	private String title;
	private String content;
	private java.sql.Date postDate;
	private String id;
	private String name;
	//각 글에 따른 댓글 총수 출력용
	private String commentCount;	
	//List<LineCommentDTO> comments;
	
	
}
