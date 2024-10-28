package TicTacToeGameProject;
import java.util.*;

public class Main{
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> brr = new ArrayList<>();
    static void printBoard(char[][] chr){
        for(char[] row : chr){
            for(char ele : row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
    static String checkWinner(){
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);
        List<Integer> topCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> botCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(7,5,3);
        List<List<Integer>> winner = new ArrayList<>();
        winner.add(topRow);
        winner.add(midRow);
        winner.add(botRow);
        winner.add(topCol);
        winner.add(midCol);
        winner.add(botCol);
        winner.add(cross1);
        winner.add(cross2);
        for(List<Integer> ele : winner){
            if(arr.containsAll(ele)){
                return "Congratulations ! You Win!";
            }
            else if(brr.containsAll(ele)) return "cpu win! You Lose ";
            else if(arr.size()+brr.size()==9) return "It's A Tie Game!";
        }
        return "";
    }
    static void placePiece(char[][] ar, int pos, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'x';
            arr.add(pos);
        }
        else if(user.equals("cpu")) {
            symbol = 'O';
            brr.add(pos);
        }
        switch(pos){
            case 1 :ar[0][0] = symbol;
                break;
            case 2 :ar[0][2] = symbol;
                break;
            case 3 :ar[0][4] = symbol;
                break;
            case 4 :ar[1][0] = symbol;
                break;
            case 5 :ar[1][2] = symbol;
                break;
            case 6 :ar[1][4] = symbol;
                break;
            case 7 :ar[2][0] = symbol;
                break;
            case 8 :ar[2][2] = symbol;
                break;
            case 9 :ar[2][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Tic-Tac-Toe Game!");
        System.out.println("------- Game Started -------");
        char[][] ar = {{'-','|','-','|','-'},{'-','|','-','|','-'},{'-','|','-','|','-'}};
        printBoard(ar);
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Position Between 0 To 9 : ");
            int pos = sc.nextInt();
            while(arr.contains(pos) || brr.contains(pos)){
                System.out.println("Position Taken! Enter a different Position : ");
                pos = sc.nextInt();
            }
            placePiece(ar, pos, "player");
            String win =checkWinner();
            if(!win.isEmpty()){
                printBoard(ar);
                System.out.println(win);
                break;
            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(arr.contains(cpuPos) || brr.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(ar, cpuPos, "cpu");
            printBoard(ar);
            win =checkWinner();
            if(!win.isEmpty()){
                System.out.println(win);
                break;
            }
        }
    }
}