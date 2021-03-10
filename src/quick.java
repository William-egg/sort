import demo.data;

import java.util.Date;

public class quick implements data {

    public void quickDemo(int[] demo,int i,int j){
        if(i<j){
            int x = demo[i];
            int begin = i,end=j;
            while(i<j){
                while(i<j&&demo[j]>=x) j--;
                if(i<j) demo[i] = demo[j];
                while(i<j&&demo[i]<=x) i++;
                if(i<j) demo[j] = demo[i];
            }
            demo[i] = x;
            quickDemo(demo, i+1, end);
            quickDemo(demo, begin, i-1);
        }
    }

    public static void main(String[] args) {
        /*
        * 这是一种分治法的排序算法，也叫做快速排序，他的时间复杂度为O(nlogn),是很优秀的排序算法了，绝大多数的排序算法都是用的它
        * 是1960年提出的，他的思想是选取一个基数，把数组中所有小于这个基数的数放在它左边，大于他的放在左边，然后不断的递归左右，直到
        * 只剩下一个数就结束递归
        * */
        int[] demo = DATAS;
        new quick().quickDemo(demo,0,demo.length-1);
        for (int i:demo) {
            System.out.print(i+"  ");
        }
    }
}
