package groot.shiro.demo;

import java.math.BigInteger;

/**
 * @Desc Definition for singly-linked list.
 * @Author GuoBen~
 * @Date 2021/8/13
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode temp = next;
        System.out.print(val);
        while (next != null) {
            System.out.print(next.val);
            next = next.next;
        }
        next = temp;
        System.out.println();
    }


}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return transformNumber(transformNode(l1).add(transformNode(l2)));
    }

    public BigInteger transformNode(ListNode node) {
        String number = node.val + "";
        while ((node = node.next) != null) {
            number += node.val;
        }
        return new BigInteger(reversal(number));
    }

    public String reversal(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[str.length()];
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            newChars[j] = chars[i];
        }
        return new String(newChars);
    }

    /*public BigInteger transformNode(ListNode node) {
        BigInteger lastPow = BigInteger.TEN;
        BigInteger number = BigInteger.valueOf(node.val);
        while ((node = node.next) != null) {
            number = number.add(BigInteger.valueOf(node.val).multiply(lastPow));
            lastPow = lastPow.multiply(BigInteger.TEN);
        }
        return number;
    }*/

    public ListNode transformNumber(BigInteger number) {
        String strNumber = number.toString();
        char[] chars = strNumber.toCharArray();
        ListNode result = new ListNode(chars[chars.length - 1]);
        ListNode next = null;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (next == null) {
                result.next = next = new ListNode(chars[i]);
            } else {
                next = next.next = new ListNode(chars[i]);
            }
        }
        return result;
    }

    /*public ListNode transformNumber(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) == 0) {
            return new ListNode(0);
        }
        int i = 1;
        BigInteger pow = BigInteger.ONE;
        BigInteger lastPow = pow;
        ListNode result = null;
        ListNode next = null;
        while (number.compareTo(BigInteger.ZERO) == 1 && i <= 100) {
            pow = pow.multiply(BigInteger.TEN);
            BigInteger val = number.mod(pow);
            number = number.subtract(val);
            if (result == null) {
                result = new ListNode(val.divide(lastPow).intValue());
            } else if (next == null) {
                next = new ListNode(val.divide(lastPow).intValue());
                result.next = next;
            } else {
                next = next.next = new ListNode(val.divide(lastPow).intValue());
            }
            lastPow = pow;
            i++;
        }
        return result;
    }*/

    public ListNode transformNumber(int[] nums) {
        int i = 0;
        ListNode result = (nums.length == 0) ? new ListNode(0) : null;
        ListNode next = null;
        while (i < nums.length) {
            ListNode current = new ListNode(nums[i++]);
            if (result == null) {
                result = current;
            } else if (next == null) {
                result.next = next = current;
            } else {
                next = next.next = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num1 = 564;
        int nums[] = {2, 4, 3};
        int nums2[] = {5, 6, 4};
        BigInteger n = BigInteger.valueOf(0);

        Solution solution = new Solution();
        ListNode node1 = solution.transformNumber(nums);
        ListNode node2 = solution.transformNumber(nums2);
        System.out.print("数1:");
        node1.print();
        System.out.print("数2:");
        node2.print();
        System.out.println("数:" + solution.transformNode(node1).toString());
        System.out.println("加");
        System.out.println("数:" + solution.transformNode(node2).toString());
        ListNode node3 = solution.addTwoNumbers(node1, node2);
        System.out.print("和:");
        node3.print();
        System.out.print("和还原:" + solution.transformNode(node3).toString());

    }


}

