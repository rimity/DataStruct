package chapter_3.InfixtoPostfix;

import java.util.Scanner;

public class InfixtoPostfix_Test {
	public static void main(String[] args){
		System.out.print("type in equation");
		Scanner sc = new Scanner(System.in);
		String In = sc.next();
		sc.close();
		//In.toCharArray();
		int len = In.length();
		String[] InArray = new String[len];
		char[] cIn = In.toCharArray();
		for(int i=0; i<len; i++){
			InArray[i] = String.valueOf(cIn[i]);
		}
		
		InfixtoPostfix equation = new InfixtoPostfix(InArray);
		equation.transform();
		System.out.println(equation.getPostfix().toString());
	}	
}
