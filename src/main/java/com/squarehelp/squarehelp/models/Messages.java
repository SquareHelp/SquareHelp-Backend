package com.squarehelp.squarehelp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "BIGINT(20)")
    private int author_user_id;

    @Column(columnDefinition = "BIGINT(20)")
    private int recipient_user_id;

    @Column(columnDefinition = "TEXT")
    private String message;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "VARCHAR(255)")
    private String recipient_username;

    @Column(columnDefinition = "DATE")
    private Date last_updated;

    public Messages(int author_user_id, int recipient_user_id, String message) {
        this.author_user_id = author_user_id;
        this.recipient_user_id = recipient_user_id;
        this.message = message;
    }

    public Messages(int author_user_id, int recipient_user_id, String message, User user) {
        this.author_user_id = author_user_id;
        this.recipient_user_id = recipient_user_id;
        this.message = message;
        this.user = user;
    }

    public Messages(int author_user_id, int recipient_user_id, String message, User user, String recipient_username, Date last_updated) {
        this.author_user_id = author_user_id;
        this.recipient_user_id = recipient_user_id;
        this.message = message;
        this.user = user;
        this.recipient_username = recipient_username;
        this.last_updated = last_updated;
    }

    public Messages() {
    }

    public String getRecipient_username() {
        return recipient_username;
    }

    public void setRecipient_username(String recipient_username) {
        this.recipient_username = recipient_username;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAuthor_user_id() {
        return author_user_id;
    }

    public void setAuthor_user_id(int author_user_id) {
        this.author_user_id = author_user_id;
    }

    public int getRecipient_user_id() {
        return recipient_user_id;
    }

    public void setRecipient_user_id(int recipient_user_id) {
        this.recipient_user_id = recipient_user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
