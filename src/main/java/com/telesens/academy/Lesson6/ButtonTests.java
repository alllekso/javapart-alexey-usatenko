package com.telesens.academy.Lesson6;


public class ButtonTests {
    public static void main(String[] args) {
        Button button = new Button();
        button.print();

        testConstructor();
    }

    private static void testConstructor() {
        Button button = new Button(10, 20, "Login");
        int width = button.getWidth();
        int heigh = button.getHeigh();
        String text = button.getText();



        System.out.println(width == 10);
        assert width == 10;
        assert heigh == 20;
        assert text.equals("Login");

    }
}
