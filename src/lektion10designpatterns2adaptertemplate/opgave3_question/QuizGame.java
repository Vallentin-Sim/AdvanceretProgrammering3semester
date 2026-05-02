package lektion10designpatterns2adaptertemplate.opgave3_question;

// Konkrete implementeringer af Game
public class QuizGame extends Game {
    private Question[] questions;

    public QuizGame(Question[] questions) {
        this.questions = questions;
    }

    protected void askQuestions() {
        for (Question question : questions) {
            question.askQuestion();
        }
    }
}

