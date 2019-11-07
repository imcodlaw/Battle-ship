import java.lang.reflect.Array;
import java.sql.SQLOutput;
// "1" = player's ships di map "@"
// "2" = computer's ships di map ga keliatan
// "3" = nothing di map "."
// "4" = kapal komputer yang ketebak di map "O"
// "5" = player bunuh diri "X"
// "6" = komputer nebak kapal player "!"
// 0878 7543 0868
import java.util.*;
public class MainBattleShip {
    //static String [][] oceanMap = new String [12][14];
    static String [][] oceanMap = new String [10][10];
    static int playerShip = 5;
    static int computerShip = 5;
    public static void main(String [] args){
        System.out.println("*** Welcome to Battle Ship Game ***");
        System.out.println("Right now, the sea is empty");
        System.out.println();
        printMap4();
        //playerInput2();
        playerInput3();
        computerInput3();
        //computerInput2();
        //gamePlay();
        while(playerShip > 0 || computerShip > 0){
            if(playerShip == 0){
                System.out.println("GAME OVER!");
                System.out.println("Computer wins! ");
                break;
            }
            else if(computerShip == 0){
                System.out.println("Game over!");
                System.out.println("You win it! :)");
                break;
            }
            playerTurn4();
            computerTurn3();
        }
    }
    public static void map1(){
        System.out.println("*** Welcome to Battle Ship game ***");
        System.out.println("Right now, the sea is empty.");
        for(int i = 0; i < 12; i ++){
            if(i == 0 || i == 11){
                System.out.println("  0123456789  ");
            }
            else{
                System.out.println((i-1) + "|          |" + (i-1));
            }
        }
    }
    public static void printMap(){
        for(int i = 0; i < 12; i++) {
            if(i == 0 || i == 11){
                for(int j = 0; j < 2; j++){
                    oceanMap[i][j] = " ";
                    System.out.print(oceanMap[i][j]);
                }
                for(int j = 2; j < 12; j++){
                    oceanMap[i][j] = j - 2 + "";
                    System.out.print(oceanMap[i][j]);
                }
                for(int j = 12; j < 14; j++){
                    oceanMap[i][j] = " ";
                    System.out.print(oceanMap[i][j]);
                }
            }
            else{
                for(int j = 0; j < 1; j ++){
                    oceanMap[i][j] = i-1 + "";
                    System.out.print(oceanMap[i][j]);
                }
                for(int j = 1; j < 2; j ++) {
                    oceanMap[i][j] = "|";
                    System.out.print(oceanMap[i][j]);
                }
                for(int j = 2; j < 12; j ++) {
                    if("1".equals(oceanMap[i][j])){
                        System.out.print("@");
                    }
                    else if("3".equals(oceanMap[i][j])){
                        System.out.print(".");
                    }
                    else if("4".equals(oceanMap[i][j])){
                        System.out.print("O");
                    }
                    else if("5".equals(oceanMap[i][j])){
                        System.out.print("X");
                    }
                    else if("6".equals(oceanMap[i][j])){
                        System.out.print("!");
                    }
                    /*else if("".equals(oceanMap[i][j])){
                        System.out.print("~");
                    }*/
                    else if(oceanMap[i][j] == null){
                        System.out.print(" ");
                    }
                    /*else{
                        System.out.println();
                    }*/
                    //System.out.print(oceanMap[i][j]);
                }
                for(int j = 12; j < 13; j ++){
                    oceanMap[i][j] = "|";
                    System.out.print(oceanMap[i][j]);
                }
                for(int j = 13; j < 14; j ++){
                    oceanMap[i][j] = i-1 + "";
                    System.out.print(oceanMap[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Player's ships = " + playerShip);
        System.out.println("Computer's ships = " + computerShip);
        System.out.println();
        System.out.println();
    }
    public static void printMap2(){
        for(int i = 0; i < 12; i ++){
            if(i == 0 || i == 11){
                for (int j = 0; j < 2; j++) {
                    System.out.print(" ");
                }
                for (int j = 2; j < 12; j++) {
                    System.out.print(j - 2);
                }
                for (int j = 12; j < 14; j++) {
                    System.out.print(" ");
                }
            }
            else{
            }
        }
    }
    public static void printMap4(){
        System.out.println("  0123456789  ");
        for(int i = 0; i < 10; i++){
            System.out.print(i + "|");
            for(int j = 0; j < 10; j++){
                if(oceanMap[i][j] == null || "2".equals(oceanMap[i][j])){
                    System.out.print(" ");
                }
                else if("1".equals(oceanMap[i][j])){
                    System.out.print("@");
                }
                else if("3".equals(oceanMap[i][j])){
                    System.out.print(".");
                }
                else if("4".equals(oceanMap[i][j])){
                    System.out.print("O");
                }
                else if("5".equals(oceanMap[i][j])){
                    System.out.print("X");
                }
                else if("6".equals(oceanMap[i][j])){
                    System.out.print("!");
                }
            }
            System.out.println("|" + i);
        }
        System.out.println("  0123456789  ");
        System.out.println("Player's ships = " + playerShip + " | Computer's ships = " + computerShip);
        System.out.println();
        System.out.println();
    }
    // yang bener playerInput2();
    public static void playerInput2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Deploy your ships:");
        for(int i = 0; i < 5; i ++){
            System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
            //Scanner input = new Scanner(System.in);
            int inputX = input.nextInt();
            System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
            //Scanner inputy = new Scanner(System.in);
            int inputY = input.nextInt();
            //
            while((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)){
                System.out.println("Your coordinate is out of bonds, please re-input another coordinate");
                System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
                inputX = input.nextInt();
                System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
                inputY = input.nextInt();
            }
            if(!"1".equals(oceanMap[inputY + 1][inputX + 2])){
                oceanMap[inputY + 1][inputX + 2] = "1";
            }
            else{
                while("1".equals(oceanMap[inputY + 1][inputX + 2])){
                    System.out.println("You have taken that coordinate...");
                    System.out.println("please input another coordinate : ");
                    System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
                    inputX = input.nextInt();
                    System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
                    inputY = input.nextInt();
                    if(!"1".equals(oceanMap[inputY + 1][inputX + 2])){
                        oceanMap[inputY + 1][inputX + 2] = "1";
                        break;
                    }
                }
            }
        }
        /*System.out.print("Enter X coordinate for your " + 1 + ". ship: ");
        Scanner inputx = new Scanner(System.in);
        int inputX = inputx.nextInt();
        System.out.print("Enter Y coordinate for your " + 1 + ". ship: ");
        Scanner inputy = new Scanner(System.in);
        int inputY = inputy.nextInt();
        oceanMap[inputX + 1][inputY + 2] = "1";*/
        printMap();
    }
    public static void playerInput3(){
        Scanner input = new Scanner(System.in);
        System.out.println("Deploy your ships:");
        for(int i = 0; i < 5; i++){
            System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
            //Scanner input = new Scanner(System.in);
            int inputX = input.nextInt();
            System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
            //Scanner inputy = new Scanner(System.in);
            int inputY = input.nextInt();
            //
            while((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)){
                System.out.println("Your coordinate is out of bonds, please re-input another coordinate");
                System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
                inputX = input.nextInt();
                System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
                inputY = input.nextInt();
            }
            if(!"1".equals(oceanMap[inputY][inputX])){
                oceanMap[inputY][inputX] = "1";
            }
            else{
                while("1".equals(oceanMap[inputY][inputX])){
                    System.out.println("You have taken that coordinate...");
                    System.out.println("please input another coordinate : ");
                    System.out.print("Enter X coordinate for your " + (i+1) + ". ship: ");
                    inputX = input.nextInt();
                    System.out.print("Enter Y coordinate for your " + (i+1) + ". ship: ");
                    inputY = input.nextInt();
                    if(!"1".equals(oceanMap[inputY][inputX])){
                        oceanMap[inputY][inputX] = "1";
                        break;
                    }
                }
            }
        }
        /*System.out.print("Enter X coordinate for your " + 1 + ". ship: ");
        Scanner inputx = new Scanner(System.in);
        int inputX = inputx.nextInt();
        System.out.print("Enter Y coordinate for your " + 1 + ". ship: ");
        Scanner inputy = new Scanner(System.in);
        int inputY = inputy.nextInt();
        oceanMap[inputX + 1][inputY + 2] = "1";*/
        printMap4();
    }
    // yang bener computerInput2();
    public static void computerInput2(){
        for(int i = 0; i < 5; i++) {
            Random input = new Random();
            int inputX = input.nextInt(9);
            int inputY = input.nextInt(9);
            if((!"1".equals(oceanMap[inputY + 1][inputX + 2])) && (!"2".equals(oceanMap[inputY + 1][inputX + 2]))){
                oceanMap[inputY + 1][inputX + 2] = "2";
                System.out.println(inputX + " " + inputY);
            }
            else{
                while((!"2".equals(oceanMap[inputY + 1][inputX + 2])) || (!"1".equals(oceanMap[inputY + 1][inputX + 2]))){
                    //System.out.println("Komputer, giliran anda memasukkan integer koordinat x :");
                    inputX = input.nextInt(9);
                    //System.out.println("Komputer, giliran anda memasukkan integer koordinat y :");
                    inputY = input.nextInt(9);
                    if((!"1".equals(oceanMap[inputY + 1][inputX + 2])) && (!"2".equals(oceanMap[inputY + 1][inputX + 2]))){
                        oceanMap[inputY + 1][inputX + 2] = "2";
                        System.out.println(inputX + " " + inputY);
                        break;
                    }
                }
            }
        }
    }
    public static void computerInput3(){
        for(int i = 0; i < 5; i++) {
            Random input = new Random();
            int inputX = input.nextInt(9);
            int inputY = input.nextInt(9);
            if((!"1".equals(oceanMap[inputY][inputX])) && (!"2".equals(oceanMap[inputY][inputX]))){
                oceanMap[inputY][inputX] = "2";
                //System.out.println(inputX + " " + inputY);
            }
            else{
                while((!"2".equals(oceanMap[inputY][inputX])) || (!"1".equals(oceanMap[inputY][inputX]))){
                    //System.out.println("Komputer, giliran anda memasukkan integer koordinat x :");
                    inputX = input.nextInt(9);
                    //System.out.println("Komputer, giliran anda memasukkan integer koordinat y :");
                    inputY = input.nextInt(9);
                    if((!"1".equals(oceanMap[inputY][inputX])) && (!"2".equals(oceanMap[inputY][inputX]))){
                        oceanMap[inputY][inputX] = "2";
                        //System.out.println(inputX + " " + inputY);
                        break;
                    }
                }
            }
        }
    }
    public static void playerTurn2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Let the game begins!");
        System.out.print("Player, please input your X coordinates : ");
        int inputX = input.nextInt();
        System.out.print("Player, please input your Y coordinates : ");
        int inputY = input.nextInt();
        if(((inputX >= 0 && inputX < 10) && (inputY >= 0 && inputY < 10)) && (("1".equals(oceanMap[inputY + 1][inputX + 2]))
                || ("2".equals(oceanMap[inputY + 1][inputX + 2])) || (oceanMap[inputY + 1][inputX + 2] == null))){
            if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                System.out.println();
                System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                System.out.println();
                computerShip--;
                oceanMap[inputY + 1][inputX + 2] = "4";
            }
            else if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                System.out.println();
                System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                System.out.println();
                playerShip--;
                oceanMap[inputY + 1][inputX + 2] = "5";
            }
            else{
                System.out.println();
                System.out.println("Keep guessing my friend!".toUpperCase());
                System.out.println();
                oceanMap[inputY + 1][inputX + 2] = "3";
            }
        }
        else if((!"1".equals(oceanMap[inputY + 1][inputX + 2])) || (!"2".equals(oceanMap[inputY + 1][inputX + 2]))
                || (oceanMap[inputY + 1][inputX + 2] != null)){
            while((!"1".equals(oceanMap[inputY + 1][inputX + 2])) || (!"2".equals(oceanMap[inputY + 1][inputX + 2]))
                    || (oceanMap[inputY + 1][inputX + 2] != null)) {
                System.out.println("The coordinate has been taken already, please input another coordinate...");
                System.out.print("Player, please input your X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Player, please input your Y coordinate : ");
                inputY = input.nextInt();
                if(("1".equals(oceanMap[inputY + 1][inputX + 2])) || ("2".equals(oceanMap[inputY + 1][inputX + 2]))
                        || (oceanMap[inputY + 1][inputX + 2] == null)){
                    if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                        System.out.println();
                        computerShip--;
                        oceanMap[inputY + 1][inputX + 2] = "4";
                    }
                    else if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                        System.out.println();
                        playerShip--;
                        oceanMap[inputY + 1][inputX + 2] = "5";
                    }
                    else{
                        System.out.println();
                        System.out.println("Keep guessing my friend!".toUpperCase());
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "3";
                    }
                }
            }

        }
        else{
            while((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)){
                System.out.println("Please enter a valid coordinate from 0 to 9");
                System.out.print("Please input X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Please input Y coordinate : ");
                inputY = input.nextInt();
                if(((inputX >= 0 && inputX < 10) && (inputY >= 0 && inputY < 10)) && (("1".equals(oceanMap[inputY + 1][inputX + 2]))
                        || ("2".equals(oceanMap[inputY + 1][inputX + 2])) || (oceanMap[inputY + 1][inputX + 2] == null))){
                    //oceanMap[inputY + 1][inputX + 2] = "3";
                    if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "4";
                        computerShip--;
                    }
                    else if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                        System.out.println();
                        playerShip--;
                        oceanMap[inputY + 1][inputX + 2] = "5";
                    }
                    else{
                        System.out.println();
                        System.out.println("Keep guessing my friend!".toUpperCase());
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "3";
                    }
                }
                else{//harusnya kalo ga sama dengan 1 atau 2
                    while((!"1".equals(oceanMap[inputY + 1][inputX + 2])) || (!"2".equals(oceanMap[inputY + 1][inputX + 2]))
                            || (oceanMap[inputY + 1][inputX + 2] != null)) {
                        System.out.println("The coordinate has been taken already, please input another coordinate...");
                        System.out.print("Player, please input your X coordinate : ");
                        inputX = input.nextInt();
                        System.out.print("Player, please input your Y coordinate : ");
                        inputY = input.nextInt();
                        if(("1".equals(oceanMap[inputY + 1][inputX + 2])) || ("2".equals(oceanMap[inputY + 1][inputX + 2]))
                                || (oceanMap[inputY + 1][inputX + 2] == null)){
                            if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                                System.out.println();
                                System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                                System.out.println();
                                computerShip--;
                                oceanMap[inputY + 1][inputX + 2] = "4";
                            }
                            else if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                                System.out.println();
                                System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                                System.out.println();
                                playerShip--;
                                oceanMap[inputY + 1][inputX + 2] = "5";
                            }
                            else{
                                System.out.println();
                                System.out.println("Keep guessing my friend!".toUpperCase());
                                System.out.println();
                                oceanMap[inputY + 1][inputX + 2] = "3";
                            }
                        }
                    }
                }
            }
        }
        printMap();
    }
    public static void playerTurn3(){
        Scanner input = new Scanner(System.in);
        System.out.println("Let the game begins!");
        System.out.print("Player, please input your X coordinates : ");
        int inputX = input.nextInt();
        System.out.print("Player, please input your Y coordinates : ");
        int inputY = input.nextInt();
        while((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)){
            System.out.println("Your coordinate is out of bonds, please re-input another coordinate");
            System.out.println("Please enter a valid coordinate from 0 to 9");
            System.out.print("Please input X coordinate : ");
            inputX = input.nextInt();
            System.out.print("Please input Y coordinate : ");
            inputY = input.nextInt();
        }
        if(((inputX >= 0 && inputX < 10) && (inputY >= 0 && inputY < 10)) && (("1".equals(oceanMap[inputY][inputX]))
                || ("2".equals(oceanMap[inputY][inputX])) || (oceanMap[inputY][inputX] == null))){
            if("2".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                System.out.println();
                computerShip--;
                oceanMap[inputY][inputX] = "4";
            }
            else if("1".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                System.out.println();
                playerShip--;
                oceanMap[inputY][inputX] = "5";
            }
            else{
                System.out.println();
                System.out.println("Keep guessing my friend!".toUpperCase());
                System.out.println();
                oceanMap[inputY][inputX] = "3";
            }
        }
        else if((!"1".equals(oceanMap[inputY][inputX])) || (!"2".equals(oceanMap[inputY][inputX]))
                || (oceanMap[inputY][inputX] != null)){
            while((!"1".equals(oceanMap[inputY][inputX])) || (!"2".equals(oceanMap[inputY][inputX]))
                    || (oceanMap[inputY][inputX] != null)) {
                System.out.println("The coordinate has been taken already, please input another coordinate...");
                System.out.print("Player, please input your X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Player, please input your Y coordinate : ");
                inputY = input.nextInt();
                if(("1".equals(oceanMap[inputY][inputX])) || ("2".equals(oceanMap[inputY][inputX]))
                        || (oceanMap[inputY][inputX] == null)){
                    if("1".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                        System.out.println();
                        computerShip--;
                        oceanMap[inputY][inputX] = "4";
                    }
                    else if("2".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                        System.out.println();
                        playerShip--;
                        oceanMap[inputY][inputX] = "5";
                    }
                    else{
                        System.out.println();
                        System.out.println("Keep guessing my friend!".toUpperCase());
                        System.out.println();
                        oceanMap[inputY][inputX] = "3";
                    }
                }
            }

        }
        printMap4();
    }
    public static void playerTurn4(){
        Scanner input = new Scanner(System.in);
        System.out.println("Let the game begins!");
        System.out.print("Player, please input your X coordinates : ");
        int inputX = input.nextInt();
        System.out.print("Player, please input your Y coordinates : ");
        int inputY = input.nextInt();
        while(((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)) || ((!"1".equals(oceanMap[inputY][inputX])) &&
                (!"2".equals(oceanMap[inputY][inputX])) && (oceanMap[inputY][inputX] != null))){
            if((inputX < 0 || inputX > 9) || (inputY < 0 || inputY > 9)){
                System.out.println("Your coordinate is out of bonds, please re-input another coordinate");
                System.out.println("Please enter a valid coordinate from 0 to 9");
                System.out.print("Please input X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Please input Y coordinate : ");
                inputY = input.nextInt();
            }
            else{
                System.out.println("That coordinate is taken, please input another coordinate");
                System.out.println("Please enter a valid coordinate from 0 to 9");
                System.out.print("Please input X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Please input Y coordinate : ");
                inputY = input.nextInt();
            }
        }
        if(((inputX >= 0 && inputX < 10) && (inputY >= 0 && inputY < 10)) && (("1".equals(oceanMap[inputY][inputX]))
                || ("2".equals(oceanMap[inputY][inputX])) || (oceanMap[inputY][inputX] == null))){
            if("2".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                System.out.println();
                computerShip--;
                oceanMap[inputY][inputX] = "4";
            }
            else if("1".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                System.out.println();
                playerShip--;
                oceanMap[inputY][inputX] = "5";
            }
            else{
                System.out.println();
                System.out.println("Keep guessing my friend!".toUpperCase());
                System.out.println();
                oceanMap[inputY][inputX] = "3";
            }
        }
        /*else if((!"1".equals(oceanMap[inputY][inputX])) || (!"2".equals(oceanMap[inputY][inputX]))
                || (oceanMap[inputY][inputX] != null)){
            while((!"1".equals(oceanMap[inputY][inputX])) || (!"2".equals(oceanMap[inputY][inputX]))
                    || (oceanMap[inputY][inputX] != null)) {
                System.out.println("The coordinate has been taken already, please input another coordinate...");
                System.out.print("Player, please input your X coordinate : ");
                inputX = input.nextInt();
                System.out.print("Player, please input your Y coordinate : ");
                inputY = input.nextInt();
                if(("1".equals(oceanMap[inputY][inputX])) || ("2".equals(oceanMap[inputY][inputX]))
                        || (oceanMap[inputY][inputX] == null)){
                    if("1".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("Wow, 1 ship is down! гг!".toUpperCase());
                        System.out.println();
                        computerShip--;
                        oceanMap[inputY][inputX] = "4";
                    }
                    else if("2".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("You've sunk your own ship! *facepalm*".toUpperCase());
                        System.out.println();
                        playerShip--;
                        oceanMap[inputY][inputX] = "5";
                    }
                    else{
                        System.out.println();
                        System.out.println("Keep guessing my friend!".toUpperCase());
                        System.out.println();
                        oceanMap[inputY][inputX] = "3";
                    }
                }
            }

        }*/
        printMap4();
    }
    public static void computerTurn(){
        System.out.println("Computer's turn !");
        Random input = new Random();
        int inputX = input.nextInt(9);
        int inputY = input.nextInt(9);
        // oceanMap[inputY + 1][inputX + 2] = "O";
        if(("1".equals(oceanMap[inputY + 1][inputX + 2])) || ("2".equals(oceanMap[inputY + 1][inputX + 2])) ||
                (oceanMap[inputY + 1][inputX + 2] == null)){
            if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                System.out.println();
                System.out.println("COMPUTER DESTROYED PLAYER'S SHIP!!");
                System.out.println();
                oceanMap[inputY + 1][inputX + 2] = "6";
                playerShip--;
            }
            else if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                System.out.println();
                System.out.println("HAHAHAHA COMPUTER DESTROYED IT'S OWN SHIP!!!!");
                System.out.println();
                oceanMap[inputY + 1][inputX + 2] = "5";
                computerShip--;
            }
            else{
                System.out.println();
                System.out.println("Keep guessing computer!");
                oceanMap[inputY + 1][inputX + 2] = "3";
            }
        }
        else{
            while((!("1".equals(oceanMap[inputY + 1][inputX + 2]))) || (!("2".equals(oceanMap[inputY + 1][inputX + 2])))
                    || (oceanMap[inputY + 1][inputX + 2] != null)){
                System.out.println("Computer has taken that coordinate, please input another coordinate, computer!");
                inputX = input.nextInt(9);
                inputY = input.nextInt(9);
                if(("1".equals(oceanMap[inputY + 1][inputX + 2])) || ("2".equals(oceanMap[inputY + 1][inputX + 2])) ||
                        (oceanMap[inputY + 1][inputX + 2] == null)){
                    if("1".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("COMPUTER DESTROYED PLAYER'S SHIP!!");
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "6";
                        playerShip--;
                        break;
                    }
                    else if("2".equals(oceanMap[inputY + 1][inputX + 2])){
                        System.out.println();
                        System.out.println("HAHAHAHA COMPUTER DESTROYED IT'S OWN SHIP!!!!");
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "5";
                        computerShip--;
                        break;
                    }
                    else{
                        System.out.println();
                        System.out.println("Keep guessing computer!");
                        System.out.println();
                        oceanMap[inputY + 1][inputX + 2] = "3";
                        break;
                    }
                }
            }
        }
        System.out.println();
        printMap();
    }
    public static void computerTurn2(){
        System.out.println("Computer's turn !");
        Random input = new Random();
        int inputX = input.nextInt(9);
        int inputY = input.nextInt(9);
        // oceanMap[inputY + 1][inputX + 2] = "O";
        if(("1".equals(oceanMap[inputY][inputX])) || ("2".equals(oceanMap[inputY][inputX])) ||
                (oceanMap[inputY][inputX] == null)){
            if("1".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("COMPUTER DESTROYED PLAYER'S SHIP!!");
                System.out.println();
                oceanMap[inputY][inputX] = "6";
                playerShip--;
            }
            else if("2".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("HAHAHAHA COMPUTER DESTROYED IT'S OWN SHIP!!!!");
                System.out.println();
                oceanMap[inputY][inputX] = "5";
                computerShip--;
            }
            else{
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("Keep guessing computer!");
                oceanMap[inputY][inputX] = "3";
            }
        }
        else{
            while((!("1".equals(oceanMap[inputY][inputX]))) || (!("2".equals(oceanMap[inputY][inputX])))
                    || (oceanMap[inputY][inputX] != null)){
                System.out.println("Computer has taken that coordinate, please input another coordinate, computer!");
                inputX = input.nextInt(9);
                inputY = input.nextInt(9);
                if(("1".equals(oceanMap[inputY][inputX])) || ("2".equals(oceanMap[inputY][inputX])) ||
                        (oceanMap[inputY][inputX] == null)){
                    if("1".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("Computer choose : " + inputX + ", " + inputY);
                        System.out.println("COMPUTER DESTROYED PLAYER'S SHIP!!");
                        System.out.println();
                        oceanMap[inputY][inputX] = "6";
                        playerShip--;
                        break;
                    }
                    else if("2".equals(oceanMap[inputY][inputX])){
                        System.out.println();
                        System.out.println("Computer choose : " + inputX + ", " + inputY);
                        System.out.println("HAHAHAHA COMPUTER DESTROYED IT'S OWN SHIP!!!!");
                        System.out.println();
                        oceanMap[inputY][inputX] = "5";
                        computerShip--;
                        break;
                    }
                    else{
                        System.out.println();
                        System.out.println("Computer choose : " + inputX + ", " + inputY);
                        System.out.println("Keep guessing computer!");
                        System.out.println();
                        oceanMap[inputY][inputX] = "3";
                        break;
                    }
                }
            }
        }
        System.out.println();
        printMap4();
    }
    public static void computerTurn3(){
                System.out.println("Computer's turn !");
        Random input = new Random();
        int inputX = input.nextInt(9);
        int inputY = input.nextInt(9);
        // oceanMap[inputY + 1][inputX + 2] = "O";
        while("3".equals(oceanMap[inputY][inputX]) || "4".equals(oceanMap[inputY][inputX]) || "5".equals(oceanMap[inputY][inputX])
                || "6".equals(oceanMap[inputY][inputX])){
            System.out.println("Computer has taken that coordinate, please input another coordinate, computer!");
            inputX = input.nextInt(9);
            inputY = input.nextInt(9);
        }
        if(("1".equals(oceanMap[inputY][inputX])) || ("2".equals(oceanMap[inputY][inputX])) ||
                (oceanMap[inputY][inputX] == null)){
            if("1".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("COMPUTER DESTROYED PLAYER'S SHIP!!");
                System.out.println();
                oceanMap[inputY][inputX] = "6";
                playerShip--;
            }
            else if("2".equals(oceanMap[inputY][inputX])){
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("HAHAHAHA COMPUTER DESTROYED IT'S OWN SHIP!!!!");
                System.out.println();
                oceanMap[inputY][inputX] = "5";
                computerShip--;
            }
            else{
                System.out.println();
                System.out.println("Computer choose : " + inputX + ", " + inputY);
                System.out.println("Keep guessing computer!");
                oceanMap[inputY][inputX] = "3";
            }
        }
        System.out.println();
        printMap4();
    }
}


