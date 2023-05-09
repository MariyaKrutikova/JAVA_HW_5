public class Task4 {
    public static void main(String[] args) {
        int[] queens = new int[8];
        findQueenPosition(0, queens);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
                    System.out.print("X");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println();
        }
    }

    // Функция, расстоновки ферзей
    private static boolean findQueenPosition(int row, int[] queens) {
        if (row == 8) { 
            return true;
        }
        for (int col = 0; col < 8; col++) {
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                if (queens[i] == col || queens[i] == col - row + i || queens[i] == col + row - i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                queens[row] = col; 
                if (findQueenPosition(row + 1, queens)) { 
                    return true;
                }
            }
        }
        return false;
    }
}
    

