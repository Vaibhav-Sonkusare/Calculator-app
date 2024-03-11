import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main implements ActionListener{

	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JButton [] numberButtons = new JButton[10];
	JButton [] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	
	main()
	{
		frame = new JFrame("Simple Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50,23,300,50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		divButton = new JButton("/");
		subButton = new JButton("-");
		decButton = new JButton(".");
		delButton = new JButton("Delete");
		clrButton = new JButton("clr");
		equButton = new JButton("=");
		mulButton = new JButton("*");
		negButton = new JButton("(-)");
		
    functionButtons[0] = addButton;
    functionButtons[1] = divButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = clrButton;
    functionButtons[4] = subButton;
    functionButtons[5] = decButton;
    functionButtons[6] = delButton;
    functionButtons[7] = equButton;
    functionButtons[8] = negButton;
    
    for(int i = 0; i < 9; i++)
    {
    	functionButtons[i].addActionListener(this);
    	functionButtons[i].setFont(myFont);
    	functionButtons[i].setFocusable(false);
    	
    }
    
    for(int i = 0; i < 10; i++)
    {
    	numberButtons[i] = new JButton(String.valueOf(i));
    	numberButtons[i].addActionListener(this);
    	numberButtons[i].setFont(myFont);
    	numberButtons[i].setFocusable(false);
    	
    }
    
    negButton.setBounds(50,430,100,50);
    delButton.setBounds(150,430,100,50);
    clrButton.setBounds(250,430,100,50);
    
    panel = new JPanel();
    panel.setBounds(50,100,300,300);
    panel.setLayout(new GridLayout(4,4,10,10));
    
    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);
    
    
    
    
		
		frame.add(panel);
		frame.add(clrButton);
		frame.add(delButton);
		frame.add(negButton);
		frame.add(textField);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
main calc = new main();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++)
		{
			if(e.getSource() == numberButtons[i])
			{
				textField.setText(textField.getText().concat(String.valueOf(i)));
				
			}
		}
		
		if(e.getSource() == decButton)
		{
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource() == addButton)
		{
			
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
			
		}
		
		if(e.getSource() == subButton)
		{
			
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
			
		}
		
		if(e.getSource() == mulButton)
		{
			
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
			
		}
		
		if(e.getSource() == divButton)
		{
			
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
			
		}
		
		if(e.getSource() == equButton)
		{
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator)
			{
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 *  num2;
				break;
			case '/':
				result = num1 /  num2;
				break;
			}
			
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrButton)
		{
			textField.setText("");
			
		}
		
		if(e.getSource() == delButton)
		{
		  String string = textField.getText();
		  textField.setText("");
		  
		  for(int i = 0; i < string.length() - 1; i++)
		  {
			  textField.setText(textField.getText() + string.charAt(i));
			  //.out.print(string.charAt(i));
		  }
			
			
		}
		
		if(e.getSource() == negButton)
		{
			
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}

}
