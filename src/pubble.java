import demo.data;

public class pubble implements data {
    public void swap(int[] demo,int i,int j){
        demo[i] = demo[i]+demo[j];
        demo[j] = demo[i]-demo[j];
        demo[i] = demo[i]-demo[j];
    }
    public int[] pubbleDemo(){
        int[] demo = DATAS;
        for(int i = demo.length-1;i>=1;i--){
            for(int j=0;j<i;j++){
                if (demo[j]>demo[j+1]){
                    swap(demo,i,j);
                }
            }
        }
    return  demo;
    }

    public static void main(String[] args) {
        /*
        * 冒泡的时间复杂度是O(n*n/2) == O(n^2)
        * 空间复杂度为 O(1)，除了遍历的指针不需要占用额外的空间
        *
        * */
        for (int i:new pubble().pubbleDemo()) {
            System.out.print(i+"  ");
        }
    }
}
