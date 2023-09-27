package com.javatpoint.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity @Table public class Box {
    @Id @Column private int boxId;
    @Column private String boxName;
    @Column private String photoUrl;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(name = "shelfId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIdentityReference(alwaysAsId=true)
    //@JsonProperty("shelfId")
    private Shelf shelf;

    @OneToMany(
        mappedBy = "box",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    private List<Item> item;

    //public Shelf getShelf() {
    //      return shelf;
    //}

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public String getBoxName() {
        return boxName;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }


    @Override public String toString() {
        return "Box [boxId=" + boxId + ", boxName=" + boxName + ", photoUrl=" +
            photoUrl + "]";
    }


}
