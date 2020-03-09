package com.example.demo.service;

import com.example.demo.model.Board;
import org.junit.Assert;
import org.mockito.Mockito;
import org.junit.Test;
import com.example.demo.model.Boards;
import com.example.demo.repository.BoardsRepository;
import java.util.ArrayList;

/**
 * Test functionality of Board Service Class
 *
 * */
// service test
// taken dependency of service and pretend that it does stuff that
// it does not necesasdfkljasfdlkjasdk;jl
public class GetBoardsServiceTest {

    public Boards makeFakeBoards(){
        Boards fakeBoard = new Boards();
        ArrayList<String> boardNames = new ArrayList<String>();
        boardNames.add("Bob");
        boardNames.add("Cat");
        boardNames.add("Dig");
        boardNames.add("Dug");
        fakeBoard.setBoardList(new ArrayList<>());
        for (String bname : boardNames){
            Board b = new Board();
            b.setBoard(bname);
            fakeBoard.addBoardList(b);
        }
        return fakeBoard;
    }

    @Test
    public void testGetBoardsServiceSuccess() throws Exception {

        // set up
        BoardsRepository br = Mockito.mock(BoardsRepository.class);
        com.example.demo.service.GetBoardsService gbs = new com.example.demo.service.GetBoardsService(br);
        Boards fakeBoard = makeFakeBoards();

        Mockito.doReturn(fakeBoard).when(br).getBoardsRequest();
        // make fake http request


        // do

        Boards b = gbs.getBoards();
        for(Board bd : b.getBoardList()) {
            System.out.println(bd.toString());
        }
        // verify 4 boards exist in list
            Assert.assertEquals(4, b.getBoardList().size());
    }


    @Test
    public void testGetBoardsServiceFails() throws Exception {

        // set up
        BoardsRepository br = Mockito.mock(BoardsRepository.class);
        com.example.demo.service.GetBoardsService gbs = new com.example.demo.service.GetBoardsService(br);
        Boards fakeBoard = makeFakeBoards();

        Mockito.doReturn(fakeBoard).when(br).getBoardsRequest();
        // make fake http request


        // do

        Boards b = gbs.getBoards();
        for(Board bd : b.getBoardList()) {
            System.out.println(bd.toString());
        }
        // verify 4 boards exist in list
        Assert.assertEquals(4, b.getBoardList().size());
    }


}