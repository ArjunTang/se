package curriculum_design;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class play extends JFrame{
	JLabel title=new JLabel("一年级数学考试",JLabel.CENTER);
	JButton b=new JButton();
	play()
	{
		setTitle("数学考试");
		setSize(600,500);
		setVisible(true);
		setResizable(true);//设置窗口是否可以调整
		setLocationRelativeTo(null);//null表示没有参照物，居中电脑
		
		
		title.setFont(new Font("宋体",Font.BOLD,40));
		
		
		ImageIcon bg=new ImageIcon("src/curriculum_design/bg.png");
		JLabel label=new JLabel(bg);
		label.setSize(bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//放置背景图
		//2.把窗口面板设为内容面板并设为透明、流动布局。
		JPanel pan=(JPanel)getContentPane();
		pan.setOpaque(false);
		pan.setLayout(new GridLayout(3, 1, 0, 120));
		
		//获取一个图片
		ImageIcon square=new ImageIcon("src/curriculum_design/start.png");
		//设置按钮大小
		b.setBounds(0,0,50,50);
		//设置图片的大小
		square.setImage(square.getImage().getScaledInstance(600,200,0));
		//把图片放到按钮上	
		b.setIcon(square);
		add(title);
		add(b);
		Chick c=new Chick();
		b.addActionListener(c);
		
	}
	class Chick implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==b)
			{
				test t=new test();
			}
		}
		
	}
}
