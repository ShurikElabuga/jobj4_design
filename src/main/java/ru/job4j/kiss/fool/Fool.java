package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
       System.out.println("Игра FizzBuzz.");
       playGame();
            }

            public static void playGame() {
                var input = new Scanner(System.in);
                var startAt = 1;
                while (startAt < 100) {
                    System.out.println(createAnswer(startAt));
                    startAt++;
                    var answer = input.nextLine();
                    if(checkAnswer(answer, startAt)) {
                        startAt = 0;
                    }
                    startAt++;
                }
            }

            public static String createAnswer(int num) {
                    String result;
                if (num % 3 == 0 && num % 5 == 0) {
                    result = "FizzBuzz";
                } else if (num % 3 == 0) {
                    result = "Fizz";
                } else if (num % 5 == 0) {
                    result = "Buzz";
                } else {
                    result = String.valueOf(num);
                }
                return result;
            }

            public static boolean checkAnswer(String answer, int num) {
                boolean result = false;
                if(!createAnswer(num).equals(answer)) {
                    System.out.println("Ошибка. Начинай снова.");
                    result = true;
                }
                return result;
            }


        }
