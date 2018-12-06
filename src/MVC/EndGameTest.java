package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class EndGameTest.
 */
public class EndGameTest extends View {
	
boolean passedTest = false;
/** The Constant serialVersionUID.  */
private static final long serialVersionUID = 1L;

/** the f. */
public JFrame f;

public JTextField userInput;

/** The user input 1. */
public JTextField userInput1;

/** The user input 2. */
public JTextField userInput2;
public JTextField userInput3;
public JTextField userInput4;
public JTextField userInput5;

/** The screen size. */
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

/** The screen height. */
int screenHeight = (int) screenSize.getHeight();

/** The screen width. */
int screenWidth = screenSize.getSize().width;

/** The question. */
public int question=1;

/** The answer. */
String answer; //correct answer to the questions

/** The counter. */
int counter =0; //counter for tries it takes to answer all questions

/** The a counter. */
int aCounter = 0; //counter for correct answers

/**
 * Instantiates a new end game test.
 */
public EndGameTest() {
//super("Test your Knowledge");

JLabel question1 = new JLabel("How many Phragmites were there?");
JLabel question2 = new JLabel("name an invasive species?");
JLabel question3 = new JLabel("what are Phragmites?");
JLabel question4 = new JLabel("4?");
JLabel question5 = new JLabel("5?");
JLabel question6 = new JLabel("6?");

userInput = new JTextField(20);
userInput1 = new JTextField(20);
userInput2= new JTextField(20);
userInput3 = new JTextField(20);
userInput4 = new JTextField(20);
userInput5= new JTextField(20);

JButton aButton = new JButton("answer");

f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//f.setContentPane(new JLabel(new ImageIcon("images/background.png")));
f.setLayout(new BorderLayout());

JLabel background = new JLabel(new ImageIcon("images/grass_template2.jpg"));
JLabel phragmite = new JLabel(new ImageIcon("images/phragmites.png"));
JLabel nativeplant = new JLabel(new ImageIcon("images/nativeplant.png"));

FlowLayout layout = new FlowLayout();
background.setLayout(layout);

//display order

background.add(question1);
background.add(userInput);

background.add(phragmite);
background.add(question2);
background.add(userInput1);


background.add(question3);
background.add(userInput2);

background.add(nativeplant);
background.add(question4);
background.add(userInput3);

background.add(question5);
background.add(userInput4);

background.add(question6);
background.add(userInput5);

background.add(aButton);

f.add(background);


f.pack();
f.setSize(screenSize);
f.setLocationRelativeTo(null);
f.setVisible(true);
f.setResizable(false);

aButton.addActionListener(new answerButtonHandler());

}


/**
 * Change answer.
 *
 * @return the string
 */
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
		answer = "4";
		break;
	case 5:
		answer = "5";
		break;
	case 6:
		answer = "6";
		break;
	}	
	return answer;
}

/**
 * The Class answerButtonHandler.
 */
private class answerButtonHandler implements ActionListener {
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		String getUserInput=userInput.getText();
		String getUserInput1=userInput1.getText();
		String getUserInput2=userInput2.getText();
		String getUserInput3=userInput3.getText();
		String getUserInput4=userInput4.getText();
		String getUserInput5=userInput5.getText();

		counter++;
		switch (question) {
		case 1:
			if (getUserInput.equals(changeAnswer())) {
				aCounter++;
				question = 2; //change question
			}
		case 2:
			if (getUserInput1.equals(changeAnswer())) {
				aCounter++;
				question = 3; //change question
			}
		case 3:
			if (getUserInput2.equals(changeAnswer())) {
				aCounter++;
				question = 4; //change question
			}
		case 4:
			if (getUserInput3.equals(changeAnswer())) {
				aCounter++;
				question = 5; //change question
			}
		case 5:
			if (getUserInput4.equals(changeAnswer())) {
				aCounter++;
				question = 6; //change question
			}
		case 6:	
			if (getUserInput5.equals(changeAnswer())) {
				aCounter++;
				JOptionPane.showMessageDialog(null, "all answers are correct! It took you "+ counter + " tries", "  ", JOptionPane.INFORMATION_MESSAGE);	
				if (question == 6) {
					passedTest = true;
					aCounter = 0;
					counter=0;
					break;
				}
				break;
			}
		default:
			question = 1;  //reset to question 1
			JOptionPane.showMessageDialog(null, "not all answers correct, you have " +aCounter+" correct answers", " ", JOptionPane.INFORMATION_MESSAGE);
			if (question == 1) {
				aCounter=0;
			}
		}	
	}
}

void testRender() {	
		
	new EndGameTest();


}

public static void main(String args[]) {
	new EndGameTest();
	
}



}
