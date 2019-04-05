/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 91031341
 */
public class Person implements Observer {

    private final String personName;
    
    ArrayList<Integer> lottoSet = new ArrayList<Integer>();
    
    private LottoDraw lottoDraw;
    
    double money;
    
    static boolean play = true;
    


    // constructor
    public Person(String pName) {

        personName = pName;
        System.out.println(personName);

    }
    
    public String getName() {
        return personName;
    }


//    public void addNumber(int num) {
//        
//    }


    @Override
    public void update(Observable o, Object o1) {
        // what are the inputs Observable o, Object o1?
        // what can they be used for
        // redd docs
        
        
        
        lottoDraw = (LottoDraw) o;

        for (int num : lottoSet) {
            if (num == lottoDraw.getLottoNumber()) {
            System.out.println("****** WINNER ******\nCongratulations " + personName + "\nYou have won");
            this.lottoDraw.victory = true;  
            }
        }

    }
}
