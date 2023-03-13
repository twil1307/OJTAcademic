/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author toten   
 */
public class OTPGenerate {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int OTP_LENGTH = 6;
    
    public static String generateOTP() {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        
        for (int i = 0; i < OTP_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        
        return sb.toString().toUpperCase();
    }
    
    public static void main(String[] args) {
        String otp = generateOTP();
        System.out.println("OTP: " + otp);
    }
}
