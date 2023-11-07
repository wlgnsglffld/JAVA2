package chap15_1027;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JCheckBox1 extends JFrame implements ItemListener{
	JTextField jtf;
	public JCheckBox1() {
		jtf = new JTextField(20);
		JCheckBox cj1 = new JCheckBox("JSP");
		JCheckBox cp1 = new JCheckBox("PHP");
		JCheckBox ca1 = new JCheckBox("ASP");
		JCheckBox cs1 = new JCheckBox("Serlet");
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		ct.add(cj1);
		ct.add(cp1);
		ct.add(ca1);
		ct.add(cs1);
		ct.add(jtf);
		cj1.addItemListener(this);
		cp1.addItemListener(this);
		ca1.addItemListener(this);
		cs1.addItemListener(this);
		setTitle("JCheckBoxTest1");
		setSize(250,100);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		jtf.setText(((JCheckBox)ie.getItem()).getText());	
	}
}

public class JCheckBoxTest1 {
	public static void main(String[] args) {
		new JCheckBox1();
	}
}
