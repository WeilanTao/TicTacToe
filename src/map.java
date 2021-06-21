import com.sun.javafx.binding.StringFormatter;

import static java.lang.String.valueOf;

public class map {
    private static final char i=(char)9;
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
        line1=new char[]{ '|',i,'|',i,'|',i,'|'};
        line2=new char[]{ '|',i,'|',i,'|',i,'|'};
        line3=new char[]{ '|',i,'|',i,'|',i,'|'};
        table=new String[]{title, row, valueOf(line1), row, valueOf(line2),row,valueOf(line3),row};
        printTable();

    }

    public void printTable(){
        for(int i=0; i<TABLE_SIZE; i++){
            System.out.println(table[i]);
        }
    }

    public void upDateTable(int lineN, int index, char flag){
        if(lineN==0 || lineN%2!=0 || index%2==0 || flag!='x' ||flag!='o'){
//            throw Exception
        }else{


        }

    }
}
