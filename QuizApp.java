import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Adding 10 Java quiz questions
        questions.add(new Question(
            "What are Java loops?",
            Arrays.asList("Used for iteration", "Used for exceptions", "Used for storage", "None of the above"),
            1
        ));
        questions.add(new Question(
            "What is an enhanced for-loop in Java?",
            Arrays.asList("Iterates over arrays/collections", "Infinite loop", "Special while loop", "None of the above"),
            1
        ));
        questions.add(new Question(
            "How do you handle multiple user inputs in Java?",
            Arrays.asList("By using for loop", "By using multiple Scanner objects", "By using loops and arrays", "By creating multiple main methods"),
            3
        ));
        questions.add(new Question(
            "How is a switch-case different from if-else?",
            Arrays.asList("switch-case is faster for multiple conditions", "if-else is faster than switch-case", "switch-case supports ranges", "switch-case can only compare strings"),
            1
        ));
        questions.add(new Question(
            "What are Collections in Java?",
            Arrays.asList("Framework for storing and manipulating groups of objects", "A group of primitive arrays", "A single object", "Only used for sorting data"),
            1
        ));
        questions.add(new Question(
            "What is an ArrayList in Java?",
            Arrays.asList("A fixed-size array", "A resizable array implementation of List interface", "A map of key-value pairs", "A set of unique elements"),
            2
        ));
        questions.add(new Question(
            "How to iterate using Iterators in Java?",
            Arrays.asList("By calling iterator() on collection and using next()", "By using for loop only", "By converting to an array", "By using System.out.println()"),
            1
        ));
        questions.add(new Question(
            "What is a Map in Java?",
            Arrays.asList("Stores key-value pairs", "Stores only keys", "Stores only values", "Stores elements in sequential order"),
            1
        ));
        questions.add(new Question(
            "How to sort a list in Java?",
            Arrays.asList("Collections.sort(list)", "list.sort() only", "sort(list) function", "Arrays.sort(list) only"),
            1
        ));
        questions.add(new Question(
            "How to shuffle elements in a list in Java?",
            Arrays.asList("Collections.shuffle(list)", "list.shuffle()", "Arrays.shuffle(list)", "By manually swapping elements"),
            1
        ));

        int score = 0;
        System.out.println("===== Welcome to the Java Quiz =====");
        System.out.println("Answer by typing the option number (1-4)\n");

        // Loop through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println("   " + (j + 1) + ") " + q.options.get(j));
            }

            System.out.print("Your answer: ");
            int answer;
            while (true) {
                try {
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer >= 1 && answer <= 4) break;
                    else System.out.print("Invalid choice! Please enter 1-4: ");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input! Please enter a number: ");
                }
            }

            if (answer == q.correctOption) {
                score++;
            }
            System.out.println();
        }

        // Show results
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.2f%%\n", percentage);
        if (percentage >= 80) {
            System.out.println("Excellent! You have strong Java knowledge.");
        } else if (percentage >= 50) {
            System.out.println("Good! But you can improve.");
        } else {
            System.out.println("Needs improvement. Keep practicing!");
        }

        sc.close();
    }
}
