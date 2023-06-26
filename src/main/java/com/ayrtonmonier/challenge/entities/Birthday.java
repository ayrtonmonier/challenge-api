package com.ayrtonmonier.challenge.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Birthday {
	
    @Column(name = "birthday")
    private String birthday;


    // construtor, getters e setters
    public Birthday() {}

	public Birthday(String birthday) {
		super();
		this.birthday = birthday;
	}
    
    public String getDate() {
        return birthday;
    }

    public void setDate(String birthday) {
        this.birthday = birthday;
    }
    
	
    
}

