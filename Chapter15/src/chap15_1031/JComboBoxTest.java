package chap15_1031;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JComboBox1 extends JFrame implements ItemListener{
	JLabel fruitLabel;
	public JComboBox1() { //생성자
		// 콤보 박스 객체 생성.
		JComboBox fruitCombo = new JComboBox();
		//이미지 표시 영역 객체 생성
		fruitLabel = new JLabel();
		
		//과일 배열 생성
		String fruitList[] = {"persimmom","apple","banana","cherry","pear",};
		
		//컨테이너 만들기, 레이아웃 지정.
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		//콤보박스에 과일 리스트 추가
		for(int i=0; i < fruitList.length; i++)
		{
			fruitCombo.addItem(fruitList[i]);
		}
		
		//컨테이너에 콤보박스 , 레이블 추가 
		ct.add(fruitCombo);
		ct.add(fruitLabel);
		
		//콤보박스에 이벤트 리스너 등록
		fruitCombo.addItemListener(this);
		
		//출력
		setTitle("JComboBox Test1");
		setSize(200,200);
		setVisible(true);
	}

	private void addItem(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String fruit = (String)e.getItem();	
		fruitLabel.setIcon(new ImageIcon("image/"+fruit+".jpg"));
	}
	
}


public class JComboBoxTest {

	public static void main(String[] args) {
		new JComboBox1();

	}

}
