package com.webbookmarker.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.webbookmarker.entity.dto.BookmarkDTO;
import com.webbookmarker.entity.dto.BookmarksDTO;
import com.webbookmarker.repo.BookmarkRepository;

@Service
@Transactional
public class BookmarkServices 
{
	private final BookmarkRepository repo;
	 

	public BookmarkServices(BookmarkRepository bookmarkRepo)
	{
		this.repo = bookmarkRepo;
	}
	
	@Transactional(readOnly=true)
	public BookmarksDTO getBookmarks(Integer page)
	{
		int pageNo = page < 1 ? 0 : page -1;
		Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
		Page <BookmarkDTO> bookmarkPage = repo.findBookmarks(pageable);
		
		return new BookmarksDTO(bookmarkPage);
	}
}
