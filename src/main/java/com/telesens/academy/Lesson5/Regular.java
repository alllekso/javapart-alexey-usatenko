package com.telesens.academy.Lesson5;

public class Regular {
    public static void main(String[] args) {
        String str = "Тhis is is a test => this is <strong>is</strong> a test";
        String regex = "(\\b\\w+\\b)(\\s)(\\1)";
        String result = str.replaceAll(regex, "$1$2<strong>$3</strong>");
        System.out.println(str);
        System.out.println(result);;

    }

}