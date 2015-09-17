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
 * This class provides the implementation of Greedy fractional knapsack. It acts as a TreeSet  
 * and provides all the methods provided by TreeSet.
 * @param E Element inserted into the knapsack of type KnapsackItem
 * @see KnapsackItem
 * @see TreeSet
 * @author hanu
 */
public class Knapsack<E extends KnapsackItem> extends TreeSet<E> {

    private double profit;
    /**
     * Creates a Knapsack with given item and this item will be used as Comparator for the TreeSet.
     * @see java.util.Comparator
     * @see TreeSet
     * @param item item to be inserted
     */
    public Knapsack(E item) {
        super(item);
        add(item);
        profit=0;
    }
    
    /**
     * Solves the fractional knapsack problem with the item inserted and provided capacity of the knapsack
     * @param capacity total capacity of the knapsack
     * @return  Hashmap of items as keys and their fractions in the final knapsack.
     * @see HashMap
     */
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

    /**
     * Give the total profit earned in the knapsack with the last provided capacity
     * @return total profit
     */
    public double getProfit() {
        return profit;
    }
    
    
}
