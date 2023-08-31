package com.my.programmers.lv2;

import java.util.Stack;

public class P131704 {

    public int solution(int[] order) {

        int[] boxes = new int[order.length];
        for(int i = 0 ; i < order.length ; i++){
            boxes[i] = i + 1;
        }

        Stack<Integer> stack = new Stack<>();

        int boxIndex = 0;
        int orderIndex = 0;
        while(orderIndex < order.length){

            if(stack.isEmpty()){
                stack.push((boxes[boxIndex++]));
            }

            if(stack.peek() == order[orderIndex]){
                stack.pop();
                orderIndex++;
            }else{
                if(boxIndex < boxes.length){
                    stack.push(boxes[boxIndex++]);
                }else{
                    break;
                }
            }

        }

        return orderIndex;
    }


}
