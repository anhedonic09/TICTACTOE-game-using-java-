import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Practice 
{
	JFrame jf=new JFrame("TicTacToe");
	JLabel bg=new JLabel(new ImageIcon(getClass().getResource("bg_blur.png")));
	JPanel []pan=new JPanel[3];
	JLabel text=new JLabel("First Player Turn");
	JButton []btn=new JButton[9];
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	
	JButton reset=new JButton("RESET");
	int player=1;
	int flag=0;
	int count=0;
	
	public Practice() 
	{
		jf.setSize(400,600);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.add(bg);
		addPanel();
		jf.setVisible(true);
		
	}
	
	public void addPanel()
	{
		bg.setLayout(null);
		for(int i=0;i<3;i++) 
		{	
			pan[i]=new JPanel();
			bg.add(pan[i]);
			
		}
		pan[0].setBounds(20,40,345,50);
		pan[0].setBackground(Color.white);
		pan[1].setBounds(20,110,345,345);
		pan[1].setBackground(Color.white);
		pan[2].setBounds(20,485,345,40);
		pan[2].setOpaque(false);
		setComponents();
		addButtons();
		
	} 
	private void setComponents()
	{
		Font fo=new Font("arial",1,25);
		text.setFont(fo);
		text.setForeground(Color.red);
		pan[0].add(text);
		
		pan[2].add(reset);
		reset.addActionListener(new ResetListener());
		reset.setEnabled(false);
		
	}
	
	private void addButtons() 
	{
		pan[1].setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++)
		{
			btn[i]=new JButton();
			btn[i].addActionListener(new buttonPress());
			btn[i].setBackground(Color.pink);
			pan[1].add(btn[i]);
			
		}
		
	}
	class buttonPress implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			 JButton obj=(JButton) e.getSource();
			 if(obj.getIcon()!=null ||flag==1)
			 {
				 JOptionPane.showMessageDialog(jf, "wrong clicked");
				 return;
			 }
			 
			 
			 
			 
			 if(player==1)
			 {
				 obj.setIcon(icon1);
				 text.setText("Second Player turn...");
				 text.setForeground(Color.blue);
				 player=2;
			 }
			 else if(player==2) 
			 {
				 obj.setIcon(icon2);
				 text.setText("First Player turn...");
				 text.setForeground(Color.red);
				 player=1;
			 }
			 count++;
			findWinner();
			
			
		}
		
	}
	private void findWinner() 
	{
		if(btn[0].getIcon()==icon1 && btn[1].getIcon()==icon1 && btn[2].getIcon()==icon1  )
			announceWinner(0,1,2,"first");
		if(btn[3].getIcon()==icon1 && btn[4].getIcon()==icon1 && btn[5].getIcon()==icon1)
			announceWinner(3,4,5,"first");
		if(btn[6].getIcon()==icon1 && btn[7].getIcon()==icon1 && btn[8].getIcon()==icon1  )
			announceWinner(6,7,8,"first");
		if(btn[0].getIcon()==icon1 && btn[3].getIcon()==icon1 && btn[6].getIcon()==icon1)
			announceWinner(0,3,6,"first");
		if(btn[1].getIcon()==icon1 && btn[4].getIcon()==icon1 && btn[7].getIcon()==icon1  )
			announceWinner(1,4,7,"first");
		if(btn[2].getIcon()==icon1 && btn[5].getIcon()==icon1 && btn[8].getIcon()==icon1)
			announceWinner(2,5,8,"first");
		if(btn[0].getIcon()==icon1 && btn[4].getIcon()==icon1 && btn[8].getIcon()==icon1  )
			announceWinner(0,4,8,"first");
		if(btn[2].getIcon()==icon1 && btn[4].getIcon()==icon1 && btn[6].getIcon()==icon1)
			announceWinner(2,4,6,"first");
	
		
		if(btn[0].getIcon()==icon2 && btn[1].getIcon()==icon2 && btn[2].getIcon()==icon2  )
			announceWinner(0,1,2,"second");
		if(btn[3].getIcon()==icon2 && btn[4].getIcon()==icon2 && btn[5].getIcon()==icon2)
			announceWinner(3,4,5,"second");
		if(btn[6].getIcon()==icon2 && btn[7].getIcon()==icon2 && btn[8].getIcon()==icon2  )
			announceWinner(6,7,8,"second");
		if(btn[0].getIcon()==icon2 && btn[3].getIcon()==icon2 && btn[6].getIcon()==icon2)
			announceWinner(0,3,6,"second");
		if(btn[1].getIcon()==icon2 && btn[4].getIcon()==icon2 && btn[7].getIcon()==icon2  )
			announceWinner(1,4,7,"second");
		if(btn[2].getIcon()==icon2 && btn[5].getIcon()==icon2 && btn[8].getIcon()==icon2)
			announceWinner(2,5,8,"second");
		if(btn[0].getIcon()==icon2 && btn[4].getIcon()==icon2 && btn[8].getIcon()==icon2  )
			announceWinner(0,4,8,"second");
		if(btn[2].getIcon()==icon2 && btn[4].getIcon()==icon2 && btn[6].getIcon()==icon2)
			announceWinner(2,4,6,"second");
		
		if(flag==1)
		{
			return;
		}
		else if(count==9)
		{
			text.setText("Match Draw");
			JOptionPane.showMessageDialog(jf, "No One Won");
			reset.setEnabled(true);
		}
		
		
	}
	
	
	
	
	private void announceWinner(int x,int y,int z,String p)
	{
		btn[x].setBackground(Color.white);
		btn[y].setBackground(Color.white);
		btn[z].setBackground(Color.white);
		flag=1;
		text.setText("GameOver");
		JOptionPane.showMessageDialog(jf, p+" player Win");
		reset.setEnabled(true);
		
		
	}
	
	class ResetListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i=0;i<9;i++)
			{
				
				btn[i].setIcon(null);
				btn[i].setBackground(Color.pink);
				
			}
			
			text.setText("First Player Turn");
			reset.setEnabled(false);
			player=1;
			flag=0;
			count=0;
		}
		
	}
	
	
	public static void main(String[] args) 
	{
          new Practice();
	}



}
