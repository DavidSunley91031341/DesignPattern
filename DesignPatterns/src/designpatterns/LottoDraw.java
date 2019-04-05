/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 91031341
 */
public class LottoDraw extends Observable {

// list of all subscribed observers
    private ArrayList<Observer> observers;
    private Integer lottoNumber;
    boolean victory = false;

    // Constructor
    public LottoDraw() {
        observers = new ArrayList<Observer>();

        //this.[all sorts of stuff]
        // read docs
        
    }

    public void generateLottoNumber() throws InterruptedException {
        this.lottoNumber = ThreadLocalRandom.current().nextInt(1, 49 + 1);
        

        System.out.println("Announcing this week's winning ticket.... the number is " + this.lottoNumber + "!");

        TimeUnit.SECONDS.sleep(1);
        //updating observers with the new number information
        for (Observer observer : observers) {
            
            observer.update(this, this);
        }
    }

    //subscribes observer to the observable object 
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //removes subsriprion to the observable object for observer 
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
            System.out.println("Bob has run out of money, so he no longer plays the lottery");
        }
    }

    /**
     * @return the calloutNumber
     */
    public Integer getLottoNumber() {
        return lottoNumber;
    }

    //getter method that checks the value of victory
    public boolean checkVictoryCondition() {
        return victory;
    }

}
