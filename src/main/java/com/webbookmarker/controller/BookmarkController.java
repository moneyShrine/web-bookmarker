package com.webbookmarker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webbookmarker.entity.dto.BookmarksDTO;
import com.webbookmarker.services.BookmarkServices;

@RestController
@RequestMapping(value="/api/bookmarks")
public class BookmarkController 
{
	private final BookmarkServices bookmarkServices;
	
	public BookmarkController(BookmarkServices bookmarkServices)
	{
		this.bookmarkServices = bookmarkServices;
	}
	
	@GetMapping
	public BookmarksDTO getBookmarks(@RequestParam(name="page", defaultValue="1")  Integer page)
	{
		return bookmarkServices.getBookmarks(page);
	}

}
