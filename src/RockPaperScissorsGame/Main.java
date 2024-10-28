package RockPaperScissorsGame;
import java.util.Scanner;

class players{
    Scanner sc = new Scanner(System.in);
    int str;
    public int type(){
        str = sc.nextInt();
        return str;
    }
}
class compare{
    players p1 = new players();
    players p2 = new players();
    int s1; int s2;
    void choice(){
        System.out.println("1 For Rock");
        System.out.println("2 For Paper");
        System.out.println("3 For Scissor");
        System.out.println("Please, Enter Your Choice Above Them");
    }
    void collectFromPlayer(){
        System.out.println("Enter Choice of 1st player : ");
        choice();
        s1 = p1.type();
        System.out.println("Enter Choice of 2nd player : ");
        choice();
        s2 = p2.type();
    }
    void rules()throws Error{
        if(s1>4 || s2>4) throw new Error("Wrong Number!!!");
        if(s1==1 && s2==3){
            System.out.print("1st player won This Game As Rock Beats scissor");
            return;
        }
        else if(s1==3 && s2==2){
            System.out.print("1st player won This Game As Scissor Beats Paper");
            return;
        }
        else if(s1==2 && s2==1){
            System.out.print("1st player won This Game As Paper Beats Rock");
            return;
        }
        else if(s2==1 && s1==3){
            System.out.print("2nd player won This Game As Rock Beats scissor");
            return;
        }
        else if(s2==3 && s1==2){
            System.out.print("2nd player won This Game As Scissor Beats Paper");
            return;
        }
        else if(s2==2 && s1==1){
            System.out.print("2nd player won This Game As Paper Beats Rock");
            return;
        }
        if(s1==1 && s2==1){
            System.out.print("No one won this game");
            return;
        }
        else if(s1==2 && s2==2){
            System.out.print("No one won this game");
            return;
        }
        else if(s1==3 && s2==3){
            System.out.print("No one won this game");
            return;
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello User, Welcome to my Rock Paper Scissor Game");
        System.out.println("------- Game Started -------");
        System.out.println("Please, How many times do you want to try : ");
        int num = sc.nextInt();
        while(num-->0){
            compare cp = new compare();
            cp.collectFromPlayer();
            cp.rules();
            System.out.println("\n");
        }
        System.out.println("------- Game Over -------");
    }
}
