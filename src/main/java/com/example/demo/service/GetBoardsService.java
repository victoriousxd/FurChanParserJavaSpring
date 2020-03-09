package com.example.demo.service;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.exception.BadBoardsRequest;
import com.example.demo.model.Board;

import com.example.demo.model.Boards;
import com.example.demo.repository.BoardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetBoardsService {

    private BoardsRepository boardsRepository;

    public GetBoardsService(BoardsRepository br){
        boardsRepository = br;
    }

    // calling a function to call another function is silly... maybe I don't need to separate url requests into utility
    public Boards getBoards() throws Exception {
        // isolate how we retrieve data vs what we do with it
        return boardsRepository.getBoardsRequest();

    }
}