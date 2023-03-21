package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberbuttons = new JButton[10];
	JButton[] functionbuttons = new JButton[8];
	JButton addButton,subButton,mulButton,divButton,decButton,eqlButton,delButton,clrButton;
	JPanel panel;
	
	Font myfont =new Font("Arial",Font.PLAIN,25);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield =new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myfont);
		textfield.setEditable(false);
		textfield.setBackground(Color.WHITE);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqlButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		functionbuttons[0] = addButton;
		functionbuttons[1] = subButton;
		functionbuttons[2] = mulButton;
		functionbuttons[3] = divButton;
		functionbuttons[4] = decButton;
		functionbuttons[5] = eqlButton;
		functionbuttons[6] = delButton;
		functionbuttons[7] = clrButton;
		
		for(int i=0;i<8;i++){
			functionbuttons[i].addActionListener(this);
			functionbuttons[i].setFont(myfont);
			functionbuttons[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++){
			numberbuttons[i] =new JButton(String.valueOf(i));
			numberbuttons[i].addActionListener(this);
			numberbuttons[i].setFont(myfont);
			numberbuttons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberbuttons[1]);
		panel.add(numberbuttons[2]);
		panel.add(numberbuttons[3]);
		panel.add(addButton);
		panel.add(numberbuttons[4]);
		panel.add(numberbuttons[5]);
		panel.add(numberbuttons[6]);
		panel.add(subButton);
		panel.add(numberbuttons[7]);
		panel.add(numberbuttons[8]);
		panel.add(numberbuttons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberbuttons[0]);
		panel.add(eqlButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	public static void main(String []args) {
		
		Calculator calc =new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++){
			if(e.getSource() == numberbuttons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == eqlButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+' :  result =num1+num2;
					break;
			case '-' : result =num1-num2;
					break;
			case '*' : result =num1*num2;
				break;
			case '/' : result =num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
	}
}
