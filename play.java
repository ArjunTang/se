package curriculum_design;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class play extends JFrame{
	JLabel title=new JLabel("һ�꼶��ѧ����",JLabel.CENTER);
	JButton b=new JButton();
	play()
	{
		setTitle("��ѧ����");
		setSize(600,500);
		setVisible(true);
		setResizable(true);//���ô����Ƿ���Ե���
		setLocationRelativeTo(null);//null��ʾû�в�������е���
		
		
		title.setFont(new Font("����",Font.BOLD,40));
		
		
		ImageIcon bg=new ImageIcon("src/curriculum_design/bg.png");
		JLabel label=new JLabel(bg);
		label.setSize(bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//���ñ���ͼ
		//2.�Ѵ��������Ϊ������岢��Ϊ͸�����������֡�
		JPanel pan=(JPanel)getContentPane();
		pan.setOpaque(false);
		pan.setLayout(new GridLayout(3, 1, 0, 120));
		
		//��ȡһ��ͼƬ
		ImageIcon square=new ImageIcon("src/curriculum_design/start.png");
		//���ð�ť��С
		b.setBounds(0,0,50,50);
		//����ͼƬ�Ĵ�С
		square.setImage(square.getImage().getScaledInstance(600,200,0));
		//��ͼƬ�ŵ���ť��	
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
			// TODO �Զ����ɵķ������
			if(e.getSource()==b)
			{
				test t=new test();
			}
		}
		
	}
}
