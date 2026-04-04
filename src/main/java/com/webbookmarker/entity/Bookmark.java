package com.webbookmarker.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Table(name="bookmark")
@Entity
public class Bookmark
{
	@Id
	@SequenceGenerator(name="bm_id_seq.gen", sequenceName="bm_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bm_id_seq.gen")
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String url;
	
	private Instant createdAt;

}
