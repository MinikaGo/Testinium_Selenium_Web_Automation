package api.rest_assured_test;

import api.actions.BoardActions;
import api.actions.CardActions;
import api.actions.ListActions;
import api.objects.Board;
import api.objects.Card;
import api.objects.ListBoard;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TrelloRestApiTest {


    @Test
    public void trelloRestApiTest() {

        // 1- Trello üzerinde bir board oluşturunuz.
        Board board = new Board();
        BoardActions boardActions = new BoardActions();
        board = boardActions.createBoard();

        List<ListBoard> listBoards = new ArrayList<>();
        ListActions listActions = new ListActions();
        listBoards = listActions.getBoardLists(board.getId());

        // 2- Oluşturduğunuz board’ a iki tane kart oluşturunuz.
        Card card1 = new Card();
        Card card2 = new Card();
        CardActions cardActions = new CardActions();
        card1.setId(cardActions.createCard(listBoards.get(0).getId()));
        card2.setId(cardActions.createCard(listBoards.get(0).getId()));

        // 3- Oluştrduğunuz bu iki karttan random olacak sekilde bir tanesini güncelleyiniz.
        Random random = new Random();

        if (random.nextInt(2) == 0) {

            cardActions.updateCard(card1.getId(), "Birinci Card Güncellendi");

        } else {
            cardActions.updateCard(card2.getId(), "İkinci Card Güncellendi");

        }

        // 4- Oluşturduğunuz kartları siliniz.
        cardActions.deleteCard(card1.getId());
        cardActions.deleteCard(card2.getId());

        // 5- Oluşturduğunuz board’ u siliniz.
        boardActions.removeBoard(board.getId());

    }

}






