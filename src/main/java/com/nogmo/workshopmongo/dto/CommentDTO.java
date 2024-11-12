package com.nogmo.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private LocalDate Date;
	private AuthorDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String text, LocalDate date, AuthorDTO author) {
		super();
		this.text = text;
		Date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
