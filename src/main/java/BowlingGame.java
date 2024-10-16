public class BowlingGame{

    private int score;
    private int frame;
    private int count;
    private int[][] board;

    public BowlingGame(){
        this.score = 0;
        this.frame = 0;
        this.count = 0;
        this.board = new int[10][3];
    }

    public void roll(int pin){
        if (pin < 0 || pin > 10) {
            throw new IllegalArgumentException("pin must be between 0 and 10");
        }
        if (frame == 9) {
            board[frame][count % 3] = pin;
            count++;
        } else {
            board[frame][count % 2] = pin;
            if (pin == 10 && count == 0) {
                frame++;
            } else {
                count++;
                if (count == 2) {
                    count = 0;
                    frame++;
                }
            }
        }
    }

    public int score() {
        for (int i = 0; i < 10; i++) {
            int sum = board[i][0] + board[i][1] + board[i][2];
            if (i != 9 && (sum < 0 || sum > 10)) {
                throw new IllegalArgumentException("sum must be between 0 and 10");
            }
            score += sum;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][0] == 10 && board[i + 1][0] == 10 && i < 8) {
                score += (10 + board[i + 2][0]);
            }
            else if (board[i][0] == 10) {
                score += (board[i + 1][0] + board[i + 1][1]);
            }
            else if (board[i][0] + board[i][1] == 10) {
                score += board[i + 1][0];
            }
        }
        return score;
    }
}

