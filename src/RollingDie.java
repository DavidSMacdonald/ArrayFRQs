/* A statistician is studying sequences of numbers obtained by repeatedly tossing a 6-sided die.  
The statistician is particularly interested in runs of numbers.  A run occurs when 2 or more
consecutive tosses of the die produce the same value.  For example, in the following sequence of
die rolls, there are runs starting at positions 1,6,11,and 13.

Index:	0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17
Result: 1  5  5  4  3  1  2  2  2  6  1  3  3  5  5  5  5  5

The die is represented by the following class:
*/

import java.util.Arrays;

public class RollingDie {
    /** @return an integer value between 1 and 6
     */
    public int toss()
    {
        return (int)(6 * Math.random()) + 1;
    }
	
	/* Write the method getRolls that takes a number of tosses as a parameter.  The method
	should return an array of values produced by rolling the die the given number of times.
	*/

    /** Returns an array of the values obtained by tossing the die numTosses times.
     *  @param numTosses the number of die tosses
     *			Precondition: numTosses >0
     *	@return an array of numTosses values
     */
    public int[] getRolls(int numTosses)
    {
        int[] result = new int[numTosses];
        for (int i = 0; i < numTosses; i++) {
            result[i] = toss();
        }
        return result;  // replace this
    }
	
	/*Write the method getBestRun that takes as its parameter a array of integer values 
	representing a series of die tosses.  The method returns the starting index in the array 
	of a run of maximum size.  A run is defined as the repeated occurrence of the same value 
	in 2 or more consecutive positions in the array.  If there are 2 runs of the same size
	it may return either index.  If there are no runs, the method returns -1.
	Precondition:  values.length > 0
	*/

    public static int getBestRun(int[] values)
    {
        int max = 1;
        int ind = -1;
        for (int i = 0; i < values.length - 1; i++) {
            int j = 1;
            while (i+j<values.length && values[i]==values[i+j]) {
                j++;
            }
            if (max<j) {
                max = j;
                ind = i;
            }
        }
        return ind;  //replace this
    }


    public static void main(String[] args) {
        RollingDie nc = new RollingDie();

//        int[] test = new int[6];
//        for (int i = 0; i < test.length; i++) {
//            test[i] = i;
//        }
//        test[5] = 4;
//        System.out.println(Arrays.toString(test));
//        System.out.println(getBestRun(test));

        for (int p = 0; p < 10; p++) {
            int[] tossArr = nc.getRolls(20);
            for (int i = 0; i < 20; i++)
                System.out.print(tossArr[i] + ",");
            System.out.println();

            int x = nc.getBestRun(tossArr);
            System.out.println(x);
        }
    }

}

/** OUTPUT
 *
 * 2,4,1,5,2,2,2,3,3,3,1,6,5,2,3,1,5,5,2,4,
 * 4
 * 5,4,4,4,5,3,6,3,2,1,3,2,5,2,3,1,5,2,5,5,
 * 1
 * 4,2,1,3,6,6,1,6,4,1,3,4,1,5,2,3,5,3,4,4,
 * 4
 * 5,5,2,1,6,3,2,2,6,2,4,4,2,2,3,3,2,4,5,5,
 * 0
 * 5,5,4,3,4,6,6,1,4,5,6,1,2,6,5,5,2,4,4,4,
 * 17
 * 2,5,1,2,6,4,2,1,4,6,2,3,5,5,3,5,3,4,4,5,
 * 12
 * 6,6,4,2,4,4,5,1,4,6,6,4,3,2,4,1,1,6,2,6,
 * 0
 * 4,4,3,3,5,2,1,3,5,4,4,5,2,5,6,3,1,6,2,6,
 * 0
 * 4,1,6,4,3,3,6,3,3,6,5,4,2,2,1,2,5,1,6,4,
 * 4
 * 1,3,4,6,4,3,2,2,3,1,5,6,4,5,1,6,5,4,6,3,
 * 6
 *
 *
 */