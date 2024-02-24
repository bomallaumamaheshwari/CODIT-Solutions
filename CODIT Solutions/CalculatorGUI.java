//Task 2 (Bonus Task) Basic Calculator GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class CalculatorGUI extends JFrame
{
    JButton add,subtract,multiply,divide;
    JTextField num1,num2;
    JLabel result,enter1,enter2;
    
    CalculatorGUI()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        enter1 = new JLabel("1st: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        
        add(enter1,c);
        
        num1 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        add(num1,c);
        
        enter2 = new JLabel("2nd: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=1;
        //c.gridwidth = 1;
        add(enter2,c);
        
        num2 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridx=1;
        add(num2,c);    
        
        // adding the buttons
        add = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=2;
        c.gridwidth = 1;
        add(add,c);
        
        subtract = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=2;
        add(subtract,c);
        
        multiply = new JButton("*");
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(multiply,c);
        
        divide = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=3;
        c.gridy=2;
        add(divide,c);
        
        result = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=4;
        add(result,c);
        
        event a = new event();
        add.addActionListener(a);
        subtract.addActionListener(a);
        multiply.addActionListener(a);
        divide.addActionListener(a);
    }
    
    class event implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            double number1,number2;
            
            try
            {
                number1=Double.parseDouble(num1.getText());             
            }
            catch(NumberFormatException e)
            {
                result.setText("Illegal data 1st Field");
                result.setForeground(Color.BLUE);
                return;
            }
            try
            {
                number2 = Double.parseDouble(num2.getText());               
            }
            catch(NumberFormatException e)
            {
                result.setText("Illegal data 2nd Field");
                result.setForeground(Color.GREEN);
                return;
            }
            String op = a.getActionCommand(); // op for operator
            
            
            if(op.equals("+"))
            {   
                double sum = number1+number2;
                result.setText(number1+"+"+number2+"="+sum);
                result.setForeground(Color.RED);
            }
            if(op.equals("-"))
            {
                double diff = number1-number2;
                result.setText(number1+"-"+number2+"="+diff);
                result.setForeground(Color.ORANGE);
            }
            if(op.equals("*"))
            {
                double product = number1*number2;
                result.setText(number1+"*"+number2+"="+product);
                result.setForeground(Color.GREEN);
            }
            if(op.equals("/"))
            {
                if(number2==0)
                {
                    result.setText("Cannot divide by zero");
                    result.setForeground(Color.RED);
                }
                else
                {
                    double quo = number1/number2;
                    result.setText(number1+"/"+number2+"="+quo);
                    result.setForeground(Color.BLUE);                   
                }
                }
            }
        }
    public static void main(String args[])
    {
        CalculatorGUI ob = new CalculatorGUI();
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setTitle("Calculator");
        ob.setVisible(true);
        ob.setSize(200,200);
    }
}