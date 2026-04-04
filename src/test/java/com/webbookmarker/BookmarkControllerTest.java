package com.webbookmarker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.webbookmarker.entity.Bookmark;
import com.webbookmarker.repo.BookmarkRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookmarkControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	private List<Bookmark> bookmark;
	
	@Autowired
	private BookmarkRepository repo;
	
	@BeforeEach
	public void setup()
	{
		repo.deleteAllInBatch();
		bookmark = new ArrayList<>();
		bookmark.add(new Bookmark(null, "Siva Labs","https://sivalabs.in", Instant.now()));
		bookmark.add(new Bookmark(null, "Spring Blog","https://spring.in/blog", Instant.now()));
		bookmark.add(new Bookmark(null, "Baeldung","https://www.baeldung.com", Instant.now()));
		bookmark.add(new Bookmark(null, "Thoughts on Java","https://www.java.org", Instant.now()));
		bookmark.add(new Bookmark(null, "Kubernetes Thoughts","https://www.kubernetesin/docs/homes", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "google","https://www.google.com", Instant.now()));
		bookmark.add(new Bookmark(null, "Dzure","https://www.dzure.com", Instant.now()));
		bookmark.add(new Bookmark(null, "LinkedIn","https://www.linkedin.com", Instant.now()));
		
		repo.saveAll(bookmark);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 16, 2, 1, true, false, false, true",
		"2, 16, 2, 2, false, true, true, false"
	})
	public void shouldGetBookmarks(int pageNo, int totalElements, int totalPages,
			int currentPage, boolean isFirst, boolean isLast, boolean hasPrevious,
			boolean hasNext) throws Exception
	{
		mockMvc.perform(get("/api/bookmarks?page="+pageNo))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
		.andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
		.andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
		.andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
		.andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
		.andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)))
		.andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
		;
		
	}


}
