import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {
        boolean player1=true;
        boolean draw=false;
        boolean p1win=false;
        boolean p2win=false;
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
                if(draw){
                    System.out.println("TIE!");
                    m.printTable();
                    break;
                }else if(p1win){
                    System.out.println("Congrats! P1 win!" );
                    m.printTable();
                    break;
                }else if(p2win){
                    System.out.println("congrats! P2 win!");
                    m.printTable();
                    break;
                }
                else if(player1 && (s = stdin.readLine()) != null && s.length() != 0){

                    System.out.println("Player1...Please place x or enter g for giving up");
//                    System.out.println(s);
                    m.printTable();

                }else if(!player1 && (s = stdin.readLine()) != null && s.length() != 0){
                    System.out.println("Player1...Please place x or enter g for giving up");
//                    System.out.println(s);
                    m.printTable();
                }

            }

        }

}

