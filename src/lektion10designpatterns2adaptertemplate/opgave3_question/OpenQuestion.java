package lektion10designpatterns2adaptertemplate.opgave3_question;

import java.util.Scanner;

public class OpenQuestion extends Question{
    private String question;
    private String correctAnswer;

    public OpenQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    protected void displayQuestion() {
        System.out.println("Åbent Spørgsmål: " + question);
    }

    @Override
    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Dit svar: ");
        return scan.nextLine();
    }

    @Override
    protected boolean checkAnswer(String answer) {
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }
}
