package curriculum_design;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.*;

import javax.swing.*;

public class test extends JFrame{
	
		Random random = new Random();
		
		//给4道题的两个数字赋予随机数
		
		double proa[]=new double[4];
		double prob[]=new double[4];
		int num=0;//当前题号
		JPanel panel01 =new JPanel();
		JLabel problem =new JLabel();
		ButtonGroup group=new ButtonGroup();
		JRadioButton buttona=new JRadioButton();
		JRadioButton buttonb=new JRadioButton();
		JRadioButton buttonc=new JRadioButton();
		JRadioButton buttond=new JRadioButton();
		String operator[]=new String[4];//4道题的符号
		String str_problem[]=new String[4];//问题列表
				
		String a_answer[]=new String[4];//4道题的A选项(A选项全是对的)			
		String b_answer[]=new String[4];//4道题的B选项(B选项全是错的)
		String c_answer[]=new String[4];//4道题的C选项(C选项全是错的)
		String d_answer[]=new String[4];//4道题的D选项(D选项全是错的)
		//切换题目，交卷按钮，显示时间
		JPanel panel02=new JPanel();//切换题目的容器包
		JButton btn_index[]=new JButton[5];//切换题目按钮
	
		JPanel panel03=new JPanel();
		JButton btn_last=new JButton("上一题");
		JButton btn_next=new JButton("下一题");
		JButton btn_finish=new JButton("交卷");
		JLabel label01=new JLabel("剩下时间");
		JLabel label_time=new JLabel("1:00");
		
		//换壁纸，显示分数
		JPanel panel04 = new JPanel();
		JLabel label_score = new JLabel();
		JLabel image = new JLabel(new ImageIcon());
	
		JPanel imagePanel;
		ImageIcon bg = new ImageIcon("src/curriculum_design/bg.png");
		JLabel label = new JLabel(bg);
		
		//创建计时器
		Timer timer;
		int minute=1,second=0;
		
		//判断用户答案是否正确
		int right[] = new int[]{1,1,1,1};//正确答案
		int my_answer[]=new int[]{0,0,0,0};//用户答案
		int score = 0;//当前分数为0
		
	@SuppressWarnings("removal")
	test()
	{
		setTitle("数学考试");
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
		
		
		for(int i=0;i<4;i++)//给符号随机赋值
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
		//题目赋值
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
			if(operator[i]=="/")a_answer[i]=String.valueOf(ax/bx);//完成a选项的赋值
		}
		//完成对BCD选项的赋值
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
		
		
		
		//题目
		problem.setFont(new Font("宋体",Font.BOLD,30));     
		//单选按钮ABCD
		buttona.setFont(new Font("宋体",Font.BOLD,30));     
		buttonb.setFont(new Font("宋体",Font.BOLD,30));     
		buttonc.setFont(new Font("宋体",Font.BOLD,30));     
		buttond.setFont(new Font("宋体",Font.BOLD,30));
		//填充题目及ABCD选项
		problem.setText(str_problem[num]);
		buttona.setText(a_answer[num]);
		buttonb.setText(b_answer[num]);
		buttonc.setText(c_answer[num]);
		buttond.setText(d_answer[num]);
		//绑定4个单选按钮为一组
		group.add(buttona);      
		group.add(buttonb);      
		group.add(buttonc);      
		group.add(buttond);
		  
