package com.shestakam.news.comments.entity;

import com.shestakam.news.entity.News;
import com.shestakam.user.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by alexandr on 24.7.15.
 */
@Entity
@Table(name = "comments")
public class Comments {

    private Long commentId;
    private String commentText;
    private Timestamp creationDate;
    private String commentatorUsername;
    private Long newsId;
    private User commentator;
    private News myNews;

    public Comments() {
    }

    @Id
    @Column(name="comment_id",unique = true,nullable = false)
    @GeneratedValue
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Column(name="comment_text",length = 2000)
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Column(name="creation_date",nullable = false)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name="commentator_username",length = 20,nullable = false)
    public String getCommentatorUsername() {
        return commentatorUsername;
    }

    public void setCommentatorUsername(String commentatorUsername) {
        this.commentatorUsername = commentatorUsername;
    }


    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    @ManyToOne
    @JoinColumn(name="commentator_username",insertable=false, updatable=false)
    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    @ManyToOne
    @JoinColumn(name="news_id")
    public News getMyNews() {
        return myNews;
    }

    public void setMyNews(News myNews) {
        this.myNews = myNews;
    }
}
