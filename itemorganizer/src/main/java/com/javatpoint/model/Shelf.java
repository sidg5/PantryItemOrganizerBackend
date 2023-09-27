package com.javatpoint.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Shelf {
	@Id
	@Column
	private int shelfId;
	
	@Column
	private String shelfName;

	@OneToMany(mappedBy = "shelf", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Box> box;
	
	@OneToMany(mappedBy = "shelf", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> item;
	
	public int getShelfId() {
		return shelfId;
	}

	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public void setBox(List<Box> box) {
		this.box = box;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	

	@Override
	public String toString() {
		return "Shelf [shelfId=" + shelfId + ", shelfName=" + shelfName + "]";
	}

}
