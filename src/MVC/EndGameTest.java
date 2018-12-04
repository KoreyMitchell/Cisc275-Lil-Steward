package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class EndGameTest extends JFrame {


private static final long serialVersionUID = 1L;

private JTextField userInput;
private JTextField userInput1;
private JTextField userInput2;

public int question=1;
String answer; //correct answer to the questions
int counter =0; //counter for tries it takes to answer all questions
int aCounter = 0; //counter for correct answers

public EndGameTest() {
super("Test your Knowledge");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


setLayout(new FlowLayout());
Container c = getContentPane();


JButton answerButton = new JButton("Enter Answer");

//test questions
JLabel question1 = new JLabel("How many Phragmites were there?");
JLabel question2 = new JLabel("name an invasive species?");
JLabel question3 = new JLabel("what are Phragmites?");

//answer boxes
userInput = new JTextField(8);
userInput1 = new JTextField(8);
userInput2= new JTextField(8);

//display order
c.add(question1);
c.add(userInput);

c.add(question2);
c.add(userInput1);

c.add(question3);
c.add(userInput2);

c.add(answerButton);


setSize(340, 200);
setLocationRelativeTo(null);
setVisible(true);
setResizable(false);


answerButton.addActionListener(new answerButtonHandler());

}


public String changeAnswer() {
	switch (question) {
	case 1:
		answer = "1";
		break;
	case 2:
		answer = "Phragmites";
		break;
	case 3:
		answer = "invasive";
		break;
	case 4:
		answer = " ";
		break;
	case 5:
		answer = " ";
		break;
	}	
	return answer;
}

private class answerButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {

		String getUserInput;
		String getUserInput1;
		String getUserInput2;


		getUserInput = userInput.getText();
		System.out.println(getUserInput);
		getUserInput1 = userInput1.getText();
		System.out.println(getUserInput1);
		getUserInput2 = userInput2.getText();
		System.out.println(getUserInput2);
		
		System.out.println(changeAnswer());
		
		
		counter++;
		if (getUserInput.equals(changeAnswer())) {
			aCounter++;
			question = 2; //change question
			if (getUserInput1.equals(changeAnswer())) {
				aCounter++;
				question=3; //change question
				System.out.println("entered state 2");
				if (getUserInput2.equals(changeAnswer())) {
					aCounter++;
					System.out.println("entered state 3");
					JOptionPane.showMessageDialog(null, "all answers are correct! It took you "+ counter + " tries", "  ", JOptionPane.INFORMATION_MESSAGE);	
					return;
				}
			}
		}
		
		else { //if one answer is wrong
			question = 1;  //reset to question 1
			JOptionPane.showMessageDialog(null, "not all answers correct, you have " +aCounter+" correct answers", " ", JOptionPane.INFORMATION_MESSAGE);
			if (question == 1) {
				aCounter=0;
			}
		}
	}
}




public static void main(String args[]) {

 EndGameTest tester = new EndGameTest();

}
}