package DataStructure.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}
// TODO 定義SingleLinkedList 管理我們的英雄
class SingleLinkedList{
    // 先初始化頭節點
    private HeroNode head = new HeroNode(0,"","");
    // 添加節點到單向鏈表

    public
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下個節點

    //構造器
    public HeroNode(int no, String name, String nickname){
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
                ", next=" + next +
                '}';
    }
}
