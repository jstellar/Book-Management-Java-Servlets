package com.book;

public class Book {
	
	private int id;
	private String title;
	private String isbn;
	private String author;
	private int publicYear;
	private float price;
	private String description;
	
	public Book(int id, String title, String isbn, String author, int publicYear, float price, String description) {
		
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publicYear = publicYear;
		this.price = price;
		this.description = description;
	}
	
	public Book(String title, String isbn, String author, int publicYear, float price, String description) {

		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publicYear = publicYear;
		this.price = price;
		this.description = description;
	}
	
	public Book() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(int publicYear) {
		this.publicYear = publicYear;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
