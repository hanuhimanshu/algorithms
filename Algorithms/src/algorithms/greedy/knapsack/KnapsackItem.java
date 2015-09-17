/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy.knapsack;

import java.util.Comparator;

/**
 * This class works as Item for knapsack problem. It also provide default Comparator which compares
 *  on the basis of profit to weight ratio.
 * @see Comparator
 * @author hanu
 */
public interface KnapsackItem extends Comparator<KnapsackItem> {
        public double getProfit();
        public double getWeight();
/**
 * default compare on the basis of profit to weight ratio.
 * @param o1 first knapsack item
 * @param o2 second knapsack item
 * @return 
 */
    @Override
    public default int compare(KnapsackItem o1, KnapsackItem o2) {
        double ratio_o1=o1.getProfit()/o1.getWeight(),ratio_o2=o2.getProfit()/o2.getWeight();
        if(ratio_o1==ratio_o2)return 0;
        else if(ratio_o1<ratio_o2)return 1;
        else return -1;
    }
        
}
