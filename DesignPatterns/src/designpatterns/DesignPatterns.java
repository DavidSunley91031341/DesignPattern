/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.List;

/**
 *
 * @author 91031341
 */
public class DesignPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("**** Welcome to the Simple Lotto ****");
        System.out.println("Welcome...");
        
        //Creating obervable and observer objects
        LottoDraw lottery = new LottoDraw();
        Person observer1 = new Person("Tama");
        Person observer2 = new Person("Bob");
        Person observer3 = new Person("Ceasar");
        
        observer1.lottoSet.add(3);
        observer1.lottoSet.add(33);
        observer1.lottoSet.add(17);
        observer1.lottoSet.add(46);
        observer1.lottoSet.add(47);
        observer1.lottoSet.add(27);
        
        observer2.lottoSet.add(7);
        observer2.lottoSet.add(19);
        observer2.lottoSet.add(22);
        observer2.lottoSet.add(23);
        
        observer3.lottoSet.add(33);
        observer3.lottoSet.add(13);
        
        observer1.money = Double.POSITIVE_INFINITY;
        observer2.money = 8;
        observer3.money = Double.POSITIVE_INFINITY;
        
        
        //subscribing observers to the observable object that will call out the numbers
        lottery.registerObserver(observer1);
        lottery.registerObserver(observer2);
        lottery.registerObserver(observer3);
        //the object will call out the numbers until the vicrtory condition is achieved by one of the subscribed objects
        while(lottery.checkVictoryCondition() == false){
            observer2.money = observer2.money - 4;
            lottery.generateLottoNumber();
            if (observer2.money <= 0) {
                lottery.removeObserver(observer2);
            }    
            
            
        }
    }
}
