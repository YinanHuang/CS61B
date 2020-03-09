package Map61B;
import java.util.*;


class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        ListNode ans = sum;
        int temp;
        int flag = 0;
        while(l1 != null && l2 != null){
            temp = l1.val + l2.val + flag;
            if(temp >= 10){
                temp -= 10;
                sum.next = new ListNode(temp);
                flag = 1;
            } else{
                sum.next = new ListNode(temp);
                flag = 0;
            }
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode left = helper(l1, l2);
        if(left != null){
            while(left != null) {
                temp = left.val + flag;
                if(temp >= 10){
                    temp -= 10;
                    flag = 1;
                    sum.next = new ListNode(temp);
                } else {
                    sum.next = new ListNode(left.val + flag);
                    flag = 0;

                }
                sum = sum.next;
                left = left.next;
            }
        }
        if(flag == 1){
            sum.next = new ListNode(1);
        }
        return ans.next;
    }

    private static ListNode helper(ListNode l1, ListNode l2){
        if(l1 != null){
            return l1;
        } else{
            return l2;
        }
    }

    // an algorithm with time complexity O(N)
    private static int f1(int i, int[] numList){
        for(int j = 0;j<numList.length;j++){
            if(numList[j] == numList[i]){
                return j;
            }
        }
        return i;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        ListNode ans = addTwoNumbers(l1, l2);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}