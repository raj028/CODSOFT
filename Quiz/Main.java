package Quiz;

import java.util.*;

class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;
    private Timer timer;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.timer = new Timer();
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 60 seconds to answer each question.");

        for (Question question : questions) {
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    displayResult();
                    timer.cancel();
                    System.exit(0);
                }
            }, 60000);

            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= options.size()) {
                String answer = options.get(choice - 1);
                if (question.isCorrectAnswer(answer)) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
        displayResult();
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }
}

class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("London", "Paris", "Berlin", "Rome"), "Paris"));
        questions.add(new Question("What is the largest planet in the solar system?",
                Arrays.asList("Jupiter", "Saturn", "Mars", "Earth"), "Jupiter"));

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
