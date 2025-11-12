package com.sonia.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sonia.tp.model.Article;
import com.sonia.tp.service.ArticleService;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * Read - Get all Articles by User
     * 
     * @param id The id of the User
     * @return A list of Article objects by user
     */
    @GetMapping("/articles/user/{id}")
    public List<Article> getArticlesByUser(@PathVariable final Long id) {
        return articleService.getArticlesByUser(id);
    }

    /**
     * Read - Get one Article by ID
     * 
     * @param id The id of the article
     * @return The Article object
     */
    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable final Long id) {
        return articleService.getArticle(id);
    }

    /**
     * Create - Add a new Article
     * 
     * @param article An object Article
     * @return The Article object saved
     */
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    /**
     * Update - Modify an existing Article
     * 
     * @param id      The id of the article to update
     * @param article The updated Article data
     * @return The updated Article object
     */
    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable final Long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    /**
     * Delete - Remove an Article
     * 
     * @param id The id of the article to delete
     */
    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable final Long id) {
        articleService.deleteArticle(id);
    }
}
