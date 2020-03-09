package com.example.demo.repository;

import com.example.demo.exception.BadBoardsRequest;

import org.junit.Assert;
import org.junit.Test;
import com.example.demo.model.Boards;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;


/**
 * Simulate making requests and handling successful/bad responses
 *
 * */
public class BoardsRepositoryTest {

    /* test successful response */
    @Test
    public void BoardsRepositoryTestSuccess() throws Exception {
        RestTemplate rt = new RestTemplate();
        MockRestServiceServer mrss;
        mrss = MockRestServiceServer.createServer(rt);

        BoardsRepository repository = new BoardsRepositoryImpl(rt, "meow");
        mrss.expect(requestTo("meow"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess().
                contentType(MediaType.valueOf("application/json")).
                body("{\"boards\":[]}"));

        Boards b = repository.getBoardsRequest();

        Assert.assertEquals(0,b.getBoardList().size());


    }
    /* test HTTP Server Error 500 Exception */
    @Test
    public void BoardsRepositoryTestFail() throws InterruptedException, IOException, URISyntaxException {
        RestTemplate rt = new RestTemplate();
        MockRestServiceServer mrss;
        mrss = MockRestServiceServer.createServer(rt);

        BoardsRepository repository = new BoardsRepositoryImpl(rt, "meow");
        mrss.expect(requestTo("meow"))
                .andExpect(method(HttpMethod.GET))
                .andRespond( withServerError());
        try {
            Boards b = repository.getBoardsRequest();
            Assert.fail();
        } catch (BadBoardsRequest e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* test A response that's not 200 or 304*/
    @Test
    public void BoardsRepositoryNot200or304TestFail() throws Exception {
        RestTemplate rt = new RestTemplate();
        MockRestServiceServer mrss;
        mrss = MockRestServiceServer.createServer(rt);

        BoardsRepository repository = new BoardsRepositoryImpl(rt, "meow");
        mrss.expect(requestTo("meow"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.CREATED));
        try {
            Boards b = repository.getBoardsRequest();
            Assert.fail();
        } catch (BadBoardsRequest e) {
            e.printStackTrace();
        }
    }


}
