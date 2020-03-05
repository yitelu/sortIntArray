
/*
 ** Author: Yi Te Lu
 **
 ** Date: March/04/2020
 **
 ** Description: sort the following int array 
 ** the test int array: int[] nums = {1,0,2,2,0,1,2};
 ** expected sort result: {0,0,1,1,2,2,2};
 **
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {

    // this is the test int array
    int[] nums = { 1, 0, 2, 2, 0, 1, 2 };

    // int array sorted and print out the outcome
    // expected sort result: {0,0,1,1,2,2,2};
    Integer[] mySortedArray = getSortArray(getMapFill(nums), nums);
    for (int a : mySortedArray) {
      System.out.print(a + " ");
    }
  }

  // this method fill the map with key and value from int array
  public static TreeMap<Integer, Integer> getMapFill(int[] nums) {

    TreeMap<Integer, Integer> myMap = new TreeMap<>();

    for (int i = 0; i < nums.length; i++) {

      if (myMap.containsKey(nums[i])) {
        myMap.put(nums[i], myMap.get(nums[i]) + 1);
      } else {
        myMap.put(nums[i], 1);
      }
    }
    return myMap;
  }

  // this method return the sorted integer array
  public static Integer[] getSortArray(Map<Integer, Integer> myMap, int[] nums) {

    ArrayList<Integer> myArrList = new ArrayList<>(nums.length);

    for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
      int temp = entry.getValue();
      while (temp > 0) {
        myArrList.add(entry.getKey());
        temp--;
      }
    }

    Integer[] myArr = new Integer[myArrList.size()];
    myArr = myArrList.toArray(myArr);
    return myArr;
  }
}
