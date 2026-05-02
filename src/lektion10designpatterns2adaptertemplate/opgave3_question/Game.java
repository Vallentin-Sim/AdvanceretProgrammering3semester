package lektion10designpatterns2adaptertemplate.opgave3_question;
// Abstrakt klasse Game
public abstract class Game {
    // Template Method
    public void playGame() {
        System.out.println("Spillet er startet.");
        askQuestions();
        System.out.println("Spillet er slut.");
    }

    // Abstrakt metode, der skal implementeres af underklasser
    protected abstract void askQuestions();
}
