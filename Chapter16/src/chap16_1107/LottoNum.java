package chap16_1107;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Lotto extends JFrame implements ActionListener{
	// 로또 번호 출력 될 라벨 생성.
	private JLabel lotto_num = new JLabel();
	
	//생성자.
	public Lotto() {
		JButton lotto = new JButton("로또 번호 자동생성");	//버튼
		
		Container ct = getContentPane();	//컨테이너
		ct.setLayout(new FlowLayout());		//레이아웃
		
		//컨테이너에 버튼과 라벨 추가
		ct.add(lotto);
		ct.add(lotto_num);
		
		//버튼에 리스너 추가
		lotto.addActionListener(this);
		
		//출력
		setTitle("Lotto Numver Generate");
		setSize(300, 250);
		setVisible(true);
		}

	// 버튼을 누르면 발생하는 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Random rnd_num = new Random();	//Random() 클래스로 객체 생성.
		int[] lotto_number = new int[6];
		
		// 같은 번호가 있는지 확인을 위해 변수 생성.
		int temp;
		
		int i = 0;
		
		a:while(i<6) {
			//	랜덤 번호 생성.
			temp = rnd_num.nextInt(45)+1;
			//	배열에 저장된 값과 temp에 저장된 값을 비교하여 같으면 다시 랜덤수 발생.
			for(int j =0; j <= i; j++) {
				if (temp == lotto_number[j])
					continue a;
			}
			lotto_number[i] = temp;	//temp 값 배열에 저장.
			i++;
		}
		//Attays.toString은 배열을 문자열 표현으로 변환하는데 사용하는 메서드.
		lotto_num.setText("이번주 로또 당첨 번호 : " + Arrays.toString(lotto_number));
		
	}
	
}

public class LottoNum {

	public static void main(String[] args) {
		new Lotto();

	}

}//책 632
