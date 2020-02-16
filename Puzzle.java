import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle{
    
    String tempWord ="";
    ArrayList<String> guess = new ArrayList<String>();
    ArrayList<String> puzzle = new ArrayList<String>(); 
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> words= new ArrayList<String>();
    public Puzzle(){

        words= new ArrayList<String>();
        
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                tempWord = scanner.next().toLowerCase();
                words.add(tempWord);
            }
            scanner.close();

            //ONCE THIS LINE OF CODE IS REACHED, YOUR words ArrayList
            //CONTAINS ALL THE WORDS IN words.txt
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<tempWord.length();i++){
            wordList.add(tempWord.substring(i,i+1));
        }
    }

    public boolean isUnsolved(){

        if(puzzle.equals(wordList)){
            return false;
        }else if(puzzle.contains("_")){
        return false;
    }else{
        return true;
    }
    }

    public boolean makeGuess(String guesses){
        boolean right = false;
        guess.add(guesses);
        for(int i = 0; i<wordList.size();i++){
            if(wordList.get(i).equals(guesses)){
                right = true;
                puzzle.add(guesses);

            }
        }
        return right;
    }

    public String getWord(){
        return tempWord;
    }

    public void show(){ // print puzzle and guesses
        System.out.print("Puzzle: ");
        for(int i = 0; i<wordList.size();i++){
            if(puzzle.contains(wordList.get(i))){
                System.out.print(wordList.get(i) + " ");
            }else{
                System.out.print("_");
            }
        }
        System.out.println();
        System.out.print("Guesses: " + guess);

    }
}
