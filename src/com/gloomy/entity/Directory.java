package com.gloomy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "directory")
public class Directory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinTable(
            name = "directory_file",
            joinColumns = @JoinColumn(name = "directory_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id", unique = true)
    )
    private List<FileUser> fileUserList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Directory() {
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

    public List<FileUser> getFileUserList() {
        return fileUserList;
    }

    public void setFileUserList(List<FileUser> fileUserList) {
        this.fileUserList = fileUserList;
    }

    public void addFileUserList(FileUser fileUser) {
        this.fileUserList.add(fileUser);
    }
}
