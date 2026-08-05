class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> grid = new HashMap<>(); 
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>(); 
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>(); 

        for(int i = 0; i < 9; ++i){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            grid.put(i, new HashSet<>());
        }

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char c = board[i][j];
                if(c == '.')
                    continue;

                int gridNumber = (i / 3) * 3 + (j / 3); 

                if(rows.get(i).contains(c) || 
                   cols.get(j).contains(c) || 
                   grid.get(gridNumber).contains(c)) {
                    return false; 
                }

                rows.get(i).add(c);
                cols.get(j).add(c);
                grid.get(gridNumber).add(c);
            }
        }

        return true;
    }
}
