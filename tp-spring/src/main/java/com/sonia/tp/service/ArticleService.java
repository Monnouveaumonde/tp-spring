package com.sonia.tp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonia.tp.model.Article;
import com.sonia.tp.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Get all Articles by User ID
     */
    public List<Article> getArticlesByUser(Long userId) {
        return articleRepository.findByUserId(userId);
    }

    /**
     * Get one Article by ID
     */
    public Article getArticle(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    /**
     * Get all Articles
     */
    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    /**
     * Delete an Article
     */
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    /**
     * Save a new Article
     */
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    /**
     * Update an existing Article
     */
    public Article updateArticle(Long id, Article article) {
        Optional<Article> existingArticle = articleRepository.findById(id);

        if (existingArticle.isPresent()) {
            Article current = existingArticle.get();
            current.setTitle(article.getTitle());
            current.setContent(article.getContent());
            current.setUser(article.getUser());
            // ajoute ici d'autres champs si ton entité en contient (ex: date, tags, etc.)
            return articleRepository.save(current);
        } else {
            // si non trouvé, on peut soit renvoyer null soit créer un nouvel article
            return null;
        }
    }
}
