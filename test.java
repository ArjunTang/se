package curriculum_design;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.*;

import javax.swing.*;

public class test extends JFrame{
	
		Random random = new Random();
		
		//��4������������ָ��������
		
		double proa[]=new double[4];
		double prob[]=new double[4];
		int num=0;//��ǰ���
		JPanel panel01 =new JPanel();
		JLabel problem =new JLabel();
		ButtonGroup group=new ButtonGroup();
		JRadioButton buttona=new JRadioButton();
		JRadioButton buttonb=new JRadioButton();
		JRadioButton buttonc=new JRadioButton();
		JRadioButton buttond=new JRadioButton();
		String operator[]=new String[4];//4����ķ���
		String str_problem[]=new String[4];//�����б�
				
		String a_answer[]=new String[4];//4�����Aѡ��(Aѡ��ȫ�ǶԵ�)			
		String b_answer[]=new String[4];//4�����Bѡ��(Bѡ��ȫ�Ǵ��)
		String c_answer[]=new String[4];//4�����Cѡ��(Cѡ��ȫ�Ǵ��)
		String d_answer[]=new String[4];//4�����Dѡ��(Dѡ��ȫ�Ǵ��)
		//�л���Ŀ������ť����ʾʱ��
		JPanel panel02=new JPanel();//�л���Ŀ��������
		JButton btn_index[]=new JButton[5];//�л���Ŀ��ť
	
		JPanel panel03=new JPanel();
		JButton btn_last=new JButton("��һ��");
		JButton btn_next=new JButton("��һ��");
		JButton btn_finish=new JButton("����");
		JLabel label01=new JLabel("ʣ��ʱ��");
		JLabel label_time=new JLabel("1:00");
		
		//����ֽ����ʾ����
		JPanel panel04 = new JPanel();
		JLabel label_score = new JLabel();
		JLabel image = new JLabel(new ImageIcon());
	
		JPanel imagePanel;
		ImageIcon bg = new ImageIcon("src/curriculum_design/bg.png");
		JLabel label = new JLabel(bg);
		
		//������ʱ��
		Timer timer;
		int minute=1,second=0;
		
		//�ж��û����Ƿ���ȷ
		int right[] = new int[]{1,1,1,1};//��ȷ��
		int my_answer[]=new int[]{0,0,0,0};//�û���
		int score = 0;//��ǰ����Ϊ0
		
