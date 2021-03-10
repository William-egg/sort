import demo.data;

public class select {
    public void swap(int[] demo,int i,int j){
        demo[i] = demo[i]+demo[j];
        demo[j] = demo[i]-demo[j];
        demo[i] = demo[i]-demo[j];
    }
    public int[] selectDemo(){
        int[] demo = data.DATAS;

        for(int i = 0;i<demo.length;i++){
            int min = i;
            for(int j=i+1;j<demo.length;j++){
                if(demo[min]>demo[j]) min = j;
            }
            if(min!=i) swap(demo, min, i);
        }

        return demo;
    }

    public static void main(String[] args) {
        /*
        * 选择排序的时间复杂度喝空间复杂度其实和冒泡是一样一样的.....
        *
        * */
        for (int i:new select().selectDemo()) {
            System.out.print(i+"  ");
        }
    }
}
