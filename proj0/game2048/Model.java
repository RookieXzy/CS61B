package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }
    /*
    写一个tilt 方法
    这个方法的实现效果是:
    1.在这个棋盘内有东西南北四个方向 我们不需要考虑块在上下左右是如何移动的 我们可以调整游戏视角
    当游戏视角为西 West的时候 按向上键 其实是相当于按左键
    2.有一个记分的变量 记录所有块的总值
    3.有一个局部的changed 变量 如果板子上的内容有变化了 就得改变changed的值
     */

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */

    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.

        // 設定 view perspective，以處理各個方向
        board.setViewingPerspective(side);

        // 針對每一 column 做處理
        for (int c = 0 ; c < board.size() ; c++) {
            if(handleTileSingleColumn(c)) changed = true;
        }

        // 將 board 轉回 North side


        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /**
     Tile helper function: c is column.
     Returns true if changed.
     */
    private boolean handleTileSingleColumn(int c) {
        boolean changed;
        changed = false;

        boolean [][] isMergedTable = new boolean[4][4];

        for (int r = 2; r >= 0; r--){
            if(board.tile(c, r) != null) {
                Tile t = board.tile(c, r);

                boolean isMerged = false;


                // Record the row where tile merges
                int changedRow = 0;

                // 1. move up if the space above it is empty
                // 2. or it can move up one if the space above it has the same value as itself
                // check whether the tile has been merged this round
                if(!isMergedTable[3][c] && ((r < 3 && board.tile(c, 3) == null) || hasSameValue(t, board.tile(c, 3)) && noTilesAbove(3, r, c))) {
                    isMerged = board.move(c, 3, t);
                    changedRow = 3;
                    changed = true;
                } else if (!isMergedTable[2][c] && ((r < 2 && board.tile(c, 2) == null) || hasSameValue(t, board.tile(c, 2)) && noTilesAbove(2, r, c))){
                    isMerged = board.move(c, 2, t);
                    changedRow = 2;
                    changed = true;
                } else if (!isMergedTable[1][c] && ((r < 1 && board.tile(c, 1) == null) || hasSameValue(t, board.tile(c, 1)) && noTilesAbove(1, r, c))) {
                    isMerged = board.move(c, 1, t);
                    changedRow = 1;
                    changed = true;
                }

                // Handle score
                if (isMerged) {
                    // This move is merged, score increases.
                    score += board.tile(c, changedRow).value();

                    // update isMergedTable
                    isMergedTable[changedRow][c] = true;
                } else {
                    // This move is not merged, score has no change.
                    score += 0;
                }

            }
        }

        return changed;
    }

    /**
     *  Helper function: check whether two tiles has same value
     */
    public boolean hasSameValue(Tile t1, Tile t2){
        return t1.value() == t2.value();
    }

    /**
     *  Helper function: check no tiles above
     */
    public boolean noTilesAbove(int upperRow, int lowerRow,int col){
        for (int curRow = upperRow - 1; curRow > lowerRow; curRow--){
            if (board.tile(col, curRow) != null){
                return false;
            }
        }

        return true;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
        /*
        在board类中获取棋盘的大小,之后在棋盘的每一列 行 遍历
        .tile方法提供了当前块的值 如果是空的 则返回 null
         */
        int size = b.size();

        for (int c = 0; c < size ; c++){
            for (int r = 0; r < size; r++){
                if (b.tile(c, r) == null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO: Fill in this function.
        int size = b.size();
        //b.tile 返回一个 Tile类型的变量 显示在当前坐标下 块的坐标 值
        //Tile.value() 返回这个块的值
        for (int c = 0; c < size ; c++){
            for (int r = 0; r < size; r++){
                Tile t = b.tile(c, r);
                if (b.tile(c, r) != null && t.value() == MAX_PIECE){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
        int size = b.size();

        //当棋盘上至少有一个空位
        if (Model.emptySpaceExists(b)){
            return true;
        }
        //当棋盘任何一个块的周围都没有相同的值
        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                Tile t = b.tile(c, r);
                int value = t.value();

                // 对 上 下 左 右 四个方向进行检查
                // 如果不在第一行 检查上方的格子
                if (r < size - 1 && value == b.tile(c, r + 1).value()) {
                    return true;
                }
                // 如果不在最后一行 就检查下方的格子
                if (r > 0 && value == b.tile(c, r - 1).value()) {
                    return true;
                }
                //如果不在最左边的一行 就检查左侧的格子
                if (c > 0 && value == b.tile(c - 1, r).value()) {
                    return true;
                }
                //如果不在最右边的一行 就检查右侧的格子
                if (c < size - 1 && value == b.tile(c + 1, r).value()) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
