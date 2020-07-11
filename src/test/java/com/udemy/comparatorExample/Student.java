package com.udemy.comparatorExample;

public class Student {

    private String name;
    private int score;
    private int heght;

    public Student(String name, int score, int heght) {
        this.name = name;
        this.score = score;
        this.heght = heght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeght() {
        return heght;
    }

    public void setHeght(int heght) {
        this.heght = heght;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", heght=" + heght +
                '}';
    }
}
