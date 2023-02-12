package DataStructure;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }

    //遍歷
    public void list(){
        if(head.next == null){
            System.out.println("練表為空，沒有數據");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下個節點 莫認為null
    public HeroNode2 pre;  //指向下個節點 莫認為null

    //構造器
    public HeroNode2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //為了顯示方法 在這裡覆寫toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}