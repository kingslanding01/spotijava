package com.example.demo;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.Set;

@Entity
public class Album {
    private long id;
    private String albumname;
    private String year;
    private double price;
    private String genre;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="transaction_id")
    private javax.transaction.Transaction transaction;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Song> songs;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public javax.transaction.Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

}
