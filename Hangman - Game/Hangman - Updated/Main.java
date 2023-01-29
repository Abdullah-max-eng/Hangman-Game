import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static  Node [] words;
    public static Node word;
    public static String asterisk;
    public static Scanner sc = new Scanner(System.in);
    public static int numberOfActivity;
    public static Node current;
    public static boolean cont = true;
    public static  int counter = 0;
    private static int count = 0;

    




    public static void addWords() {
        while(cont) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a word to add");
            System.out.print("Input : ");
            WordsLinkedLists.add(sc.nextLine());
            
            System.out.println("Do you want to enter another word? [yes/no] ");
            if(sc.nextLine().equals("yes")){

            }else {
                cont = false;
                WordsLinkedLists.convertToArray();
            }  
        }
        cont = true;
    }



    public static void knowCount(){
            System.out.println(words.length + " Words are in the game list. ");       

    }


    

    public static void print(){
        
        if(words.length == 0){
            System.out.println("There is no Word in the list ");
        }else{
                System.out.println("All the words are listed below : ");
                for(int i =0; i < words.length; i++){
                    System.out.print(" "+ words[i].word + " --- ");
                }
                System.out.println();
    }
    }



    public static void main(String[] args) {
        printMenue();
    }



    public static void printMenue(){
        System.out.println("****************************************************************************************************************************************************************");
        System.out.println("What do you want to do? \n  1 - Add words \n  2 - Number of words in the Game \n  3- Print all the words \n  4- Play the Game ");
        System.out.print("You input: ");
        numberOfActivity = sc.nextInt();

        if(numberOfActivity == 1){
            addWords();
            printMenue();
        }
        else if(numberOfActivity ==2 ){
            knowCount();
            printMenue();
        } 
        else if(numberOfActivity == 3){
            print();
            printMenue();


        }else if( numberOfActivity == 4){
            playGame();
            printMenue();
        }
        
    }





    public static void playGame(){
    

            word = words[(int) (Math.random() * words.length)];
            asterisk = new String(new char[word.word.length()]).replace("\0", "*");
            
            while (count < 7 && asterisk.contains("*")) {
                System.out.println("Guess any letter in the word");
                System.out.println(asterisk);
                System.out.print("Your guessed character: ");
                String guess = sc.next();
                hang(guess);
            }
            count =1;
            
    }


    public static void hang(String guess) {
    
        String newasterisk = "";

        for (int i = 0; i < word.word.length(); i++) {
            if (word.word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            hangmanImage();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word.word)) {
            System.out.println("****************************Correct! You win! The word was <<" + word.word + ">>*****************************************************");
        }
    }


    public static void hangmanImage() {
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            // count = 1; 
            System.out.println("*******************************GAME OVER! The word was <<" + word.word + ">>****************************** " );
            // return;
        }
    }
}


class Node{
    String word;
    Node nextNode;
}

class WordsLinkedLists{
    public static Node head;

    public static void  convertToArray(){
        int countList = 0;
        Main.current = head;
        while(Main.current != null){
            countList++;
            Main.current = Main.current.nextNode;
        }
        Main.words = new Node [countList]; // This is our array that will contain object in the linked lists
        Main.current = head;

        int i = 0;

        while(Main.current != null){
            Main.words[i] = Main.current;
            i++;
            Main.current = Main.current.nextNode;
        }
        
}




public static void add(String word){ 
        Node myNode = new Node();

        myNode.word = word;

        if( head == null){
            head = myNode;
            
        }

        else{
             Main.current = head; 
            while(Main.current.nextNode != null){
                Main.current = Main.current.nextNode;
            }
            // Node tempt = current;
            Main.current.nextNode = myNode;
          
            
        }
    }

}


