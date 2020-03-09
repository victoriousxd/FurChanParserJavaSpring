package com.example.demo.repository;

import com.example.demo.model.Boards;
import com.example.demo.exception.BadBoardsRequest;
import com.example.demo.exception.Not200or304;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@Service
public class BoardsRepositoryImpl implements BoardsRepository {
    //@Autowired
    private RestTemplate rest_template;
    private String boardRequest;

    public BoardsRepositoryImpl(RestTemplate rt, @Value("${boardRequestURL}") String br) {
        rest_template = rt;
        boardRequest = br;
    }

    public Boards getBoardsRequest() throws BadBoardsRequest, URISyntaxException {
        // exchange(RequestEntity<?> requestEntity, Class<T> responseType)
        RequestEntity<Void> request = RequestEntity
                .get(new URI(boardRequest))
                .accept(MediaType.APPLICATION_JSON).build();
        // check response code
        HttpStatus statuscode;
        // if response code is not 200 -> throw an error
        try {
            ResponseEntity<Boards> response = rest_template.exchange(request, Boards.class);
            statuscode = response.getStatusCode();
            if (statuscode == HttpStatus.OK) {
                return response.getBody();
            } else if (statuscode == HttpStatus.NOT_MODIFIED) {
                // load from db
                return null;
            } else {
                throw new Not200or304(response.getStatusCodeValue());
            }

        } catch (HttpClientErrorException | HttpServerErrorException | Not200or304 e) {
            throw new BadBoardsRequest(e);
        }

    }
}
