package SeleniumPackage;

import java.util.Arrays;

public class StringPrograms {

	public static void main(String[] args) {
		sortStringChars("anokarao");

	}
	
	public static void reverseAString(String str) {
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1;i>=0;i--) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb);
	}
	
	public static void sortStringChars(String str) {
		StringBuilder sb=new StringBuilder();
		
		char[] ch=str.toCharArray();
		//Arrays.sort(ch);
		for(int i=0;i<ch.length-1;i++) {
			for(int j=i+1;j<ch.length;j++) {
			if(ch[i]<ch[j]) {
				char temp=ch[i];
				ch[i]=ch[j];
				ch[j]=temp;
			}
			}
		}
		//for(char newch:ch) {
		sb.append(ch);
		//}
		System.out.println(sb);
	}

}