		panel01.setLayout(new GridLayout(5, 1, 0, 30));//布局5行1列，水平间隔0px，竖直间隔30px
		//把题目和选项打到面板上  
		panel01.add(problem);
		panel01.add(buttona);
		panel01.add(buttonb);
		panel01.add(buttonc);
		panel01.add(buttond);
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);//让题目和选项能在面板上方
		

		
		//4道题的切换按钮
		for(int i=0;i<4;i++){
		      btn_index[i]=new JButton(""+(i+1));
		      btn_index[i].setBackground(Color.gray);
		      panel02.add(btn_index[i]);
		      MyListener ml=new MyListener();
		      btn_index[i].addActionListener(ml);
		      
		      }
	      this.add(panel02,BorderLayout.CENTER);
	      
	      btn_last.setEnabled(false);//设置最后一题的不能再点击下一题
	      //倒计时的字体
	      label_time.setFont(new Font("黑体",Font.BOLD,30));
	      label_time.setForeground(Color.RED);
	      
	      panel03.add(btn_last);//上一题
	      panel03.add(btn_next);//下一题
	      panel03.add(btn_finish);//交卷
	      panel03.add(label01);//剩下时间
	      panel03.add(label_time);//倒计时
	      this.add(panel03,BorderLayout.SOUTH);
	      
	      //显示分数
	      label_score.setFont(new Font("黑体",Font.PLAIN,30));
	      label_score.setForeground(Color.BLUE);
	      panel04.add(label_score);
	      this.add(panel04,BorderLayout.EAST);
	      
	      //设置控件是否透明，true表示不透明，false表示透明
	      buttona.setOpaque(false);
	      buttonb.setOpaque(false);
	      buttonc.setOpaque(false);
	      buttond.setOpaque(false);
	      
	      panel01.setOpaque(false);
	      panel02.setOpaque(false);
	      panel03.setOpaque(false);
	      panel04.setOpaque(false);
	      
	      label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());//使标签变成图片大小
	      
	      imagePanel=(JPanel)this.getContentPane();
	      imagePanel.setOpaque(false);
	      
	      this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//添加背景图片
	      
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
	
	//事件处理
	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			for(int i=0;i<5;i++)
			{
	            if(e.getSource()==btn_index[i])
	            {//按钮1到5
	                num = i;//更新当前题号
	                showItem(num);//切换题目和选项
	                showMychoice(num);//显示已选选项
	                showButton(num);//判断显示哪些按钮
	            }
			}
	            if(e.getSource()==btn_last)
	            {//上一题
	                if(num>0){
	                    num--;
	                }
	                showItem(num);
	                showMychoice(num);
	                showButton(num);
	            }
	            if(e.getSource()==btn_next)
	            {//下一题
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
	            if(e.getSource()==btn_finish){//交卷
	                timer.stop();//停止
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
		            label_time.setText("考试结束！");
		            TextFinish();
		        }
		  }


		}
			
		public void showItem(int num) {
			// TODO 自动生成的方法存根
			problem.setText(str_problem[num]);
			buttona.setText(a_answer[num]);
			buttonb.setText(b_answer[num]);
			buttonc.setText(c_answer[num]);
			buttond.setText(d_answer[num]);
			group.clearSelection();//清空
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
			if(i==0){//第一题
			        btn_last.setEnabled(false);
			        btn_next.setEnabled(true);


			}else if(i==str_problem.length-1){//最后一题
			        btn_last.setEnabled(true);
			        btn_next.setEnabled(false);
			}else{//其余题
			        btn_last.setEnabled(true);
			        btn_next.setEnabled(true);
			    }       
			}
		//考试结束
		public void TextFinish(){
			//所有按钮无法点击
			btn_last.setEnabled(false);//不能点击
			btn_next.setEnabled(false);
			btn_finish.setEnabled(false);
			buttona.setEnabled(false);
			buttonb.setEnabled(false);
			buttonc.setEnabled(false);
			buttond.setEnabled(false);
	        //判断答案
			String eva="";
	        for(int i=0;i<4;i++){
	            //btn_index[i].setEnabled(false);
	            if(my_answer[i]==right[i]){
	                score=score+25;
	            }
	        }
	        if(score==0){
	        	eva="愚钝之才";
	        }
	        else if(score==25){
	        	eva="下世之才";
	        }
	        else if(score==50) {
	        	eva="中世之才";
	        }
	        else if(score==75) {
	        	eva="上世之才";
	        }
	        else {
	        	eva="旷世奇才";
	        }
	        label_score.setText("总成绩："+score+"("+eva+")");
			}
		}
		
