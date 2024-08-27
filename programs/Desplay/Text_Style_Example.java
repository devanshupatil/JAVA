package Desplay;

public class Text_Style_Example {
    // ANSI escape codes for styles
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String DIM = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLINK = "\u001B[5m";
    public static final String INVERSE = "\u001B[7m";
    public static final String HIDDEN = "\u001B[8m";
    public static final String STRIKETHROUGH = "\u001B[9m";

    public static void main(String[] args) {
        System.out.println(BOLD + "This text is bold." + RESET);
        System.out.println(DIM + "This text is dim." + RESET);
        System.out.println(ITALIC + "This text is italic." + RESET);
        System.out.println(UNDERLINE + "This text is underlined." + RESET);
        System.out.println(BLINK + "This text is blinking." + RESET);
        System.out.println(INVERSE + "This text is inversed (swapped colors)." + RESET);
        System.out.println(HIDDEN + "This text is hidden." + RESET);
        System.out.println(STRIKETHROUGH + "This text is strikethrough." + RESET);
    }
}
