package dataStructs.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] arr = {7,2,4};
        maxSlidingWindow(arr,2);
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<k || k<1){
            return null;
        }
        //#1
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i<nums.length; i++){

            //#2
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(i);

            //#3
            if(queue.peekFirst()<=(i-k)){//如果被窗口抛下了（在窗口左边界的左侧）
                queue.pollFirst();
            }
            if(i>=k-1){
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }


}
