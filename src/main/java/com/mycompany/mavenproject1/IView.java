public interface IView {
    boolean choose(String question);
    String choose(String question, String option1, String option2);
    String ask(String question);
    void append(String message);
    void display(String message);
}
