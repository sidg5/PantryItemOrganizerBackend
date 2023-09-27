package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity @Table public class Item {
    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column private String itemName;
    @Column private String itemImg;
    @Column private String itemCategory;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = true
    )
    @JoinColumn(name = "boxId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({ "hibernateLazyInitializer" })
    public Box box;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(name = "shelfId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({ "hibernateLazyInitializer" })
    public Shelf shelf;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override public String toString() {
        return "Item [itemName=" + itemName + ", itemImg=" + itemImg +
            ", itemCategory=" + itemCategory + "]";
    }

}
