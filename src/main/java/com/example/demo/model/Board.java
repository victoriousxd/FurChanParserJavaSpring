package com.example.demo.model;


public class Board {

    String board;
    String text;
    int per_page;
    int pages;

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board='" + board + '\'' +
                ", text='" + text + '\'' +
                ", per_page=" + per_page +
                ", pages=" + pages +
                '}';
    }
}