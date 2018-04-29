
import javax.swing.*;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;

public class TicTacToe {

    JPanel centerPanel;
    JPanel windowContent;

    JButton[] squares;
    JButton newGame;

    JLabel label;
    JLabel score;

    TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(this);

    TicTacToe(){

        windowContent = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);
        squares = new JButton[9];

        centerPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(4,4);
        centerPanel.setLayout(gridLayout);

        for (int i = 0; i < squares.length; i++) {
            squares[i] = new JButton();
            squares[i].setBackground(Color.LIGHT_GRAY);
            centerPanel.add(squares[i]);
            squares[i].addActionListener(ticTacToeEngine);
        }

        newGame = new JButton("New");
        newGame.setBackground(Color.yellow);
        centerPanel.add(newGame);
        newGame.addActionListener(ticTacToeEngine);

        label = new JLabel("Your turn");
        centerPanel.add(label);

        score = new JLabel("0 : 0");
        centerPanel.add(score);

        windowContent.add("Center", centerPanel);

        JFrame jFrame = new JFrame();
        jFrame.setContentPane(windowContent);

        jFrame.setSize(250, 250);
        jFrame.setVisible(true);

    }
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
