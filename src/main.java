import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {

    public static void main(String[] args) throws IOException {
        boolean isStarting = true;
        Player playerx = new Player();
        Player playero = new Player();


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

        boolean isExit = false;

        while (isExit == false) {
            map m = new map();

            if (isStarting) {


                System.out.println("Hello, please enter number 1 or 2 to decide if you want to play the first or the second :)");

                s = stdin.readLine();

                while (s == null || s.length() == 0 || (!s.equals("1") && !s.equals("2"))) {
                    System.out.println("Input have to be valid");
                    s = stdin.readLine();
                }

                int sint = s.equals("1") ? 1 : 2;
                playerx = new Player(sint, 'x');
                playero = new Player(3 - sint, 'o');

                isStarting = false;

            }
            while (!isStarting) {

                Player player = playerx.isTurn == true ? playerx : playero;
                String p = player.name;
                char f = player.getP_f();
                System.out.println("Player" + p.charAt(6) + "...Please place row;colon or enter g for giving up");
                s = stdin.readLine();
                if (s.equals("i")) {
                    System.out.println("Please place row;colo\n Enter g for giving up \n" +
                            "; make sure the row_index is in {1,2,3}; the col_index is in {1,2,3}; you can only place an" + f + "in your turn \n" +
                            " Enter r to restart; \n" +
                            " Enter e to exit");
                    s = stdin.readLine();

                }
                if (s.equals("r")) {
                    isStarting = true;
                    break;
                } else if (s.equals("e")) {
                    System.out.println("Exit.");
                    isExit = true;
                    break;
                }

                //the placement logic
                while (s == null || s.length() == 0) {
                    System.out.println("Input can't be null");
                    s = stdin.readLine();
                }

                try {
                    String param[] = s.split(";");
                    if (param.length != 2) {
                        throw new Exception();
                    }

                    int row = Integer.parseInt(param[0]);
                    int col = Integer.parseInt(param[1]);

                    if (m.isOccupied(row, col)) {
                        throw new Exception();
                    }

                    player.setP_r(row);
                    player.setP_c(col);

                    m.upDateTable(player);
                    m.printTable();

                    playerx.isTurn ^= true;
                    playero.isTurn ^= true;

                    if (m.getDraw()) {
                        System.out.println("TIE!");
                        isStarting = true;
                        break;
                    } else if (player.isWin()) {
                        System.out.println("Congrats! "+p+"wins!");
                        isStarting = true;
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("please make sure the row_index is in {1,2,3}; " +
                            "the col_index is in {1,2,3}; you can only place an '" + f + "' in your turn \n You are not allowed to overwrite an occupied one\nIf you want to give up, please enter g; " +
                            "if you want to restart, please enter r; if you want to exit, " +
                            "please enter e");
                }

            }

        }

    }

}

