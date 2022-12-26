/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author dattn
 */
public class Validate {
    
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";
    public static final String REGEX_UD = "[uUdD]";
    
    static Scanner sc = new Scanner(System.in);

    public static int getInt(String message, String firstError,
            String secondError, String thirdError, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                int number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public static double getDouble(String message, String firstError,
            String secondError, String thirdError, double min, double max) {
        while (true) {
            try {
                System.out.println(message);

                double number = Double.parseDouble(sc.nextLine());

                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }

    public static float getFloat(String message, String firstError,
            String secondError, String thirdError, float min, float max) {
        while (true) {
            try {
                System.out.println(message);

                float number = Float.parseFloat(sc.nextLine());

                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.println(message);
            String textInput = sc.nextLine().trim();

            if (textInput.matches(regex)) {
                return textInput;
            } else {
                System.out.println(error);
            }
        }
    }
}
