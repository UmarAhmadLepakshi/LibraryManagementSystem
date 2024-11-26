package com.example.demo.payload;

public class BooksDto {
	int bookId;
	String bookName;
	String author;
	String publishedYear;
	
	public BooksDto() {
		super();
	}

	public BooksDto(int bookId, String bookName, String author, String publishedYear) {
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
		return "BooksDto [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publishedYear="
				+ publishedYear + "]";
	}

}
