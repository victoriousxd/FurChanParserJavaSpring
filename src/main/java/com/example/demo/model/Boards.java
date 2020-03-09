package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Boards {
    @JsonProperty("boards")
    ArrayList<Board> boardList;

    public ArrayList<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(ArrayList<Board> boardList) {
        this.boardList = boardList;
    }

    public void addBoardList(Board lol) {
        boardList.add(lol);
    }
    @Override
    public String toString() {
        return "Boards{" +
                "boardList=" + boardList +
                '}';
    }
}
