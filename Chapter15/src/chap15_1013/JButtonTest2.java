package chap15_1013;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JButton2 extends JFrame implements ActionListener{
	JTextField jtf;
	public JButton2() {
		// 텍스트 객체 생성
		jtf = new JTextField(10);
			ImageIcon apple = new ImageIcon("image/apple.jpg");
			ImageIcon banana = new ImageIcon("image/banana.jpg");
			ImageIcon persimmom = new ImageIcon("image/persimmom.jpg");
			ImageIcon pear = new ImageIcon("image/pear.jpg");
			ImageIcon grape = new ImageIcon("image/grape.jpg");
			JButton jb1 = new JButton("사과",apple);
			JButton jb2 = new JButton("바나나",banana);
			JButton jb3 = new JButton("감",persimmom);
			JButton jb4 = new JButton("배",pear);
			JButton jb5 = new JButton("포도",grape);
			Container ct = getContentPane();
			ct.setLayout(new GridLayout(3,2));
			ct.add(jb1);
			ct.add(jb2);
			ct.add(jb3);
			ct.add(jb4);
			ct.add(jb5);
			ct.add(jtf);	//텍스트가 나오게
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);
			jb5.addActionListener(this);
			setTitle("JButton Test2");
			setSize(500,400);
			setVisible(true);			
		}
		public void actionPerformed(ActionEvent ae) {
			jtf.setText(ae.getActionCommand());
	}
}
public class JButtonTest2 {

	public static void main(String[] args) {
		new JButton2();

	}

}
