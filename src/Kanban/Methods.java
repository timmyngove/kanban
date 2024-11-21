/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kanban;

/**
 *
 * @author TimmyNgove
 */


public class Methods {
    String username;
    String password;
    String firstname = "Timmy"; // Default first name
    String surname = "Ngove";    // Default surname 
    String enteredUserName;
    String enteredPassword;

    public boolean checkUsername() {
        // Username requirements
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity() {
        // Password requirements
        boolean capitalLetter = false;
        boolean num = false;
        boolean special = false;

        if (password.length() >= 8) {
            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) capitalLetter = true;
                if (Character.isDigit(ch)) num = true;
                if (!Character.isLetterOrDigit(ch)) special = true;
            }
        }
        return capitalLetter && num && special;
    }

    public String registerUser() {
        StringBuilder response = new StringBuilder();
        
        if (checkUsername()) {
            response.append("Username successfully captured.\n");
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (checkPasswordComplexity()) {
            response.append("Password successfully captured.");
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        return response.toString();
    }

    public boolean loginUser() {
        return username.equals(enteredUserName) && password.equals(enteredPassword);
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            return "Successful login\nWelcome " + firstname + ", " + surname + ", it is great to see you.";
        } else {
            return "A failed login\nUsername or Password incorrect, please try again.";
        }
    }
}