	@SuppressWarnings("removal")
	test()
	{
		setTitle("��ѧ����");
		setSize(600,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		for(int i=0;i<4;i++)
		{
			proa[i]=random.nextInt(10);
			String s1=String.format("%.1f",proa[i]);
			proa[i]=Double.parseDouble(s1);
			prob[i]=random.nextInt(10);
			String s2=String.format("%.1f",prob[i]);
			prob[i]=Double.parseDouble(s2);
		}
		
		
		for(int i=0;i<4;i++)//�����������ֵ
		{
			int op=random.nextInt(4);
			if(op==0)
			{
				operator[i]="+";
			}
			else if(op==1)
			{
				operator[i]="-";
			}
			else if(op==2)
			{
				operator[i]="*";
			}
			else if(op==3)
			{
				operator[i]="/";
			}
		}
		//��Ŀ��ֵ
		for(int i=0;i<4;i++)
		{
			String j=String.valueOf(i+1);
			str_problem[i]="("+j+") "+proa[i]+operator[i]+prob[i]+"=";
		}
		for(int i=0;i<4;++i) {
			double ax=proa[i];
			double bx=prob[i];
			if(operator[i]=="+")a_answer[i]=String.valueOf(ax+bx);
			if(operator[i]=="-")a_answer[i]=String.valueOf(ax-bx);
			if(operator[i]=="*")a_answer[i]=String.valueOf(ax*bx);
			if(operator[i]=="/")a_answer[i]=String.valueOf(ax/bx);//���aѡ��ĸ�ֵ
		}
		//��ɶ�BCDѡ��ĸ�ֵ
		for(int i=0;i<4;i++)
		{
			double b=random.nextInt(10);
			String s1=String.format("%.1f",b);
			b=Double.parseDouble(s1);
			double c=random.nextInt(10);
			s1=String.format("%.1f",c);
			c=Double.parseDouble(s1);
			double d=random.nextInt(10);
			s1=String.format("%.1f",d);
			d=Double.parseDouble(s1);
			b_answer[i] = String.valueOf(b);
			c_answer[i] = String.valueOf(c);
			d_answer[i] = String.valueOf(d);

		}
		
		
		
		//��Ŀ
		problem.setFont(new Font("����",Font.BOLD,30));     
		//��ѡ��ťABCD
		buttona.setFont(new Font("����",Font.BOLD,30));     
		buttonb.setFont(new Font("����",Font.BOLD,30));     
		buttonc.setFont(new Font("����",Font.BOLD,30));     
		buttond.setFont(new Font("����",Font.BOLD,30));
		//�����Ŀ��ABCDѡ��
		problem.setText(str_problem[num]);
		buttona.setText(a_answer[num]);
		buttonb.setText(b_answer[num]);
		buttonc.setText(c_answer[num]);
		buttond.setText(d_answer[num]);
		//��4����ѡ��ťΪһ��
		group.add(buttona);      
		group.add(buttonb);      
		group.add(buttonc);      
		group.add(buttond);
		  
		panel01.setLayout(new GridLayout(5, 1, 0, 30));//����5��1�У�ˮƽ���0px����ֱ���30px
		//����Ŀ��ѡ��������  
		panel01.add(problem);
		panel01.add(buttona);
		panel01.add(buttonb);
		panel01.add(buttonc);
		panel01.add(buttond);
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);//����Ŀ��ѡ����������Ϸ�
		

		
		//4������л���ť
		for(int i=0;i<4;i++){
		      btn_index[i]=new JButton(""+(i+1));
		      btn_index[i].setBackground(Color.gray);
		      panel02.add(btn_index[i]);
		      MyListener ml=new MyListener();
		      btn_index[i].addActionListener(ml);
		      
		      }
	      this.add(panel02,BorderLayout.CENTER);
	      
	      btn_last.setEnabled(false);//�������һ��Ĳ����ٵ����һ��
	      //����ʱ������
	      label_time.setFont(new Font("����",Font.BOLD,30));
	      label_time.setForeground(Color.RED);
	      
	      panel03.add(btn_last);//��һ��
	      panel03.add(btn_next);//��һ��
	      panel03.add(btn_finish);//����
	      panel03.add(label01);//ʣ��ʱ��
	      panel03.add(label_time);//����ʱ
	      this.add(panel03,BorderLayout.SOUTH);
	      
	      //��ʾ����
	      label_score.setFont(new Font("����",Font.PLAIN,30));
	      label_score.setForeground(Color.BLUE);
	      panel04.add(label_score);
	      this.add(panel04,BorderLayout.EAST);
	      
	      //���ÿؼ��Ƿ�͸����true��ʾ��͸����false��ʾ͸��
	      buttona.setOpaque(false);
	      buttonb.setOpaque(false);
	      buttonc.setOpaque(false);
	      buttond.setOpaque(false);
	      
	      panel01.setOpaque(false);
	      panel02.setOpaque(false);
	      panel03.setOpaque(false);
	      panel04.setOpaque(false);
	      
	      label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());//ʹ��ǩ���ͼƬ��С
	      
	      imagePanel=(JPanel)this.getContentPane();
	      imagePanel.setOpaque(false);
	      
	      this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//��ӱ���ͼƬ
	      
	      MyListener ml2=new MyListener();
	      btn_last.addActionListener(ml2);
	      btn_next.addActionListener(ml2);
	      btn_finish.addActionListener(ml2);
	      buttona.addActionListener(ml2);
	      buttonb.addActionListener(ml2);
	      buttonc.addActionListener(ml2);
	      buttond.addActionListener(ml2);
	      
