/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPbank;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author dattn
 */
public class Ebank {

    public static final String REGEX_ACCOUNT = "[0-9]{10}";
    public static final String REGEX_PASSWORD = "(?=.*\\d.*)(?=.*[a-zA-Z].*)\\S{8,31}";
    public static final String REGEX_CAPTCHA = "[a-zA-Z0-9]+";
    static Scanner sc = new Scanner(System.in);
    
    ResourceBundle bundle;

    public Ebank() {
    }

    public Ebank(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public void setBundle(Locale locale) {
        bundle = ResourceBundle.getBundle("languages/language", locale);
    }
    
    public String getAccount(String account){
        String InputAccount = "";
        
        if(!account.matches(REGEX_ACCOUNT)){
            System.out.println(bundle.getString("account_number_error"));
        }
        return InputAccount;
    }
    
    public String getPassword(String passwordAccount) {

        String password = "";
        if (!passwordAccount.matches(REGEX_PASSWORD)) {
            password = bundle.getString("password_error");
        }
        return password;
    }
    
     public int getInt(String mess,String firstError,
            String secondError, String thirdError, int min, int max) {
        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.println(mess);
                int number = Integer.parseInt(sc.nextLine().trim());
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
     
     public String generateCaptcha() {
        String[] listCharacter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(listCharacter.length);
            result += listCharacter[index];
        }
        return result;
    }
     
      public String CheckCaptcha(String captcha, String captchaGenerate) {
        String output = "";
            //check captcha 
            if (!captchaGenerate.contains(captcha) || captcha.isEmpty()) {
                output = bundle.getString("captcha_error");
            }
        return output;
    }
}
