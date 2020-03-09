package com.example.demo.repository;

import com.example.demo.exception.BadBoardsRequest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Boards;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// made an interface because we want to swap out how we actually get boards
public interface BoardsRepository {

    public Boards getBoardsRequest() throws Exception;

}
