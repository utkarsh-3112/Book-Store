package com.example.demo.models;

public class Book {
	private int bookId;
	private String title;
	private int edition;
	private String author;
	private String publication;
	private float price;
	private String user;
	
	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", title='" + title + '\'' +
				", edition=" + edition +
				", author='" + author + '\'' +
				", publication='" + publication + '\'' +
				", price=" + price +
				", user='" + user + '\'' +
				'}';
	}
	
	public Book(int bookId, String title, int edition, String author, String publication, float price, String user) {
		this.bookId = bookId;
		this.title = title;
		this.edition = edition;
		this.author = author;
		this.publication = publication;
		this.price = price;
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublication() {
		return publication;
	}
	
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}
