package com.example.demo.Controller;
import com.example.demo.exception.BadBoardsRequest;
import com.example.demo.model.Boards;
import com.example.demo.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.GetBoardsService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/*  Define class as rest controller to allow Spring to use this to handle web requests
    Rest controller combines @Controller and @ResponseBody,
    two annotations that results in web requests returning data rather than a view */


// http -> java object
@RestController
@RequestMapping("/")
public class HelloController {
// turn back into json for ui to manipulate
    @Autowired  // triggers spring to put something into gbs
    private GetBoardsService gbs;

    @RequestMapping(value={"","index"})
    public Boards index() {
        try {
            return gbs.getBoards();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        } catch (BadBoardsRequest badBoardsRequest) {
            badBoardsRequest.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("cat")
    public String cat() {
        return "Greetings from a cat this time....";
    }

}
