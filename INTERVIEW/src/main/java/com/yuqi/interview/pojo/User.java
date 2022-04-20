package com.yuqi.interview.pojo;


public class User {
    private Integer id;
    private String name;
    private float grade;
    private String updatetime;


    public User(Integer id, String name, float grade, String updatetime) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.updatetime = updatetime;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", updateTime='" + updatetime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
