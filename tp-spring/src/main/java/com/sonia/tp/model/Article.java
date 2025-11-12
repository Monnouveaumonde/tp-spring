package com.sonia.tp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

   
    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;

 
    public Article() {}

    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
