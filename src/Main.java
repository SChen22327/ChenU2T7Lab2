import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;
        System.out.print("Enter the starting word: ");
        String oldWord = scan.nextLine();

        while (score < 50) {
            System.out.print("Enter the next word: ");
            String newWord = scan.nextLine();

            if (newWord.compareTo(oldWord) > 0) {
                score += 2;
            } else if (newWord.compareTo(oldWord) < 0) {
                score -= 5;
            } else {
                System.out.println("They're the same word. - 10 points");
                score -= 10;
            }
            for (int i = newWord.length() + 1; i >= 1; i--) {
                if (newWord.compareTo(oldWord) == 0) {
                    break;
                }
                int index = oldWord.indexOf(newWord.substring(0,i));
                if (newWord.length() - i != 0 && index > -1) {
                    score = (2 * i) + 1;
                } else {
                    break;
                }
            }
            System.out.print(score);

        }
    }
}