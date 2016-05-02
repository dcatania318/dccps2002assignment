/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Connor
 */

import java.util.HashMap;

public class Library {
    
    private static Library instance = null;
    private HashMap<String,User> database = null;
    
    private Library() {
        this.database = new HashMap<String,User>();
    }
    
    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        
        return instance;
    }
    
    public static void dropLibrary() {
        instance = null;
        System.gc();
    }
    
    public void addUser(User user) {
        if(database.containsKey(user.getID()) == true) {
            System.err.println("[ERR] This user has already been registered.");
            return;
        }
        
        database.put(user.getID(), user);
    }
    
    public void removeUser(User user) {
        database.remove(user.getID());
    }
    
    public void loanBookTo(Book book, User user) {
        if(book.getUserLoanedTo() != null) {
            System.out.println("This book has already been loaned.");
            return;
        }
        
        user.loan(book);
        book.setLoanedTo(user);
    }
    
    public void returnBook(Book book) {
        User currentUser = book.getUserLoanedTo();
        
        if(!(currentUser == null)) {
            currentUser.unloan(book);
             book.setLoanedTo(null);
        }
        else {
            System.out.println("This book is not currently on loan.");
        }
    }
    
    public User[] getAllUsers() {
        return database.values().toArray(new User[database.size()]);
    }
    
    public User searchByID(String ID) {
       return database.get(ID);
    }
}
