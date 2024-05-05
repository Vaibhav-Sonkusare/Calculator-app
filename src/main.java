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
	
	double result = 0;
	
	
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
		
		if(e.getSource() == addButton)
        {
            textField.setText(textField.getText() + "+");
        }

        if(e.getSource() == subButton)
        {
            textField.setText(textField.getText() + "-");
        }

        if(e.getSource() == mulButton)
        {
            textField.setText(textField.getText() + "*");
        }

        if(e.getSource() == divButton)
        {
            textField.setText(textField.getText() + "/");
        }

        if(e.getSource() == equButton)
        {
            textField.setText(calculate(textField.getText()));
        }

        if(e.getSource() == clrButton)
        {
            textField.setText("");
        }

        if(e.getSource() == delButton)
        {
            String string = textField.getText();
            textField.setText(string.substring(0, string.length() - 1));
        }

        if(e.getSource() == negButton)
        {
            textField.setText(textField.getText().charAt(0) == '-' ? textField.getText().substring(1) : "-" + textField.getText());
        }
	}


	// BODMAS Calculator
	// 		Sample Input: 4+5*8/2
	//		Output: 24

    // by: manbir singh (https://github.com/0-manbir)

    static String calculate (String inp)
    {
        boolean terminate=false;

        //input only contains negative number
        if(!inp.contains("/") && !inp.contains("*") && !inp.contains("+") && inp.charAt(0)=='-'){
            inp = "0"+inp;
        }

        //input starts with an operator
        char c = inp.charAt(0);
        if((c=='/' || c=='*' || c=='+') && !terminate){
            if(c=='+'){
                inp = "0"+inp;
            }   
            else{
                return "NaN";
            }   
        }

        //input contains no operations
        if(!inp.contains("/") && !inp.contains("*") && !inp.contains("+") && !inp.contains("-") && !terminate){
            return inp;
        }

        //input doesnt contain a number after a symbol
        if(!Character.isDigit(inp.charAt(inp.length()-1)) && !terminate){
            return "NaN";
        }
        String sampler = "";

        //input contains 2 consecutive symbols
        for(int i=0; i<inp.length()-1; i++){
            if(!Character.isDigit(inp.charAt(i)) && !Character.isDigit(inp.charAt(i+1)) && !terminate){
                if((inp.charAt(i)=='+' && inp.charAt(i+1)=='-')||(inp.charAt(i)=='-' && inp.charAt(i+1)=='+')){ 
                    int j = 0;
                    while(j<inp.length()){
                        if(j==i){
                            sampler += "-";
                            j=j+2; continue;
                        }
                        sampler += inp.charAt(j); 
                        j++;
                    }
                    inp = sampler;
                }
                else if(inp.charAt(i)=='-' && inp.charAt(i+1)=='-'){ 
                    int j = 0;
                    while(j<inp.length()){
                        if(j==i){
                            sampler += "+";
                            j=j+2; continue;
                        }
                        sampler += inp.charAt(j); 
                        j++;
                    }
                    inp = sampler;
                }
                else{
                    terminate = true;
                    return "NaN";
                }
            }
        }

        for(int i=0; i<4; i++)
        {
            char[] list = {'/', '*', '+', '-'};

            while(inp.indexOf(list[i]) != -1 && !terminate)
            {
                int indexI = inp.indexOf(list[i]);
                int i1=indexI-1, i2=indexI+1;
                String num1="", num2="";

                //if negative sign is at start
                if(i==3 && indexI==0){
                    //skip the negative and set indexI to the index of next negative
                    for(int j=1; j<inp.length(); j++)
                    {
                        if(inp.charAt(j) == '-')
                        {
                            indexI = j;
                            i1=indexI-1; i2=indexI+1;
                            break;
                        }
                    }
                }

                //store the number to the left of operator in 'num1'
                while(i1 != -1)
                {
                    char ch = inp.charAt(i1);
                    if(ch=='/' || ch== '*' || ch== '+' || ch== '-')
                        break;
                    num1 += ch;
                    i1--;
                }
                //store the number to the right of operator in 'num2'
                while(i2 < inp.length())
                {
                    char ch = inp.charAt(i2);
                    if(ch=='/' || ch== '*' || ch== '+' || ch== '-')
                        break;
                    num2 += ch;
                    i2++;
                }

                //convert string to int, reverse num1 (number on the left of the operator)
                String rev1="", rev2="";
                float n1, n2, n=0;
                for(int j=num1.length()-1; j>=0; j--)
                    rev1+=num1.charAt(j);

                n1 = Float.parseFloat(rev1);
                n2 = Float.parseFloat(num2);

                switch(list[i])
                {
                    case '/':
                        n=n1/n2;
                        break;
                    case '*':
                        n=n1*n2;
                        break;
                    case '+':
                        boolean negative = false;
                        int k=indexI-1;
                        if(k==0)
                            n=n1+n2;

                        if(inp.substring(0,k).indexOf('-')!=-1)
                        {
                            while(k>0)
                            {
                                k--;
                                char ch = inp.charAt(k);
                                if(ch=='*' || ch=='/' || ch=='+')
                                {
                                    n = n1+n2;
                                    break;
                                }
                                else if(ch=='-')
                                {
                                    //found negative
                                    negative = true;
                                    break;
                                }
                            }
                            if(negative)
                            {
                                negative = false;
                                if(n2>n1)
                                {
                                    n = n2-n1;
                                    i1--;
                                }
                                else
                                {
                                    n = n1-n2;
                                    if(k==0 && inp.indexOf('-')==inp.lastIndexOf('-'))
                                    {
                                        n = (float)Math.round(n * 1000f) / 1000f;
                                        inp = "-"+Float.toString(n);
                                        terminate = true;
                                        continue;
                                    }
                                }
                            }
                        }else
                            n=n1+n2;
                        break;

                    case '-':
                        if(inp.indexOf('-')==inp.lastIndexOf('-'))
                        {
                            //only one - remains
                            n = n1 - n2;
                            n = (float)Math.round(n * 1000f) / 1000f;
                            inp = Float.toString(n);
                            terminate = true;
                            continue;
                        }
                        else
                        {
                            //more than one -
                            int count = inp.length() - inp.replace("-","").length();
                            if(inp.charAt(0)=='-' && count==2)
                            {
                                //only one - at start
                                n = n1 + n2;
                                n = (float)Math.round(n * 1000f) / 1000f;
                                inp = "-"+Float.toString(n);
                                terminate = true;
                                continue;
                            }else if(inp.charAt(0)=='-'){
                                //more than one -, and one at start
                                n = Math.abs(n1)+Math.abs(n2);
                            }else{
                                //more than one -, none at start
                                n = n1 - n2;
                            }
                        }
                }

                //round off the result
                n = (float)Math.round(n * 1000f) / 1000f;

                //store the new equation, replacing the operators and operands with the result
                inp = inp.substring(0,i1+1) + n + inp.substring(i2);
            }
        }

        //removing extra 0s
        if(inp.charAt(inp.length()-1)=='0' && inp.charAt(inp.length()-2)=='.')
            inp = inp.substring(0,inp.length()-2);

        return inp;
    }

}
