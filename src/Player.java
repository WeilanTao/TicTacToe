/**
 * @author Weilan Tao
 */

public class Player {
    public boolean isTurn;
    public String name;
    private int p_r = 0;
    private int p_c = 0;
    private char p_f;
    private boolean isWin;
    private boolean isGiveUp;

    public Player() {
    }

    public Player(int order, char flag) {

        isTurn = order == 1 ? true : false;
        p_f = flag;
        name = "player" + p_f;
        isWin = false;
        isGiveUp = false;
    }

    public boolean isGiveUp() {
        return isGiveUp;
    }

    public void setGiveUp(boolean giveUp) {
        isGiveUp = giveUp;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getP_r() {
        return p_r;
    }

    public void setP_r(int p_r) {
        this.p_r = p_r;
    }

    public int getP_c() {
        return p_c;
    }

    public void setP_c(int p_c) {
        this.p_c = p_c;
    }

    public char getP_f() {
        return p_f;
    }

}
