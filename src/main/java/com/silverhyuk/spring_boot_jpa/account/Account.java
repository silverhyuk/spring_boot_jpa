package com.silverhyuk.spring_boot_jpa.account;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity(name="myAccount")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column
    private String password;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
