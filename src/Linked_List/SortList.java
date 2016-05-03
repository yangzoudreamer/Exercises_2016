package Linked_List;

import java.util.ArrayList;
import java.util.List;

//
//public class SortList {
//	public ListNode sortList(ListNode head) {
//        if(head == null || head.next == null)
//		    return head;
//		ListNode mid = getMidNode(head);
//		ListNode rList = mid.next;
//		mid.next = null;
//		//递归向下拆分链表成单个元素链表，再合并
//		return merge(sortList(head),sortList(rList));
//	}
//	
//	//两个链表遍历比较再合并过程
//	public ListNode merge(ListNode left, ListNode right) {
//		ListNode tmphead,tmpnode;
//		tmphead = tmpnode = new ListNode(0);
//		while(left!= null && right!= null) {
//			if (left.val < right.val) {
//				tmpnode.next = left;
//				left = left.next;
//			}
//			else {
//				tmpnode.next = right;
//				right = right.next;
//			}
//			//额外空间的指针也要跟着遍历向前滑动
//			tmpnode = tmpnode.next;
//		}
//		while (left != null) {
//			tmpnode.next = left;
//			left = left.next;
//			tmpnode = tmpnode.next;
//		}
//		while(right != null){
//			tmpnode.next = right;
//			right = right.next;
//			tmpnode = tmpnode.next;
//		}
//		return tmphead.next;
//	}
//	//二分链表
//	public ListNode getMidNode(ListNode head){
//		if(head == null)
//		    return head;
//		ListNode p1,p2;
//		p1 = head;
//		p2 = head;
//		while(p2.next != null&& p2.next.next != null){
//			p1 = p1.next;
//			p2 = p2.next.next;
//		}
//		
//		return p1;
//}
//	public static void main(String[] args) {
//		SortList sortList =  new SortList();
//		ListNode node1 = new ListNode(3);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(4);
//		node1.next = node2;
//		node2.next = node3;
//		
//		ListNode node = sortList.sortList(node1);
////		System.out.println(node.val);
//		
//		while(node!= null){
//			System.out.println(node.val);
//			node = node.next;
//		}
//		
//	}
//}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
	public static void main(String[] args) {
		SortList sortList =  new SortList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = null;

		ListNode node = new ListNode(-1);
//		node = sortList.rotateRight(node1);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
}