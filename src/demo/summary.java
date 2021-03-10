package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class summary {
    public int middleToRebolan(String s){
        Map<Character, Integer> priority = new HashMap<Character, Integer>();
        priority.put('(',0);
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        Stack<Character> inn = new Stack<Character>();
        StringBuffer sb = new StringBuffer(s);
//        StringBuffer result_sb = new StringBuffer("");
        ArrayList<Object> result_list = new ArrayList<Object>();
        int length = sb.length();
        char c;
        for(int i=0;i<sb.length();i++){
            int tempNum = 0;
            c = s.charAt(i);
            if(c >='0'&&c<='9'){
                while (i<sb.length()&&c >='0'&&c<='9'){
                    tempNum = tempNum*10+(c-'0');
                    i++;
                    if (i>=length) break;
                    c = s.charAt(i);
                }
//                result_sb.append(tempNum);
                result_list.add(tempNum);
                if (i==length) break;
            }
            if(c == '(') inn.push(c);
            else if(c == ')'){
                char cTemp = inn.pop();
                while(cTemp!='('){
//                    result_sb.append(cTemp);
                    result_list.add(cTemp);
                    cTemp = inn.pop();
                }
            }
            else if(inn.empty()||priority.get(inn.peek())<priority.get(c)) inn.push(c);
            else{
                while(!inn.empty()&&priority.get(inn.peek())>=priority.get(c)){
                    char t1 = inn.pop();
//                    result_sb.append(t1);
                    result_list.add(t1);
                }
                inn.push(c);
            }
        }
        while(!inn.empty()){
            char t1 = inn.pop();
//            result_sb.append(t1);
            result_list.add(t1);
        }
        return calculate(result_list);
//        return result_sb.toString();
    }
    public int calculate(ArrayList<Object> result_list){
        Stack<Integer> result = new Stack<Integer>();
        for (Object obj:result_list) {
            if(obj instanceof Integer) result.push((int)obj);
            else {
                int v1 = result.pop();
                int v2 = result.pop();
                char c = (char)obj;
                switch (c){
                    case '+': result.push(v1+v2); break;
                    case '-': result.push(v2-v1); break;
                    case '*': result.push(v1*v2); break;
                    case '/': result.push(v2/v1); break;
                }
            }
        }
        return  result.pop();
    }

    public static void main(String[] args) {
        System.out.println(new summary().middleToRebolan("1 + 1"));
    }
/*
 * 总结一下：
 *   1. 选择排序、插入排序、冒泡排序的时间复杂度都为O（n^2）,空间复杂度为O（1）
 *   2. 快排的最坏的时间为O(N^2)  最好的时间复杂度是O(nlogn)
 *   3. 堆排序最坏最好的时间复杂度都是O（nlogn），但是它比喻快排有一丢丢其他的缺点，表现在对cpu的访问，数据的交换次数上，（从这点来说，其实快起数据的交换次数可以说为0了。。）
 *   4. 希尔排序。。。学起来没啥必要，但是人家是第一批突破O(n^2)时间复杂度的算法。。。在1959年的最高水平...可惜快排在1960年就出来了。。。
 *
 * */
}
