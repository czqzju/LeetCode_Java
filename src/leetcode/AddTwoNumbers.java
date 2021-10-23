package leetcode;

import java.time.temporal.ValueRange;

// https://leetcode.com/problems/add-two-numbers/submissions/

public class AddTwoNumbers {
//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode head = null, curNode =null;
	    	boolean addOne = false;
	    	int curVal;
	    	while (!(l1 == null && l2 == null)) {
	    		curVal = addOne? 1 : 0;
	    		
	    		if (l1 != null) {
	    			curVal += l1.val;
	    			l1 = l1.next;
	    		}
	    		
	    		if (l2 != null) {
	    			curVal += l2.val;
	    			l2 = l2.next;
	    		}
	    		
	    		if (curVal >= 10) {
	    			curVal -= 10;
	    			addOne = true;
	    		}
	    		else addOne = false;
	    		
	    		if (head == null) {
	    			head = new ListNode( curVal, null);
	    			curNode = head;
	    		}
	    		else {
	    			curNode.next = new ListNode(curVal, null);
	    			curNode = curNode.next;
	    		}
	    	}
	    	
	    	if (addOne) {
	    		curNode.next = new ListNode(1, null);
	    	}
	    	
	    	return head;
	    }
	}
}
