//package com.telesens.academy.lesson14;
//
//import java.util.function.Function;
//
//import static com.telesens.academy.lesson14.lambda.LambdaDemo.doSomethingWithString;
//
//public class LambdaDemo {
//    String str = "Hello World";
//    String res = doSomethingWithString(str, s->s.toUpperCase());
//    String res2 = doSomethingWithString(str, String::toLowerCase);
//    Function<String, String> f1 = s->s.toUpperCase();
//    Function<String, String> f2 = String::toLowerCase;
//    String res3 = doSomethingWithString(str, f2);
////         System.out.println(res);
////         System.out.println(res2);
////    // TODO
//}
