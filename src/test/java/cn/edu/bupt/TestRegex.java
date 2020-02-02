package cn.edu.bupt;

import org.junit.Test;

public class TestRegex {
	public static void main(String[] args) {
		String regex = "^\\w+,[\\w\\-]+,[\\d:]+,admin,.*$";
		String str = "DEBUG,2019-09-09,12:25:26,admin,查询用户信息列表,ALL,成功,";
		System.out.println(str.matches(regex));
	}
	
	@Test
	public void fun1() {
		String regex = "^DEBUG,.*$";
		String str = "DEBUG,2019-09-16,16:07:15,admin,查看用户:2000091149的信息,2000091149,成功,{\"archive\":\"1\" | \"download\":\"1\" | \"id\":308 | \"open\":\"1\" | \"status\":\"success\" | \"upload\":\"1\" | \"userId\":\"2000091149\" | \"userType\":\"1\"}";
		System.out.println(str);
		System.out.println(str.matches(regex));
	}
	
	@Test
	public void fun2() {
		String regex = "        String regex = \"\";\n";
		String str = "87134 [qtp1418428263-61] DEBUG java.sql.PreparedStatement - ==> Parameters: 23(Integer)";
		System.out.println(str);
		System.out.println(str.matches(regex));
	}
}
