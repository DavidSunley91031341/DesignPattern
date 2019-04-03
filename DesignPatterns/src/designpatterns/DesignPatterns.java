/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

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
        LottoDraw observable = new LottoDraw();
        Person observer1 = new Person("Tama", lottoSet);
        Person observer2 = new Person("Bob", lottoSet);
        Person observer3 = new Person("Ceasar", lottoSet);
        
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
        
        
        //subscribing observers to the observable object that will call out the numbers
        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);
        //the object will call out the numbers until the vicrtory condition is achieved by one of the subscribed objects
        while(observable.checkVictoryCondition() == false){
            observable.generateLottoNumber(); 
        }
    }
}
