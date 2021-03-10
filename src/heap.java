import demo.data;

public class heap implements data {
    public void swap(int[] demo,int i,int j){
        //这个算法要注意一下，如果是同一个地址的不能这么干！！！！！
        demo[i] = demo[i]+demo[j];
        demo[j] = demo[i]-demo[j];
        demo[i] = demo[i]-demo[j];
    }
    public void heapFiy(int[] demo,int length,int i){
        if(i>=length) return;;
        int c1 = i*2+1;
        int c2 = i*2+2;
        int max = i;
        if(c1<length&&demo[c1]>demo[max]){
            max = c1;
        }
        if(c2<length&&demo[c2]>demo[max]){
            max = c2;
        }
        if(max!=i){
            swap(demo,max,i);
            heapFiy(demo, length, max);
        }
    }
    public int[] heap_sort(){
        int[] demo = data.DATAS;
        buildBigHeap(demo);
        for(int i=demo.length-1;i>0;i--){
            swap(demo, i, 0);
            heapFiy(demo, i, 0);
        }


        return demo;
    }
    public void buildBigHeap(int[] demo){
        for(int i=(demo.length-1)/2;i>=0;i--){
            heapFiy(demo, demo.length,i);
        }
    }
    public static void main(String[] args) {
//        int[] demo = data.DATAS;
//        heap heap = new heap();
//        for(int i=(demo.length-1)/2;i>=0;i--){
//            heap.heapFiy(demo, demo.length,i);
//        }
//        for (int i:demo) {
//            System.out.print(i+"  ");
//        }

        /*
        * 时间复杂度最坏最好都是O(nlogn)，这个算法跟快排的比较大概有以下俩点
        * 1. 对cpu的缓存不是很友好，因为他是跳着访问的，而快排就不一样了，不管从后面顺序，还是从前面顺序，至少是顺序访问的
        * 2. 相同数据量交换次数堆排序明显大于快排，这个也很好理解，因为堆排序第一步就是构建大顶堆，之后再不断交换堆顶元素和末尾元素
        *
        * */
        for (int i:new heap().heap_sort()) {
            System.out.print(i+"  ");
        }
    }
}
