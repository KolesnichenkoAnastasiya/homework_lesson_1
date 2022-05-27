package ru.geekbrains.persist.user;

public class User {
    private Long id;
    private String username;
    private String post;
    private int salary;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public User(String username, String post, int salary) {
       this.username = username;
       this.post = post;
       this.salary=salary;
    }
}
