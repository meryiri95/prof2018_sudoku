package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SudokuVerifierTest {
        private SudokuVerifier sudVer = new SudokuVerifier();

        /***
         * Test to verify if the sudoku is correct(must reply 0).
         */
	@Test
	public void testCorrectSudoku() {
             assertEquals(0, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "591264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421697"));
        }
        
        /***
         * Test to verify method to check Rule 1(must reply -1 to a sudoku with an
         * incorrect length)
         */
        @Test
	public void testRule1_1() {
            assertEquals(-1, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "591264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "58"));
        }
        /***
         * Test to verify method to check Rule 1 (must reply -1 to a sudoku with
         * one 0)
         */
        public void testRule1_2() {
            assertEquals(-1, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "591264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421690"));
        }
        
        /***
         * Test to verify method to check Rule 2(must reply -2 to a sudoku with 2 
         * repeated numbers in the same sub-grid)
         */
        @Test
	public void testRule2() {
             assertEquals(-2, sudVer.verify("138436759"+
                                            "294758163"+
                                            "756139842"+
                                            "591264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421697"));
        }
        /***
         * Test to verify method to check Rule 3(must reply -3 to a sudoku with 2
         * repeated numbers in the same global row)
         */
        @Test
	public void testRule3() {
             assertEquals(-3, sudVer.verify("138426759"+
                                            "194758263"+
                                            "756139842"+
                                            "591264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421697"));
        } 	
        /***
         * Test to verify method to check Rule 4(must reply -4 to a sudoku with 2
         * repeated numbers in the same global column)
         */
        @Test
	public void testRule4() {
            assertEquals(-4, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "195264873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421697"));
        }
}
