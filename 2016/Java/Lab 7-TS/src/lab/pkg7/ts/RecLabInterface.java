/**
 * AUCSC 112 Lab
 * Interface required
 * by Rosanna Heise
 * March 15, 2016
 *
 * Main goals:  use recursion and interfaces
 *
 */

package lab.pkg7.ts;

/**
 * Interface intended for teaching purposes only.
 *
 * @author rosanna
 */
public interface RecLabInterface {

    /**
     * This method prints a triangle, using standard output, of the given size,
     * out of asterisks.  Note that the "." is used to be a visible space.
     * E.g. if size is 3, it will print:
     *      ..*
     *      .* *
     *      * * *
     * @param size -- the number of lines in the triangle
     */
    public void printTriangle(int size);

    /**
     * This method will actually change the contents of anArray, so that all
     * odd integers preceed all even integers in the array.  Note that the
     * order of the integers may not be maintained.  All swapping of elements
     * is done "in place" so that minimal extra space is used.
     *
     * @param anArray -- the array that will change so that all odds come
     *                   before all evens
     */
    public void oddBeforeEven(int[] anArray);



}