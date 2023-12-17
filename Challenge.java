package WPM;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Challenge {
    static final String[] words = {"again", "bought", "catch", "eight", "island", "black", "white",
            "there", "chips", "rumble", "robot", "wizard", "walk", "lemon", "ronaldo", "charlie", "romeo",
            "giraffe", "zebra"};

    static final String[] easywords = {"cat", "done", "mad", "full", "go", "eat", "dog",
            "war", "chip", "toy", "milk", "joy", "fox", "easy", "fish", "hi", "sun",
            "fun", "hug"};

    static final String[] hardwords = {"excellent", "neighbour", "is", "definitely", "demolish", "humble", "dog",
            "exaggerate", "magazine", "grumpy", "selfish", "beautiful", "schedule", "conscience", "restaurant", "embarrass", "appearance",
            "pilgrimage", "moustache"};

    public static void main(String[] args) {
        try {
            chal(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void chal(int n) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("3");
        TimeUnit.SECONDS.sleep(1);

        System.out.print(" 2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println(" 1");
        TimeUnit.SECONDS.sleep(1);

        Random rand = new Random();

        // Generate random words based on the difficulty level
        String[] challengeWords = generateChallengeWords(n, rand);

        // Display the challenge words
        for (String word : challengeWords) {
            System.out.print(word + " ");
        }
        System.out.println();

        System.out.println("TYPE!: ");

        double start = LocalTime.now().toNanoOfDay();

        // Get user input
        String typedWords = scan.nextLine();

        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;
        int numChars = typedWords.length();

        // Calculate words per minute (WPM)
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

        // Check correctness and calculate accuracy
        int correctWords = countCorrectWords(challengeWords, typedWords);
        double accuracy = ((double) correctWords / challengeWords.length) * 100;

        // Print results
        System.out.println("Your words per minute is: " + wpm + "!");
        System.out.println("Accuracy: " + accuracy + "%");
        scan.close();
    }

    private static String[] generateChallengeWords(int n, Random rand) {
        switch (n) {
            case 8:
                return getRandomWords(easywords, rand, 8);
            case 11:
                return getRandomWords(words, rand, 11);
            case 15:
                return getRandomWords(hardwords, rand, 15);
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }
    }

    private static String[] getRandomWords(String[] wordList, Random rand, int count) {
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = wordList[rand.nextInt(wordList.length)];
        }
        return result;
    }

    private static int countCorrectWords(String[] challengeWords, String typedWords) {
        String[] typedArray = typedWords.split("\\s+");
        int correctCount = 0;

        for (int i = 0; i < Math.min(challengeWords.length, typedArray.length); i++) {
            if (challengeWords[i].equalsIgnoreCase(typedArray[i])) {
                correctCount++;
            }
        }

        return correctCount;
    }
}
