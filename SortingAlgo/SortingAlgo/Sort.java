/*

Assignment #1 - Part 3
Owen Reid - 100694494
Due Date: October 11, 2020
Course: CSCI3070U Analysis and Design of Algorithms
Instructor: Kourosh Davoudi

Class Description:

This class involves the function binsearch which recursivly solves the problem outlined in assignment #1 part 3.
I solved this problem using a modified binary search, which is O(logn) in the worst case scenario.

*/

public class Sort {

    /*

    Function details

    Inputs... 
    somearray (any array of type int)
    bottomindex (the first index of the array - type int)
    topindex (the last index of the array - type int)
    tofind (the value we are searching for - type int)

    Outputs...
    Function completes recursivly until it finds the value specified 
    by 'tofind' then prints the index of the 'tofind' value.

    Process...
    The way I solved the problem outlined in the question was first thinking of
    which search functions can find values in O(logn) time. Binary search was 
    the immediate choice. The problem was that binary search must use an already
    sorted array to work. I worked it out by noticing that no matter what value k
    is (ie. how many times the array values were shifted) both sides of the middle index
    will be sorted. This worked well for binary search since it is a 'divide and conquer'
    type of algorithm where we take both sides of the middle index and search each of them.
    I wrote binsearch recursivly to save time and so that I could acomplish the task in only
    one function.

    */

    public static int binsearch(int[] somearray, int bottomindex, int topindex, int tofind) {

        // Quits the recursive call when there is nothing left to search
        // Nothing will print to terminal if the value is not in the array
        if (bottomindex > topindex) {
            return -1;
        }

        int middleindex = (bottomindex + topindex) / 2;

        if (somearray[middleindex] == tofind) {
            System.out.println(somearray[middleindex] + " Found at index: " + middleindex);
        }

        // This will run if the left subarray is sorted
        if (somearray[middleindex] >= somearray[bottomindex]) {
            
            // Below is basically regular binary search, will keep splitting array until tofind value is found
            if (tofind >= somearray[bottomindex] && tofind <= somearray[middleindex]) {
                return binsearch(somearray, bottomindex, middleindex - 1, tofind);
            }

            return binsearch(somearray, middleindex + 1, topindex, tofind);
        }
        // This will run if the right subarray is sorted
        if (tofind >= somearray[middleindex] && tofind <= somearray[topindex]) {
            return binsearch(somearray, middleindex + 1, topindex, tofind);
        }

        return binsearch(somearray, bottomindex, middleindex - 1, tofind);
    }

    // Driver code to test
    public static void main(String[] args) {
        int[] testarray = {9, 11, 1, 3, 5, 6, 7, 8};
        binsearch(testarray, 0, testarray.length - 1, 7);
        binsearch(testarray, 0, testarray.length - 1, 5);
        binsearch(testarray, 0, testarray.length - 1, 11);

        int[] secondtestarray = { 17, 24, 27, 30, 2, 6, 11, 13, 15 };
        binsearch(secondtestarray, 0, secondtestarray.length - 1, 24);
        binsearch(secondtestarray, 0, secondtestarray.length - 1, 2);
        binsearch(secondtestarray, 0, secondtestarray.length - 1, 6);
    }
}