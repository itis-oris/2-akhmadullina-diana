package com.pyatnashki.gui.game;

import com.pyatnashki.model.User;
import com.pyatnashki.service.UserRequestService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;

public class Board extends JFrame {
    private final PlayerBoard playerBoardOne;
    /* this is board of current player
    so: we need to send server his current position
     */
    private final PlayerBoard playerBoardTwo;
    /* this is board of his opponent
    so: we need to get the start position from server
    */

    /* key codes:
    37, 38, 39, 40
     */
   private UserRequestService requestService = new UserRequestService();
    private User user;


    public Board(User user) {
        super();

        ArrayList<String> order = getStartPosition();
        playerBoardOne = new PlayerBoard(new GameBoard(order), user, 0, 0);
        this.user = user;
        this.user.setOrder(order);
        requestService.onMove(user);
        playerBoardTwo = new PlayerBoard(new GameBoard(requestService.getPairOrder(user)), user, 330, 0);
        add(playerBoardOne, BorderLayout.WEST);
        add(playerBoardTwo, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650, 600));
        setLayout(new BorderLayout());
        pack();
        setVisible(true);
    }

    private ArrayList<String> getStartPosition() {
        // and here we need to put user order
//        ArrayList<String> order = new ArrayList<>(asList("0", "1", "2", "3", "4", "5", "6", "7", "8"));
//        Collections.shuffle(order);
//        return order;
        return new ArrayList<>(asList("1", "2", "3", "4", "6", "8", "7", "5", "0"));
    }

   public void resetGameBoardTwo() {
       playerBoardTwo.reset();
   }

}
