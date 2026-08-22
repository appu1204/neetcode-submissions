class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            set.clear();

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        for (int col = 0; col < 9; col++) {
            set.clear();

            for (int row = 0; row < 9; row++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {

                if (!isValidBox(board, startRow, startCol)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidBox(char[][] board, int startRow, int startCol) {

        HashSet<Character> set = new HashSet<>();

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        return true;
    }
}