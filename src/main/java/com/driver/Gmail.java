package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<myMail> mails;
    ArrayList<myMail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        mails = new ArrayList<>();
        trash = new ArrayList<>();

    }

    public void receiveMail(Date date, String sender, String message){

        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        while(mails.size() >= this.inboxCapacity){
            trash.add(mails.get(0));
            mails.remove(0);
        }
        mails.add(new myMail(date, sender, message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        for(int i=0;i<mails.size();i++){
            if(message.equals(mails.get(i).msg)){
                mails.remove(i);
            }
        }
        return;
    }

    public String findLatestMessage(){

        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(mails.size()==0)
            return null;
        else{
            return mails.get(mails.size()-1).msg;
        }

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(mails.size()==0) return null;

        return mails.get(0).msg;

    }

    public int findMailsBetweenDates(Date start, Date end){

        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;

        for(int i=0;i<mails.size();i++){
            Date test = mails.get(i).date;
            if(test.compareTo(start) >= 0 && test.compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        return mails.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }

    class myMail{
        Date date;
        String sender;
        String msg;
        myMail(Date date,String sender,String msg){
            this.date = date;
            this.sender = sender;
            this.msg = msg;
        }
    }
}
