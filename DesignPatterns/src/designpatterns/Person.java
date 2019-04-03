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
    


    // constructor
    public Person(String pName, List<Integer> lottoSet) {

        personName = pName;
        lottoSet = LottoSet();
        System.out.println(personName);
        

    }


//    public void addNumber(int num) {
//        
//    }
    
    private ArrayList<Integer> LottoSet(){
        return LottoSet();
    }

    @Override
    public void update(Observable o, Object o1) {
        this.lottoDraw = (LottoDraw) lottoDraw;

        for (int num : lottoSet) {
            if (num == this.lottoDraw.getLottoNumber()) {
            System.out.println("****** WINNER ******\nCongratulations " + personName + "\nYou have won");
            this.lottoDraw.victory = true;  
            }
        }

    }
}
