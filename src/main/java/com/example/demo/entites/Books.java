package com.example.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookId;
	
	//nullable = false -> means it should be be filled compulsory
	@Column(nullable = false)
	String bookName;
	
	@Column(nullable = false)
	String author;
	
	@Column(nullable = false)
	String publishedYear;
	
	public Books() {
		super();
	}

	public Books(int bookId, String bookName, String author, String publishedYear) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publishedYear = publishedYear;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publishedYear="
				+ publishedYear + "]";
	}
}
