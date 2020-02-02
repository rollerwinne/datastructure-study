package cn.edu.bupt;

public class TestInteger {
	public static void main(String[] args) {
		Integer a = new Integer(5);
		Integer b = new Integer(5);
		
		Integer c = 5;
		Integer d = 5;
		
		Integer e = 128;
		Integer f = 128;
		
		int g = 128;
		
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(f == g);
	}
}
