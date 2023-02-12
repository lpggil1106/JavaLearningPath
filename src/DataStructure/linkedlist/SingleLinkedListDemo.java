package DataStructure.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及時雨");
        HeroNode hero2 = new HeroNode(2,"盧俊逸","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吳用","智多星");
        HeroNode hero4 = new HeroNode(4,"林沖","豹子頭");

        //創建鍊表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);

        singleLinkedList.list();
//        System.out.println("");
//        HeroNode newHeroNode = new HeroNode(2, "小盧", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//
//        singleLinkedList.list();
//        System.out.println("");
//
//        singleLinkedList.del(2);
//        singleLinkedList.list();
        singleLinkedList.search("宋江");
    }
}
// TODO 定義SingleLinkedList 管理我們的英雄
class SingleLinkedList{
    // 先初始化頭節點
    private HeroNode head = new HeroNode(0,"","");
    // 添加節點到單向鏈表
    // 思路，當不考慮編號順序時
    // 1. 找到當前鍊表最後節點
    // 2. 將這個最後節點的next 指向新的節點
    public void add(HeroNode heroNode){
        //因為head節點不能動，因此我們需要一個輔助遍歷 temp
        HeroNode temp = head;
        //遍歷鍊表，找到最後
        while(true){
            if(temp.next == null){
                break;
            }
            //如果沒有找到最後，將temp後移
            temp = temp.next;
        }
        //當退出while循環時，temp就指向了鍊表的最後
        //將最後這個節點的next 指向新的節點
        temp.next = heroNode;
    }

    //修改節點信息，根據no編號來修改
    //說明
    //1.根據newHeroNode的node來修改即可
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false; //flag標誌添加的編號是否存在 莫認為false
        while(true){
            if(temp.next == null){//temp已經走到鍊表的結尾
                break;
            }
            if(temp.next.no > heroNode.no){//找到位置!
                break;
            } else if (temp.next.no == heroNode.no){//新英雄的編號已存在
                flag = true; //
                break;
            }
            //假設以上三點都沒出事 將目標後移
            temp = temp.next;
        }

        if(flag){
            System.out.printf("準備插入的英雄編號 %d 已經存在", heroNode.no);
        }else {
            //插入到鍊表中 temp當前位置的後面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("鍊表為空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//已經到鍊表的尾端
            }
            if(temp.no == newHeroNode.no){
                //找到目標
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.printf("沒有找到 編號 %d 的節點，不能修改\n", newHeroNode);
        }
    }

    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){//已經到鍊表的最後
                break;
            }
            if(temp.next.no == no){//找到目標待刪除的節點
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要刪除的 %d 節點不存在", no);
        }
    }

    public void list(){
        if(head.next == null){
            System.out.println("鍊表為空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            //temp後移
            temp = temp.next;
        }
    }

    public void search(String name){
        if(head.next == null){
            System.out.println("列表為空");
        }
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.name == name){//找到目標
                flag = true;
                temp = temp.next;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("目標英雄詳細資訊如下");
            System.out.println(temp);
        }else{
            System.out.println("目標英雄不存在");
        }
    }
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
                '}';
    }
}
