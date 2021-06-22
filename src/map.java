import static java.lang.String.valueOf;

public class map {
    private static final char i=(char)32;
    private char line1[];
    private char line2[];
    private char line3[];
    public String table[];
    private static final String TITLE="*TIC TAC TOE*";
    private static final String ROW=" --- --- ---";
    private static final int TABLE_SIZE=9;
    private static final String LINE_0="  1   2   3  ";
    private boolean draw;
    private boolean p1win;
    private boolean p2win;


    map(){
        line1=new char[]{'|',i,i,i,'|',i,i,i,'|',i,i,i,'|','1'};
        line2=new char[]{'|',i,i,i,'|',i,i,i,'|',i,i,i,'|','2'};
        line3=new char[]{'|',i,i,i,'|',i,i,i,'|',i,i,i,'|','3'};
        table=new String[]{TITLE, LINE_0, ROW, valueOf(line1), ROW, valueOf(line2),ROW,valueOf(line3),ROW};
        draw=false;
        p1win=false;
        p2win=false;
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

    public void setDraw(boolean draw) {
        this.draw = draw;
    }


    public void setP1win(boolean p1win) {
        this.p1win = p1win;
    }

    public void setP2win(boolean p2win) {
        this.p2win = p2win;
    }

    public void printTable(){
        for(int i=0; i<TABLE_SIZE; i++){
            System.out.println(table[i]);
        }
    }

    public void upDateTable(int r, int c, char f) throws Exception{
//TODO Simpify the piece of logic ... string formater? and fix the inputs out of range;setDraw; setP1WIN; setP2WIN
        if(  ( f=='x'||f=='o')) {
            switch (r) {
                case 1: {
                    line1[2+4*(c-1)] = f;
                    table[3]=valueOf(line1);
                    break;
                }
                case 2: {
                    line2[2+4*(c-1)] = f;
                    table[5]=valueOf(line2);
                    break;
                }
                case 3: {
                    line3[2+4*(c-1)] = f;
                    table[7]=valueOf(line3);
                    break;
                }
                default:
                    break;
            }


        }else{
            throw new Exception();
        }
    }
}
