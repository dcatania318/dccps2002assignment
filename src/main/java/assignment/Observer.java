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
public abstract class Observer {
    
    protected User subject;
    
    public abstract void update(int pos);
}
