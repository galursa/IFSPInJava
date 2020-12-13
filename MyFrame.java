package fract;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	JButton btn = new JButton("Wybierz");
	JRadioButton f1, f2;
	JPanel panel, panel2;
	public MyFrame() {
		super("Fraktale");
		setSize(600, 600);	
 		setLayout(new FlowLayout());
 		//dodajemy przyciski radio
 		f1=new JRadioButton("Trójk¹t Sierpiñskiego");    
 		f1.setBounds(100,50,100,30);      
 		f2=new JRadioButton("Niespodzianka");    
 		//wi¹¿emy przyciski w grupê i dodajemy do niej.
 		f2.setBounds(100,100,100,30);    
 		ButtonGroup grupa=new ButtonGroup();    
 		grupa.add(f1);
 		grupa.add(f2);    
 		add(f1);
 		add(f2);
 		add(btn);
		panel = new MyPanel();
		panel2 = new MyPanel2();
 		 btn.addActionListener((ActionListener) this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn) {
        	if(f1.isSelected()){    
        		
        		remove(panel2);
        		pack();
        		panel.updateUI();
        		add(panel);
        		pack();
        		}    
        	if(f2.isSelected()){    
        		remove(panel);
        		pack();
        		panel2.updateUI();
        		add(panel2);
        		pack();    
        		}    
        	
        }
    }
}

