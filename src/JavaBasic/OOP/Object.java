package JavaBasic.OOP;

public class Object {
    public static void main(String[] args) {
        // TODO 面向對象
        //所謂的面相對象，其實就是分析問題時，以問題所涉及到的事或物為中心的分析方式
        //類和對象
        //類表示歸納和整理
        //對象就表示具體的事物
        // TODO class (類)
        /*
        基本語法結構

        class 類名 {
        特徵(屬性)
        功能(方法)
        }
        */
        // TODO 1. 先聲明類
        // TODO 2. 創建對象
        // TODO 3. 聲明屬性，所謂的屬性其實就是類裡的變量
        //變量類型 變量名稱 = 變量值
        //屬性類型 屬性名稱 = 屬性值
        // TODO 4. 聲明方法
        //          void 方法名(參數){功能代碼}
        // TODO 5. 執行方法
        //          對象.方法名()
        Cooking c = new Cooking();
        c.name = "紅燒排骨";
        c.food = "排骨";
        c.execute();
    }
    static class Cooking {
        // 特徵(屬性)
        String name;
        String type = "紅燒";
        String food;
        String relish = "佐料";
        // TODO 執行
        void execute(){
            System.out.println("準備食材:" + food );
            System.out.println("準備佐料:" + relish );
            System.out.println("開始烹飪" );
            System.out.println(name + "烹飪完成" );
        }
    }

}
