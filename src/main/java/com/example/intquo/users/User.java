package com.example.intquo.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Users")
public class User {
    @Id
    private Integer id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private Integer passout_year;
    private String password;

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPassout_year() {
        return passout_year;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassout_year(Integer passout_year) {
        this.passout_year = passout_year;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", passout_year=" + passout_year +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String username, String first_name, String last_name, String email, int passout_year, String password) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.passout_year = passout_year;
        this.password = password;
    }

    public User() {

    }
}
