package GuesserGameProject;
import java.util.*;

class Guesser{
    Random rand = new Random();
    int num;
    public int guesserNum(){
        num = rand.nextInt(10);
        return num;
    }
}
class Player{
    Scanner sc = new Scanner(System.in);
    int num;
    public int PlayerNum(){
        num = sc.nextInt();
        return  num;
    }
}
class Umpire{
    Guesser gs = new Guesser();
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();
    int player1; int player2; int player3; int guesserNum;
    public void collectFromGuesser(){
        guesserNum = gs.guesserNum();
    }
     public void collectFromPlayer(){
         System.out.println("Please, Player1 Guess Number : ");
         player1 = p1.PlayerNum();
         System.out.println("Please, Player2 Guess Number : ");
         player2 = p2.PlayerNum();
         System.out.println("Please, Player3 Guess Number : ");
         player3 = p3.PlayerNum();
     }
     public void compare(){
        if(guesserNum == player1 && guesserNum == player2 && guesserNum == player3){
            System.out.println("All players won this Guessing Game !!!");
            return;
        }
         if(guesserNum != player1 && guesserNum != player2 && guesserNum != player3){
             System.out.println("All players lost this Guessing Game !!!");
             if(guesserNum<=(player1+player2+player3)/3) System.out.println("Too high!!! Try again.");
             else System.out.println("Too low!!! Try again.");
             return;
         }
        if(guesserNum == player1 && guesserNum == player2){
            System.out.println("Player1 And Player2 won this guessing Game");
            return;
        }
         if(guesserNum == player1 && guesserNum == player3){
             System.out.println("Player1 And Player3 won this guessing Game");
             return;
         }
         if(guesserNum == player2 && guesserNum == player3){
             System.out.println("Player2 And Player3 won this guessing Game");
             return;
         }
         if(guesserNum == player1) System.out.println("Player1 won This Guessing Game");
         else if(guesserNum == player2) System.out.println("Player2 won This Guessing Game");
         else System.out.println("Player3 won This Guessing Game");
     }
}
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello User, Welcome to my Guesser Game");
        System.out.println("------- Game Started -------");
        System.out.println("Please, How many times do you want to try : ");
        int num = sc.nextInt();
        while(num-->0) {
            Umpire up = new Umpire();
            up.collectFromGuesser();
            up.collectFromPlayer();
            up.compare();
            System.out.println();
        }
        System.out.println("------- Game Over -------");
    }
}
