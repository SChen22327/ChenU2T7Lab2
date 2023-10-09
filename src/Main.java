import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;
        int wordCount = 1;
        System.out.print("Enter the starting word: ");
        String oldWord = scan.nextLine();
        String newWord;

        while (score < 50) {
            wordCount += 1;
            System.out.print("Enter the next word: ");
            newWord = scan.nextLine();

            if (newWord.compareTo(oldWord) > 0) {
                score += 2;
                System.out.println("+2 points: current word alphabetically after; SCORE: " + score);
            } else if (newWord.compareTo(oldWord) < 0) {
                score -= 5;
                System.out.println("-5 points: current word alphabetically before; SCORE: " + score);
            } else {
                score -= 10;
                System.out.println("-10 points: exact same as previous; SCORE: " + score);
            }
            if (!newWord.equals(oldWord)) {
                for (int i = 1; i < newWord.length(); i++) {
                    if (oldWord.substring(oldWord.length() - i).equals(newWord.substring(0, i))) {
                        score += 2 * i + 1;
                        System.out.println("+" + (2 * i + 1) + " points: " + oldWord + "'s last letters \"" + oldWord.substring(oldWord.length() - i) + "\" match " + newWord + "'s first letters \"" + newWord.substring(0, i) + "\"; SCORE: " + score);
                        break;
                    }
                }
                if (newWord.contains(oldWord.substring(0, 1))) {
                    score += 3;
                    System.out.println("+3 points: " + oldWord + "'s first letter " + oldWord.substring(0, 1) + " is in " + newWord + "; SCORE: " + score);
                }
            }
            oldWord = newWord;
            System.out.println();
        }
        System.out.println("You win! It took you " + wordCount + " words! Try again for a lower word count.");
    }
}