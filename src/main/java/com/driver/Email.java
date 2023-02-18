package com.driver;

public class Email {

    private String emailId;
    private String password;

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword)){
            boolean length=false,uc=false,lc=false,dig=false,sp=false;
            if(newPassword.length() >= 8) length = true;
            for(int i=0;i<newPassword.length();i++){
                char c = newPassword.charAt(i);
                if(c > 97 && c < 124){
                    lc = true;
                }
                else if(c > 64 && c <91){
                    uc = true;
                }
                else if(c > 47 && c < 58){
                    dig = true;
                }
                else{
                    sp = true;
                }
            }
            if(length && uc && lc && sp && dig)
                this.password = newPassword;
            return;
        }
    }
}
