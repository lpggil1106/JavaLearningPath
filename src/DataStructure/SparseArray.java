package DataStructure;

public class SparseArray{
        public static void main(String[] args) {
//              創建原始二為數組 11*11
//              0-沒有棋子 1-白子 2-黑子
                int chessArr1[][] = new int[11][11];
                chessArr1[1][2] = 1;
                chessArr1[2][3] = 2;
                chessArr1[4][5] = 2;
                //輸出原始二維數組
                System.out.println("原始二維數組為");
                for(int[]row : chessArr1){
                        for(int data: row){
                                //%d 置換後面的data
                                System.out.printf("%d\t",data);
                        }
                        System.out.println();
                }

                //將二維數組轉化為稀疏數組的思維
                //1.遍歷二維數組 得到非0數據的個數
                int sum = 0;
                for(int i=0; i< 11; i++){
                        for(int j = 0; j < 11; j++){
                                if(chessArr1[i][j] != 0){
                                        sum++;
                                }
                        }
                }

                //創建對應的稀疏數組
                int spareArray[][] = new int[sum+1][3];
                spareArray[0][0] = 11;
                spareArray[0][1] = 11;
                spareArray[0][2] = sum;

                //填入稀疏數組
                int count = 0;
                for(int i=0; i< 11; i++){
                        for(int j = 0; j < 11; j++){
                                if(chessArr1[i][j] != 0){
                                        count++;
                                        spareArray[count][0] = i;
                                        spareArray[count][1] = j;
                                        spareArray[count][2] = chessArr1[i][j];
                                }
                        }
                }

                System.out.println("轉變為稀疏數組後為");
                for(int[]row: spareArray){
                        for(int data: row){
                                System.out.printf("%d\t",data);
                        }
                        System.out.println();
                }

        }
}
