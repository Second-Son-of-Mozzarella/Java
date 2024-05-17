package edu.wctc.dice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.register(AppConfig.class);
//        context.refresh();


        context.getBean("diceGame", DiceGame.class).play();
    }
}
