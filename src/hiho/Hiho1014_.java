package hiho;

import hiho.BeatifulString.nodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Hiho1014_{
	
	public static class Node{
		char c;
		int times;
		Map<Character,Node> subNode;
		Node(){
			this.c = '\0';
			this.subNode = new HashMap<>();
			times = 0;
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int dicCount = in.nextInt();
		
		Node root = new Node();
		
		for(int i = 0; i < dicCount; i++){
			String str = in.next();
			addNode(root,str);
		}
		
		int m = in.nextInt();
		for(int i = 0; i < m;i++){
			System.out.println(getCount(in.next(),root));
		}
	}
	
	public static void addNode(Node root, String str){
		char[] c_str = str.toCharArray();
		Node start = root;
		int len = c_str.length;
		
		for (int i = 0; i < c_str.length; i++) {
			Node next = start.subNode.get(c_str[i]);
			start.times++;
			if(next == null){
				Node newNode = new Node();
//				if(i == len-1){
//					newNode.times++;
//				}
				newNode.c = c_str[i];
				start.subNode.put(c_str[i], newNode);
				next = newNode;
			}
			if(i == len-1){
				next.times++;
			}
			start = next;
		}
		return ;
	}
	
	public static int getCount(String text,Node root) {
		char[] c_str = text.toCharArray();
		int len = 0;
		Node start =  root;
		for (int i = 0; i < c_str.length; i++) {
			Node next = start.subNode.get(c_str[i]);
			if(next == null){
				return 0;
			}
			len = next.times;
			start = next;
		}
		return len;
	}
	
}
