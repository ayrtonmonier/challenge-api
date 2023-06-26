package com.ayrtonmonier.challenge.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Registered {
	
    @Column(name = "registered")
    private String registered;


    // construtor, getters e setters
    public Registered() {}

	public Registered(String registered) {
		super();
		this.registered = registered;
	}
    
    public String getDate() {
        return registered;
    }

    public void setDate(String registered) {
        this.registered = registered;
    }
    
	
    
}

