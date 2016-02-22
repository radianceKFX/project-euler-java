/**
 * @author Rudolf Sneep
 * My Java Solution for Project Euler Problem 15: Lattice paths
 * 
 * https://projecteuler.net/problem=15
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * ********************** NOTE!****************************
 * This is the first version that doesn't work for bigger grids like the 20x20 grid.
 * So it can't actually solve the problem.
 * The newer version will not log all the paths, but only count them to save memory space.
 * So it can solve the problem.
 * ********************************************************
 * 
 * I will solve this by calculating each path to a certain coordinate "x:y"
 * All the paths of a certain coordinate are just the sum of all the paths of the sub branches.
 * Using a TreeMap we can automatically sort and save all the solutions.
 * At the end we retrieve all possible paths, by just retrieving the last solution in the TreeMap.
 * 
 * Parts
 * 1. Customizable Variables
 *      - you can change their values
 *      - the algorithm also works with rectangles
 * 2. Model of the Problem
 * 3. Initializing variables used in the for loops
 * 4. Start the calculation
 * 5. Print the Solution
 * 6. Methods
 */
import java.util.TreeMap;
import java.util.ArrayList;

public class Problem015SmallNumbers {
    public static void main(String[] args){

/******************* 1. Customizable Variables *******************/ 

        //Sized of nxm rectangle
        //Length and width are split, so the code will work for rectangles
        final int horizontalSide = 4;
        final int verticalSide   = 4;
        
        //Choose how the paths will bSe named
        String start = "0"; //start
        String right = "r"; //right
        String down  = "d"; //down
        
        //If the size of the rectangle is below this limit
        //Print out all the paths for the individual nodes/coordinates
        int printLimitAllNodes = 5;
        int printLimitLastNode = 8;
        
/******************** 2. Model of the Problem ********************/

    /* Example for a 2x2 sided 3x3 noded grid
        
             x:y =   [0][0] -- [0][1] -- [0][2]    -> subPathLeft
                        |         |         |       x
              y|     [1][0] -- [1][1] -- [1][2]
              \/        |         |         |
         subPathUp   [2][0] -- [2][1] -- [2][2]
    */        

/******** 3. Initializing variables used in the for loops ********/

        //a nxn sided square will have
        //(n+1)x(n+1) nodes.
        int width  = horizontalSide+1; //maxStepsRight
        int height =   verticalSide+1; //maxStepsDown
               
        //Coordinates   x:y
        int x; //goes to the right
        int y; //goes downward
        
        //Initializing the TreeMap where we store the answers
        TreeMap<String,ArrayList<String>> answers = new TreeMap<>();        
    
        //Variables used to store and change paths
        ArrayList<String> subPathsLeft = new ArrayList<String>();
        ArrayList<String> subPathsUp = new ArrayList<String>();
        ArrayList<String> subPathsLeftNew = new ArrayList<String>();
        ArrayList<String> subPathsUpNew = new ArrayList<String>();
        ArrayList<String> subPathsTotal = new ArrayList<String>();
        String renamer;
        
/******************** 4. Start the calculation ********************/

        for(x=0; x<width; x++){
            for(y=0; y<height; y++){
                //calculating the all paths for coordinate 0:0                        
                
                //Initialize the List to store the new paths for x:y
                subPathsTotal = new ArrayList<>(); //reset the ArrayList
                
                //Setup the first coordinate
                //If not setup properly, the whole TreeMap will be blank
                if(x==0 && y==0){
                    subPathsTotal.add(start);
                    answers.put(coordinateString(x,y),subPathsTotal);
                }                
                
                if(x>0){ //*if there are branches on the left*
                    //Retrieve the paths of the branch left of it (x-1,y)
                    subPathsLeftNew.clear();//reset the list
                    subPathsLeft = answers.get(coordinateString(x-1,y));            
                    //copy all their paths
                    //and add "right" to get to the current coordinate
                    for(int i=0;i<subPathsLeft.size();i++)
                    {
                        renamer = subPathsLeft.get(i).concat("-"+right);
                        subPathsLeftNew.add(renamer);        
                    }
                    subPathsTotal.addAll(subPathsLeftNew);
                    
                }
                if(y>0){//*if there are branches above,*
                    //Retrieve the paths of the branch above it in (x,y-1)
                    subPathsUpNew.clear();//reset the list
                    subPathsUp = answers.get(coordinateString(x,y-1));
                    //copy all their paths 
                    //and add "below" to get to the current coordinate
                    for(int i=0;i<subPathsUp.size();i++)
                    {
                        renamer = subPathsUp.get(i).concat("-"+down);
                        subPathsUpNew.add(renamer);        
                    }
                    subPathsTotal.addAll(subPathsUpNew);
                }   
                                             
                //Finally put the ArrayList of all the paths for x:y
                //into the 'answers' TreeMap
                answers.put(coordinateString(x,y),subPathsTotal);
                
       /***** For smaller rectangles print out the paths for each node *****/
                if(horizontalSide<printLimitAllNodes || verticalSide<printLimitAllNodes){
                    System.out.printf("%d:%d ",x,y);
                    System.out.println(subPathsTotal.toString());
                }                
            }
        }

/******************** 5. Print the Solution ********************/
        if(horizontalSide<printLimitLastNode || verticalSide<printLimitLastNode){
            System.out.println("**************All Possible Paths***************");
            System.out.println(answers.lastEntry());
        }
        System.out.println("**************Number of Possible Paths***************");
        System.out.println(answers.get(coordinateString(horizontalSide,verticalSide)).size());       
    }

/************************* 6. Methods *************************/
    
    /**
     * Converts {@code int} coordinates into a a String form,
     * so it can be more easily stored in the 'answers' TreeMap.
     * @param xInteger this {@code int} is the x coordinate
     * @param yInteger this {@code int} is the y coordinate
     * @return {@code String} of your coordinate in the format {@code x:y}
     */
    public static String coordinateString(int xInteger, int yInteger){
        return Integer.toString(xInteger)+":"+Integer.toString(yInteger);
    }

}
