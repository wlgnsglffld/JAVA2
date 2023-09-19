package chap13;

public class ExText1 {
	public static void parse(String str) {
		float f = 0;
		try {
			f = Float.parseFloat(str);
		}catch (NumberFormatException nfe) {
			
		}finally {
			System.out.println(f);
		}
	}
	public static void main(String[] args) {
		parse("korea");
	}

}