	      timer = new Timer(1000,new TimerListener());          
	      timer.start();

	      
	      
}
	
	//�¼�����
	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			for(int i=0;i<5;i++)
			{
	            if(e.getSource()==btn_index[i])
	            {//��ť1��5
	                num = i;//���µ�ǰ���
	                showItem(num);//�л���Ŀ��ѡ��
	                showMychoice(num);//��ʾ��ѡѡ��
	                showButton(num);//�ж���ʾ��Щ��ť
	            }
			}
	            if(e.getSource()==btn_last)
	            {//��һ��
	                if(num>0){
	                    num--;
	                }
	                showItem(num);
	                showMychoice(num);
	                showButton(num);
	            }
	            if(e.getSource()==btn_next)
	            {//��һ��
	                if(num<str_problem.length-1){
	                    num++;
	                }
	                showItem(num);
	                showMychoice(num);
	                showButton(num);
	            }
	            if(e.getSource()==buttona){
	                my_answer[num]=1;
	                btn_index[num].setBackground(Color.GREEN);
	            }
	            if(e.getSource()==buttonb){
	                my_answer[num]=2;
	                btn_index[num].setBackground(Color.GREEN);
	            }
	            if(e.getSource()==buttonc){
	                my_answer[num]=3;
	                btn_index[num].setBackground(Color.GREEN);
	            }
	            if(e.getSource()==buttond){
	                my_answer[num]=4;
	                btn_index[num].setBackground(Color.GREEN);
	            }
	            if(e.getSource()==btn_finish){//����
	                timer.stop();//ֹͣ
	                TextFinish();
	            }
	    }
    }
	
	public class TimerListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
		        // TODO Auto-generated method stub
		        second--;
		        if(second<0){
		            minute--;
		            second=59;
		        }
		        label_time.setText(minute+":"+second);
		        if(minute==0 && second==0){
		            timer.stop();
		            label_time.setText("���Խ�����");
		            TextFinish();
		        }
		  }


		}
			
		public void showItem(int num) {
			// TODO �Զ����ɵķ������
			problem.setText(str_problem[num]);
			buttona.setText(a_answer[num]);
			buttonb.setText(b_answer[num]);
			buttonc.setText(c_answer[num]);
			buttond.setText(d_answer[num]);
			group.clearSelection();//���
		}
		
		public void showMychoice(int i){
			switch(my_answer[i]){
			case 1:
			        buttona.setSelected(true);
			        break;
			case 2:
			        buttonb.setSelected(true);
			        break;
			case 3:
			        buttonc.setSelected(true);
			        break;  
			case 4:
			        buttond.setSelected(true);
			        break;  
			  }
			}
		
		public void showButton (int i){
			if(i==0){//��һ��
			        btn_last.setEnabled(false);
			        btn_next.setEnabled(true);


			}else if(i==str_problem.length-1){//���һ��
			        btn_last.setEnabled(true);
			        btn_next.setEnabled(false);
			}else{//������
			        btn_last.setEnabled(true);
			        btn_next.setEnabled(true);
			    }       
			}
		//���Խ���
		public void TextFinish(){
			//���а�ť�޷����
			btn_last.setEnabled(false);//���ܵ��
			btn_next.setEnabled(false);
			btn_finish.setEnabled(false);
			buttona.setEnabled(false);
			buttonb.setEnabled(false);
			buttonc.setEnabled(false);
			buttond.setEnabled(false);
	        //�жϴ�
			String eva="";
	        for(int i=0;i<4;i++){
	            //btn_index[i].setEnabled(false);
	            if(my_answer[i]==right[i]){
	                score=score+25;
	            }
	        }
	        if(score==0){
	        	eva="�޶�֮��";
	        }
	        else if(score==25){
	        	eva="����֮��";
	        }
	        else if(score==50) {
	        	eva="����֮��";
	        }
	        else if(score==75) {
	        	eva="����֮��";
	        }
	        else {
	        	eva="�������";
	        }
	        label_score.setText("�ܳɼ���"+score+"("+eva+")");
			}
		}
		
