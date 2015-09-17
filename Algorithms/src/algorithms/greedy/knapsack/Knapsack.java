/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy.knapsack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author hanu
 */
public class Knapsack<E extends KnapsackItem> extends TreeSet<E> {

    private double profit;
    public Knapsack(E item) {
        super(item);
        add(item);
        profit=0;
    }
    
    public HashMap<E,Double> Solve(double capacity)
    {
        profit=0;
        E item;
        Iterator<E> it=iterator();
        HashMap<E,Double> solution=new HashMap<>(size());
        while(capacity!=0.0&&it.hasNext())
        {
            item=it.next();
            if(item.getWeight()<=capacity)
            {
            solution.put(item,1.0);    
            capacity-=item.getWeight();
            profit+=item.getProfit();
            }
            else
            {
                solution.put(item,capacity/item.getWeight());
                profit+=item.getProfit()*capacity/item.getWeight();
                capacity=0;
            }
            
        }
        while(it.hasNext())
        {
            solution.put(it.next(),0.0);
        }
        return solution;
    }

    public double getProfit() {
        return profit;
    }
    
    
}
