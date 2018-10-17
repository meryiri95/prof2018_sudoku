package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SudokuVerifier 
{
        private int sudoku[][];
        private ArrayList<Integer> listNums;
    
    public  SudokuVerifier(){
        
        sudoku = new int[9][9]; 
        listNums = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        
    }
    public int verify (String candidateSolution){
        try{
            checkRule1(candidateSolution);
        }
        catch(Exception ex){
            return -1;
        }     
        try{
            checkRule2();
        }
        catch(Exception Ex){
            return -2;
        }  
        try{
            checkRule3();
        }
        catch(Exception Ex){
            return -3;
        }      
        try{
            checkRule4();
        }
        catch(Exception Ex){
            return -4;
        }
        return 0;
    }
    /***
    * Method to check Rule 1: A cell in a Sudoku game can only store positive digits, i.e. 1…9.
    */
    private void checkRule1(String candidateSolution) throws Exception {
        if (candidateSolution.length()==81){
            int aux,cont=0;
            for (int iGridActual=0;iGridActual<9;iGridActual++){
                for (int jGridActual=0;jGridActual<9;jGridActual++){ 
                    aux = Integer.parseInt(Character.toString(candidateSolution.charAt(cont)));
                    if (aux!=0)
                        sudoku[iGridActual][jGridActual]=aux;
                    else
                        throw new Exception("One of the numbers is 0.");
                    cont++;
                }
            }
        }
        else{
            throw new Exception("Incorrect number of numbers in sudoku.");
        }
    }

    /***
    * Method to check Rule 2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
    */
    private void checkRule2() throws Exception{
        ArrayList<Integer> sortedSubgrid = new ArrayList<Integer>();
        
        for (int iGridActual=0;iGridActual<3;iGridActual++){
            for (int jGridActual=0;jGridActual<3;jGridActual++){
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){   
                        sortedSubgrid.add(sudoku[iGridActual*3+i][jGridActual*3+j]);
                    }
                }
                Collections.sort(sortedSubgrid);
                if (!sortedSubgrid.equals(listNums))
                    throw new Exception("There is a repeated number in a sub-grid.");
                else 
                    sortedSubgrid.clear();
            }
            
        }
        
        
    }
    
    /***
    * Method to check Rule 3: A digit can appear only once in the rows of the global grid.
    */
    private void checkRule3() throws Exception{
        ArrayList<Integer> sortedSubgrid = new ArrayList<Integer>();
        
        for (int numRow=0;numRow<9;numRow++){
            for (int j=0;j<9;j++){
                sortedSubgrid.add(sudoku[numRow][j]);                
            } 
            Collections.sort(sortedSubgrid);
            if (!sortedSubgrid.equals(listNums))
                throw new Exception("There is a repeated number in a row.");
            else 
                sortedSubgrid.clear();
            
            
        }
    }
    
    /***
    * Method to check Rule 4: A digit can appear only once in the columns of the global grid.
    */
     private void checkRule4() throws Exception{
        ArrayList<Integer> sortedSubgrid = new ArrayList<Integer>();
        
        for (int numCol=0;numCol<9;numCol++){
            for (int i=0;i<9;i++){
                sortedSubgrid.add(sudoku[i][numCol]);                
            }
            Collections.sort(sortedSubgrid);
            if (!sortedSubgrid.equals(listNums))
                throw new Exception("There is a repeated number in a column.");
            else 
                sortedSubgrid.clear();
            
            
        }
    }
}
