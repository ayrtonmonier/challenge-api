package com.ayrtonmonier.challenge.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

