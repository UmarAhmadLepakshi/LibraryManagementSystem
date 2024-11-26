package com.example.demo.payload;

public class BorrowsDto {

	int id;
	int bookId;
	String bookName;
	String author;
	String borrowerName;
	long borrowerNum;
	String borrowStatus = "NOT-RETURNED";
	
	public BorrowsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BorrowsDto(int id, int bookId, String bookName, String author, String borrowerName, long borrowerNum,
			String borrowStatus) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.borrowerName = borrowerName;
		this.borrowerNum = borrowerNum;
		this.borrowStatus = borrowStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public long getBorrowerNum() {
		return borrowerNum;
	}

	public void setBorrowerNum(long borrowerNum) {
		this.borrowerNum = borrowerNum;
	}

	public String getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	@Override
	public String toString() {
		return "BorrowsDto [id=" + id + ", bookId=" + bookId + ", bookName=" + bookName + ", author=" + author
				+ ", borrowerName=" + borrowerName + ", borrowerNum=" + borrowerNum + ", borrowStatus=" + borrowStatus
				+ "]";
	}
}
