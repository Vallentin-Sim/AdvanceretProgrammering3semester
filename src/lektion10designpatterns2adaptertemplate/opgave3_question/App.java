package lektion10designpatterns2adaptertemplate.opgave3_question;

public class App {
    public static void main(String[] args) {
        // Oprettelse af spørgsmål
        Question[] questions = {
                new MultipleChoiceQuestion("Hvad er hovedstaden i Frankrig?", new String[]{"Paris", "Berlin", "London"}, 0),
                new TrueFalseQuestion("Er jorden rund?", true),
                new OpenQuestion("Hvad hedder Frankrigs præsident?: ", "Macron")
        };

        // Oprettelse af spil og afvikling
        Game game = new QuizGame(questions);
        game.playGame();
    }

}

