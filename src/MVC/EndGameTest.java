package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameTest extends JFrame {

private static final long serialVersionUID = 1L;
public JFrame f;
public JTextField userInput;
public JTextField userInput1;
public JTextField userInput2;

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int screenHeight = (int) screenSize.getHeight();
int screenWidth = screenSize.getSize().width;

public int question=1;
String answer; //correct answer to the questions
int counter =0; //counter for tries it takes to answer all questions
int aCounter = 0; //counter for correct answers

public EndGameTest() {
super("Test your Knowledge");

f = new JFrame();
f.setLayout(new BorderLayout());

JPanel p = new JPanel(new GridLayout(10,10));
JPanel p2 = new JPanel();
JPanel p3 = new JPanel(new BorderLayout());


JButton d = new JButton("answer");
p2.add(d);
p3.add(p2, BorderLayout.EAST);
f.add(p3, BorderLayout.SOUTH);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.pack();
f.setVisible(true);

//test questions
JLabel question1 = new JLabel("How many Phragmites were there?");
JLabel question2 = new JLabel("name an invasive species?");
JLabel question3 = new JLabel("what are Phragmites?");

//answer boxes
userInput = new JTextField(8);
userInput1 = new JTextField(8);
userInput2= new JTextField(8);

//set location
userInput.setBounds(screenWidth/2-75,150,100,50);
userInput1.setBounds(screenWidth/2-75,250,100,50);
userInput2.setBounds(screenWidth/2-75,350,100,50);

//display order
p.add(question1);
p.add(userInput);

p.add(question2);
p.add(userInput1);

p.add(question3);
p.add(userInput2);

f.add(p, BorderLayout.CENTER);


f.setSize(screenSize);
f.setLocationRelativeTo(null);
f.setVisible(true);
f.setResizable(false);


d.addActionListener(new answerButtonHandler());

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

 @SuppressWarnings("unused")
EndGameTest tester = new EndGameTest();

}
}