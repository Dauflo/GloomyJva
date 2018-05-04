package com.gloomy.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "file")
public class FileUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Lob
    private Blob filePart;

    //Add the Many to One with user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public FileUser() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getFilePart() {
        return filePart;
    }

    public void setFilePart(Blob filePart) {
        this.filePart = filePart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
