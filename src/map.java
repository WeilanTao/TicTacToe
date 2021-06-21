import static java.lang.String.valueOf;

public class map {
    private static final char i=(char)32;
    private char line1[];
    private char line2[];
    private char line3[];
    public String table[];
    private String title="*TIC TAC TOE*";
    private String row=" --- --- ---";
    private static final int TABLE_SIZE=8;

    private class ParameterException extends Exception{

    }

    map(){
        line1=new char[]{ '|',i,i,i,'|',i,i,i,'|',i,i,i,'|'};
        line2=new char[]{ '|',i,i,i,'|',i,i,i,'|',i,i,i,'|'};
        line3=new char[]{ '|',i,i,i,'|',i,i,i,'|',i,i,i,'|'};
        table=new String[]{title, row, valueOf(line1), row, valueOf(line2),row,valueOf(line3),row};
        printTable();

    }

    public void printTable(){
        for(int i=0; i<TABLE_SIZE; i++){
            System.out.println(table[i]);
        }
    }

    public void upDateTable(int r, int c, char f) throws Exception{
//TODO Simpify the piece of logic ... string formater?
        if(r!=0 && r%2==0 && c%2==0 &&( f=='x'||f=='o')) {
            switch (r) {
                case 2: {
                    line1[c] = f;
                    table[r]=valueOf(line1);
                    break;
                }
                case 4: {
                    line2[c] = f;
                    table[r]=valueOf(line2);
                    break;
                }
                case 6: {
                    line3[c] = f;
                    table[r]=valueOf(line3);
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
