import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class tictactoe implements ActionListener {

	private JPanel contentPane;
	private JLabel txtTictactoe = new JLabel();;
	private JFrame Frame = new JFrame();
	private JButton[] button = new JButton[9];
	Random rand = new Random();
	boolean player1_turn;

	public tictactoe() {
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(500,500);
		Frame.getContentPane().setBackground(new Color(50,50,50));
		Frame.setLayout(new BorderLayout());
		Frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBounds(0,0,800,100);		
		txtTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTictactoe.setForeground(Color.RED);
		txtTictactoe.setBackground(Color.BLACK);
		txtTictactoe.setFont(new Font("MV Boli", Font.BOLD, 20));
		txtTictactoe.setText("Tic-Tac-Toe");
		txtTictactoe.setOpaque(true);
		
		contentPane.add(txtTictactoe);
		
		JPanel Button_panel = new JPanel();
		Button_panel.setLayout(new GridLayout(3,3));
		Button_panel.setBackground(Color.BLACK);
		for(int i=0;i<9;i++) {
			button[i] = new JButton();
			Button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,100));
			button[i].setFocusable(false);
			button[i].addActionListener((ActionListener) this);
		}
		contentPane.add(txtTictactoe);
		Frame.add(contentPane,BorderLayout.NORTH);
		Frame.add(Button_panel);
		
		firstTurn();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						player1_turn = false;
						txtTictactoe.setText("O turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						player1_turn = true;
						txtTictactoe.setText("X turn");
						check();
				}
			}
		 }
	  }
  }
	
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(rand.nextInt(2)==0) {
			player1_turn = true;
			txtTictactoe.setText("X turn");
			
		}
		else {
			player1_turn = false;
			txtTictactoe.setText("O turn");
		}
	}
	public void check() {
		//X wins condition
		if(
				(button[0].getText()=="X")&&
				(button[1].getText()=="X")&&
				(button[2].getText()=="X")){
			xWins(0,1,2);
		}
		if(
				(button[3].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[5].getText()=="X")){
			xWins(3,4,5);
		}
		if(
				(button[6].getText()=="X")&&
				(button[7].getText()=="X")&&
				(button[8].getText()=="X")){
			xWins(6,7,8);
		}
		if(
				(button[0].getText()=="X")&&
				(button[3].getText()=="X")&&
				(button[6].getText()=="X")){
			xWins(0,3,6);
		}
		if(
				(button[1].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[7].getText()=="X")){
			xWins(1,4,7);
		}
		if(
				(button[2].getText()=="X")&&
				(button[5].getText()=="X")&&
				(button[8].getText()=="X")){
			xWins(2,5,8);
		}
		if(
				(button[0].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[8].getText()=="X")){
			xWins(0,4,8);
		}
		if(
				(button[2].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[6].getText()=="X")){
			xWins(2,4,6);
		}
		//check O wins
		if(
				(button[0].getText()=="O")&&
				(button[1].getText()=="O")&&
				(button[2].getText()=="O")){
			oWins(0,1,2);
		}
		if(
				(button[3].getText()=="O")&&
				(button[4].getText()=="O")&&
				(button[5].getText()=="O")){
			oWins(3,4,5);
		}
		if(
				(button[6].getText()=="O")&&
				(button[7].getText()=="O")&&
				(button[8].getText()=="O")){
			oWins(6,7,8);
		}
		if(
				(button[0].getText()=="O")&&
				(button[3].getText()=="O")&&
				(button[6].getText()=="O")){
			oWins(0,3,6);
		}
		if(
				(button[1].getText()=="O")&&
				(button[4].getText()=="O")&&
				(button[7].getText()=="O")){
			oWins(1,4,7);
		}
		if(
				(button[2].getText()=="O")&&
				(button[5].getText()=="O")&&
				(button[8].getText()=="O")){
			oWins(2,5,8);
		}
		if(
				(button[0].getText()=="O")&&
				(button[4].getText()=="O")&&
				(button[8].getText()=="O")){
			oWins(0,4,8);
		}
		if(
				(button[2].getText()=="O")&&
				(button[4].getText()=="O")&&
				(button[6].getText()=="O")){
			oWins(2,4,6);
		}

	}
	public void xWins(int a ,int b,int c) {
		button[a].setBackground(Color.YELLOW);
		button[b].setBackground(Color.YELLOW);
		button[c].setBackground(Color.YELLOW);
		
		for(int i =0;i<9;i++) {
			button[i].setEnabled(false);
		}
		txtTictactoe.setText("X Wins!");
	}
	public void oWins(int a ,int b,int c) {
		button[a].setBackground(Color.YELLOW);
		button[b].setBackground(Color.YELLOW);
		button[c].setBackground(Color.YELLOW);
		
		for(int i =0;i<9;i++) {
			button[i].setEnabled(false);
		}
		txtTictactoe.setText("O Wins!");
	}
	public static void main(String[] args) {
	    tictactoe t = new tictactoe();
	}

}
