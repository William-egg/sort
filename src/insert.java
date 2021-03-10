import demo.data;

public class insert {

    public int[] insertDemo(){
        int[] demo = data.DATAS;
        for(int i = 1;i<demo.length;i++){
            int j = 0;
            while(demo[j]<demo[i]) j++;
            int temp = i;
            int value = demo[i];
            while(temp>j) {
                demo[temp] = demo[temp-1];
                temp--;
            }
            demo[temp] = value;
        }
        return demo;

    }
//    public int[] insertDemo2(){
//        int[] demo = data.DATAS;
//        for(int i = 0;i<demo.length-1;i++){
//            for(int j = i+1;j>0;j--){
//                if()
//            }
//        }
//        return demo;
//    }
    public static void main(String[] args) {
        /*
        * 插入排序的时间复杂度也是O(n^2)
        *
        *
        * */
        for (int i:new pubble().pubbleDemo()) {
            System.out.print(i+"  ");
        }
    }
}
