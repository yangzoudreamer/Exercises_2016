package hiho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class BeatifulString {
	
	public class nodes {
		public char c;
		public int times;
		public nodes next;
		
		public nodes(char c,int times) {
			// TODO Auto-generated constructor stub
			
			this.c = c;
			this.times = times;
			
		}
		
	}
	
	public boolean isBeatiful(String in) {
		boolean flag = false;
		LinkedList<nodes> list = new LinkedList<nodes>();
		int len = in.length();
		
		if (len < 3) {
			return false;
		}
		
//		System.out.println("初始list的大小： "+list.size());
		
		list.add(new nodes(in.charAt(0),1));
		
		for (int i = 1; i < len; i++) {
			if (in.charAt(i) == in.charAt(i-1)) {
				list.get(list.size()-1).times++;
			}
			else {
				list.add(new nodes(in.charAt(i), 1));
			}
		}
		
		if (list.size()<3) {
			return false;
		}
		
		for (int i = 1; i < list.size()-1; i++) {
			if ((list.get(i-1).times > list.get(i).times|| list.get(i-1).times == list.get(i).times) &&
					(list.get(i+1).times>list.get(i).times||list.get(i+1).times==list.get(i).times) && 
					
					(list.get(i).c - list.get(i-1).c == 1) && (list.get(i+1).c - list.get(i).c == 1)
					
					) {
				return true;
			}
		}
		
		
		
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner in = new Scanner(System.in);
		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int Count = Integer.valueOf(brBufferedReader.readLine());
		
		BeatifulString beatifulString = new BeatifulString();
		
		while(Count > 0){
			int len = Integer.valueOf(brBufferedReader.readLine());
			String testString = brBufferedReader.readLine();
			if (beatifulString.isBeatiful(testString)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			Count--;
		}
	
	}
	
/*
 * package hiho;

import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	
	public class nodes {
		public char c;
		public int times;
		public nodes next;
		
		public nodes(char c,int times) {
			// TODO Auto-generated constructor stub
			
			this.c = c;
			this.times = times;
			
		}
		
	}
	
	public boolean isBeatiful(String in) {
		boolean flag = false;
		LinkedList<nodes> list = new LinkedList<nodes>();
		int len = in.length();
		
		if (len < 3) {
			return false;
		}
		
//		System.out.println("初始list的大小： "+list.size());
		
		list.add(new nodes(in.charAt(0),1));
		
		for (int i = 1; i < len; i++) {
			if (in.charAt(i) == in.charAt(i-1)) {
				list.get(list.size()-1).times++;
			}
			else {
				list.add(new nodes(in.charAt(i), 1));
			}
		}
		
		if (list.size()<3) {
			return false;
		}
		
		for (int i = 1; i < list.size()-1; i++) {
			if ((list.get(i-1).times > list.get(i).times|| list.get(i-1).times == list.get(i).times) &&
					(list.get(i+1).times>list.get(i).times||list.get(i+1).times==list.get(i).times)&& 
					
					(list.get(i).c - list.get(i-1).c == 1) && (list.get(i+1).c - list.get(i).c == 1)) {
				return true;
			}
		}
		
		
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Count = Integer.valueOf(in.next());
		
		Main beatifulString = new Main();
		
		while(Count > 0){
			int len = Integer.valueOf(in.next());
			String testString = in.next();
			if (beatifulString.isBeatiful(testString)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			Count--;
		}
		in.close();
	}
	
}

*/
	
	
}
