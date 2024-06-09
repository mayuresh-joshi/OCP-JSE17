package org.mj.module1.lesson2;

public class TextBlockExample {
    public static void main(String[] args) {
        String textBlock = """
                Mayuresh
                Joshi""";

        String newLineEscaped = """
                Mayuresh\
                Joshi""";

        String howToAddBackslash = """
                Mayuresh\\Joshi""";

        // if less than three double quotes no need of escaping,
        String howToAddDoubleQuotes = """
                ""Mayuresh""\"
                "Joshi"
                \"\"\"""";

        System.out.println(textBlock);
        System.out.println(newLineEscaped);
        System.out.println(howToAddBackslash);
        System.out.println(howToAddDoubleQuotes);
    }
}
