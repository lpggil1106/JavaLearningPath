package DataStructure;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //測試
        //創建一個隊列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用戶輸入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):顯示隊列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加數據到隊列");
            System.out.println("g(get):取出隊列數據");
            System.out.println("h(head):查看隊列頭的數據");
            key = scanner.next().charAt(0);
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("輸入一個數:");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的數據是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("隊列頭的數據是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序結束");
    }
}
//使用數組模擬隊列-編寫一個ArrayQueue類
class ArrayQueue{
    private int maxSize;
    private int front;//隊列頭
    private int rear;//隊列尾
    private int[] arr;

    //創建隊列的構造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    public boolean isFull(){
        return (rear+1) % maxSize == front ;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    //添加數據到隊列
    public void addQueue(int n){
        //先判斷隊列是否滿了
        if(isFull()){
            System.out.println("隊列滿了 不能加入");
            return;
        }
        arr[rear] = n;
        rear = (rear+1) % maxSize;
    }

    //獲取隊列數據(出隊列)
    public int getQueue(){
        //判斷隊列是否維空
        if(isEmpty()){
            //通過輸出異常
            throw new RuntimeException("隊列空，不能取數據");
        }
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;

    }
    //顯示所有隊列元素
    public void showQueue(){
        if(isEmpty()){
            System.out.println("隊列空，沒有數據");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size(){
        return(rear +maxSize - front) % maxSize;
    }
    //顯示隊列頭部
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("隊列空，不能取數據");
        }
        return arr[front];
    }
}