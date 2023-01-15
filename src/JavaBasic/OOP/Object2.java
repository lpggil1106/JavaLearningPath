package JavaBasic.OOP;

public class Object2 {
    public static void main(String[] args) {
        //TODO 面向對象

        //類
        //對象: 狗 貓
        Animal a1 = new Animal();
        a1.type = "狗";
        a1.name = "Heimer";
        Animal a2 = new Animal();
        a2.type = "貓";
        a2.name = "Willy";

        a1.run();
        a2.run();
    }
}

class Animal{
    String type;
    String name;

    void run(){
        System.out.println(type + " " + name +"跑走拉");
    }
}
