package com.ayrtonmonier.challenge.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Timezone {

    @Column(name = "off_set")
    private String offset;

    @Column(name = "description")
    private String description;

    // construtor, getters e setters
    public Timezone() {}

	public Timezone(String offset, String description) {
		super();
		this.offset = offset;
		this.description = description;
	}

	
	
	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getOffset() {
		return offset;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}

