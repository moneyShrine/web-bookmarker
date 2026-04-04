package com.webbookmarker.entity.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class BookmarksDTO 
{
	private List<BookmarkDTO> data;
	private int totalElements;
	private int totalPages;
	private int currentPage;	
	@JsonProperty("isFirst")
	private boolean isFirst;
	@JsonProperty("isLast")
	private boolean isLast;
	private boolean hasNext;
	private boolean hasPrevious;
	
	public BookmarksDTO(Page<BookmarkDTO> bookmarkPage)
	{
		this.setData(bookmarkPage.getContent());
		this.setTotalElements((int) bookmarkPage.getTotalElements());
		this.setTotalPages(bookmarkPage.getTotalPages());
		this.setCurrentPage(bookmarkPage.getNumber() + 1);
		this.setFirst(bookmarkPage.isFirst());
		this.setLast(bookmarkPage.isLast());
		this.setHasNext(bookmarkPage.hasNext());
		this.setHasPrevious(bookmarkPage.hasPrevious());
	}

}
