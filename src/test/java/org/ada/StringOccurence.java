package org.ada;

public class StringOccurence {
	
	public static void main(String[] args) {
		String s ="meenatchi";
		int len = s.length();
		int len1 = s.replace("e", "").length();
		int result=len-len1;
		System.out.println("the count of e  = " +result);
		
	}

}
