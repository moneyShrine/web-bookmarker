package com.webbookmarker.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webbookmarker.entity.Bookmark;
import com.webbookmarker.entity.dto.BookmarkDTO;

@Repository
public interface BookmarkRepository extends JpaRepository <Bookmark, Long>
{
	@Query("select new com.webbookmarker.entity.dto.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
	Page<BookmarkDTO> findBookmarks(Pageable pageable);	

}
