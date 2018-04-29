
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeEngine implements ActionListener{

    TicTacToe ticTacToe;
    JButton clickedButton;
    int x = 0, o = 0, allowFlag = 0;

    TicTacToeEngine(TicTacToe ticTacToe){
        this.ticTacToe = ticTacToe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        allowFlag++;
//        JOptionPane.showConfirmDialog(null, "test", "test", JOptionPane.PLAIN_MESSAGE);
        clickedButton = (JButton) e.getSource();
        if (isNewGame(false)){}
        else if (isEmpty()) {
            clickedButton.setText("X");
            isWinner();
            findEmptySquares();
            isWinner();
        }
        else
            JOptionPane.showConfirmDialog(null, "This seat is taken", "Wrong mow", JOptionPane.PLAIN_MESSAGE);

    }

    public void findEmptySquares(){
        for (int i = 0; i < ticTacToe.squares.length; i++) {
            if (ticTacToe.squares[i].getText().equals("")){
                ticTacToe.squares[i].setText("O");
                break;
            }
        }
    }

    public void winnerIsX(){
        x++;
        ticTacToe.score.setText(x + " : " + o);
        JOptionPane.showConfirmDialog(null, "You are winner", "Winner", JOptionPane.PLAIN_MESSAGE);
        isNewGame(true);
    }

    public void winnerIsO(){
        o++;
        ticTacToe.score.setText(x + " : " + o);
        JOptionPane.showConfirmDialog(null, "You lose", "Loser", JOptionPane.PLAIN_MESSAGE);
        isNewGame(true);
    }

    public void isWinner(){
//        Checking horizontal lines
        if (ticTacToe.squares[0].getText().equals(ticTacToe.squares[1].getText()) && ticTacToe.squares[1].getText().equals(ticTacToe.squares[2].getText())){
            if (ticTacToe.squares[0].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[0].getText().equals("O"))
                winnerIsO();
        }
        if (ticTacToe.squares[3].getText().equals(ticTacToe.squares[4].getText()) && ticTacToe.squares[4].getText().equals(ticTacToe.squares[5].getText())){
            if (ticTacToe.squares[3].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[3].getText().equals("O"))
                winnerIsO();
        }
        if (ticTacToe.squares[6].getText().equals(ticTacToe.squares[7].getText()) && ticTacToe.squares[7].getText().equals(ticTacToe.squares[8].getText())){
            if (ticTacToe.squares[6].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[6].getText().equals("O"))
                winnerIsO();
        }

//        Checking vertical lines
        if (ticTacToe.squares[0].getText().equals(ticTacToe.squares[3].getText()) && ticTacToe.squares[3].getText().equals(ticTacToe.squares[6].getText())){
            if (ticTacToe.squares[0].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[0].getText().equals("O"))
                winnerIsO();
        }
        if (ticTacToe.squares[1].getText().equals(ticTacToe.squares[4].getText()) && ticTacToe.squares[4].getText().equals(ticTacToe.squares[7].getText())){
            if (ticTacToe.squares[1].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[1].getText().equals("O"))
                winnerIsO();
        }
        if (ticTacToe.squares[2].getText().equals(ticTacToe.squares[5].getText()) && ticTacToe.squares[5].getText().equals(ticTacToe.squares[8].getText())){
            if (ticTacToe.squares[2].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[2].getText().equals("O"))
                winnerIsO();
        }

//        Checking horizontal lines
        if (ticTacToe.squares[0].getText().equals(ticTacToe.squares[4].getText()) && ticTacToe.squares[4].getText().equals(ticTacToe.squares[8].getText())){
            if (ticTacToe.squares[0].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[0].getText().equals("O"))
                winnerIsO();
        }
        if (ticTacToe.squares[2].getText().equals(ticTacToe.squares[4].getText()) && ticTacToe.squares[4].getText().equals(ticTacToe.squares[6].getText())){
            if (ticTacToe.squares[2].getText().equals("X"))
                winnerIsX();
            else if (ticTacToe.squares[2].getText().equals("O"))
                winnerIsO();
        }

    }

    public boolean isEmpty(){
        if (clickedButton.getText().equals(""))
            return true;
        else
            return false;
    }

    public boolean isNewGame(boolean yes){
        if (clickedButton.getText().equals("New") || yes) {
            for (int i = 0; i < 9; i++) {
                ticTacToe.squares[i].setText("");
            }
            return true;
        } else
            return false;
    }
}
