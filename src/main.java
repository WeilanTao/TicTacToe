import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {
        boolean player1=true;

        map m = new map();

            /**
             * // How to read from standard input.
             * System.err is likewise a PrintStream,
             * but System.in is a raw InputStream with
             * no wrapping. This means that although you
             * can use System.out and System.err right
             * away, System.in must be wrapped before you
             * can read from it.
             */
            BufferedReader stdin = new BufferedReader(
                    new InputStreamReader(System.in));
            String s;

            while (true) {

                int p=player1? 1:2;
                char f=player1? 'x':'o';
                System.out.println("Player"+p+"...Please place row;colon;"+f+" or enter g for giving up");
                s = stdin.readLine();
                if()

                while (s == null || s.length() == 0){
                    System.out.println("Input can't be null");
                    s = stdin.readLine();
                }

                try{
                    String param[]= s.split(";");
//                  System.out.println(param[0].getClass().getSimpleName());
                    if(param.length!=3 || param[2].length()!=1){
                        throw new Exception();
                    }
                    m.upDateTable(Integer.parseInt(param[0]), Integer.parseInt(param[1]), param[2].charAt(0));
                    m.printTable();
                    player1= !player1;

                    if (m.getDraw()) {
                        System.out.println("TIE!");
                        m.printTable();
                        break;
                    } else if (m.getP1win()) {
                        System.out.println("Congrats! P1 win!");
                        m.printTable();
                        break;
                    } else if (m.getP2win()) {
                        System.out.println("congrats! P2 win!");
                        m.printTable();
                        break;
                    }


                }catch(Exception e){
                    System.out.println("please make sure the row_index is in {1,2,3}; " +
                            "the col_index is in {1,2,3}; you can only place an '"+
                            f+"' in your turn \n If you want to give up, please enter g; " +
                            "if you want to restart, please enter r; if you want to exit, " +
                            "please enter e");
                }



            }

        }

}

