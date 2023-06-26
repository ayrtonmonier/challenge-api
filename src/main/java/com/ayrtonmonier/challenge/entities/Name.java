package com.ayrtonmonier.challenge.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

    @Column(name = "title")
    private String title;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    // construtor, getters e setters
    public Name() {}

	public Name(String title, String first, String last) {
		super();
		this.title = title;
		this.first = first;
		this.last = last;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
    
    
    
    
}
