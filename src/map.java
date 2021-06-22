import static java.lang.String.valueOf;

public class map {
    private static final char i = (char) 32;
    private static final String TITLE = "*TIC TAC TOE*";
    private static final String ROW = " --- --- ---";
    private static final int TABLE_SIZE = 9;
    private static final String LINE_0 = "  1   2   3  ";
    public String table[];
    private char line1[];
    private char line2[];
    private char line3[];
    private boolean draw;
    private boolean p1win;
    private boolean p2win;

    private int x;
    private int o;

    map() {
        line1 = new char[]{'|', i, i, i, '|', i, i, i, '|', i, i, i, '|', '1'};
        line2 = new char[]{'|', i, i, i, '|', i, i, i, '|', i, i, i, '|', '2'};
        line3 = new char[]{'|', i, i, i, '|', i, i, i, '|', i, i, i, '|', '3'};
        table = new String[]{TITLE, LINE_0, ROW, valueOf(line1), ROW, valueOf(line2), ROW, valueOf(line3), ROW};
        draw = false;
        p1win = false;
        p2win = false;
        x=0;
        o=0;
        printTable();

    }

    public boolean getDraw() {
        return draw;
    }

    public boolean getP1win() {
        return p1win;
    }

    public boolean getP2win() {
        return p2win;
    }

    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println(table[i]);
        }
    }

    public boolean isOccupied(int r, int c){
        boolean isOcp=table[r * 2 + 1].charAt(2 + 4 * (c - 1)) != i ? true: false;
        System.out.println("ISOCCUP---"+isOcp);
        return isOcp;
    }

    public void upDateTable(int r, int c, char f) throws Exception {
//TODO Simpify the piece of logic ... string formater/string builder? setDraw; setP1WIN; setP2WIN; separate play1 and player 2
        if (r>=1 && r<=3 && c>=1 && c<=3 && (f=='x' || f=='y')) {
            int col =2 + 4 * (c - 1);
            int row =r * 2 + 1;
            switch (r) {
                case 1: {
                    line1[col] = f;
                    table[row] = valueOf(line1);
                    break;
                }
                case 2: {
                    line2[col] = f;
                    table[row] = valueOf(line2);
                    break;
                }
                case 3: {
                    line3[col] = f;
                    table[row] = valueOf(line3);
                    break;
                }
                default:
                    break;
            }
            x='x'==f? x+1:x;
            o='o'==f? o+1:o;
            if(x+o!=9){
                String line =table[r * 2 + 1];
                if((line.charAt(2)==line.charAt(6) && line.charAt(2)==line.charAt(10))
                        || (line1[col] == line2[col] && line1[col] == line3[col])){
                    p1win = f == 'x' ? true : false;
                    p2win = f == 'o' ? true : false;
                }
                if ((r + c) == 4 || r==c) {
                    if ((line1[2] == line2[6] && line1[2] == line3[10] && line1[2] != i)
                            || (line1[10] == line2[6] && line1[10] == line3[2] &&line1[10] !=i )) {
                        p1win = f == 'x' ? true : false;
                        p2win = f == 'o' ? true : false;
                    }
                }
            }
            else{
                draw=true;
                p1win=false;
                p2win=false;
            }



        } else {
            throw new Exception();
        }
    }
}
