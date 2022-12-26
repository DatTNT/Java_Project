/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPbank;

import java.util.Scanner;

/**
 *
 * @author dattn
 */
public class ManageEBank {
    Scanner sc = new Scanner(System.in);
    
    void getAction(Ebank ebank) {
      String account, password;
      
        while (true) {            
            System.out.println(ebank.bundle.getString("account_Number"));
            account = sc.nextLine();
            if(ebank.getAccount(account).equals("")){
                break;
            }else{
                System.out.println("Wrong!!!!!");
            }
            
        }
        while (true) {            
            System.out.println(ebank.bundle.getString("password"));
            password = sc.nextLine();
            if(ebank.getPassword(password).equals("")){
                break;
            }else{
                System.out.println("Wrong!!!!!");
            }
            
        }
        while (true) {            
            String randomString = ebank.generateCaptcha();
            System.out.println(ebank.bundle.getString("captcha_input") + randomString);
            String input = sc.nextLine();
            if(ebank.CheckCaptcha(input, randomString).equals("")){
                break;
            }else{
                System.out.println("Wrong1!!!");
            }
        }
        
        System.out.println(ebank.bundle.getString("successeror"));
    }
    
}
