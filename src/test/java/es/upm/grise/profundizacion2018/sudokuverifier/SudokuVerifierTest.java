package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SudokuVerifierTest {
        private SudokuVerifier sudVer = new SudokuVerifier();
        
        /***
         * Test to verify if it replies 0 to a correct sudoku
         */
	@Test
	public void test_0() {
             assertEquals(0, sudVer.verify( "138294756"+
                                            "426758139"+
                                            "759163842"+
                                            "591437268"+
                                            "264819375"+ 
                                            "873625914"+
                                            "617942583"+ 
                                            "985376421"+
                                            "342581697"));
        }
        
        /***
         * Test to verify if it replies -1 to a sudoku with an incorrect length
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
         * Test to verify if it replies -1 to a sudoku with one 0
         */
        public void testRule1_2() {
            assertEquals(-1, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "591064873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "583421690"));
        }
        /***
         * Test to verify if it replies -1 to a sudoku with letters
         */
        public void testRule1_3() {
            assertEquals(-1, sudVer.verify("138426759"+
                                            "294758163"+
                                            "756139842"+
                                            "591064873"+
                                            "437819625"+
                                            "268375914"+
                                            "617985342"+
                                            "942376581"+
                                            "5834216aa"));
        }
        
        /***
         * Test to verify if it replies -2 to a sudoku with 2 repeated numbers in 
         * the same sub-grid
         */
        @Test
	public void testRule2() {
             assertEquals(-2, sudVer.verify("138294756"+
                                            "416758139"+
                                            "759163842"+
                                            "591437268"+
                                            "264819375"+ 
                                            "873625914"+
                                            "617942583"+ 
                                            "985376421"+
                                            "342581697"));
        }
        /***
         * Test to verify if it replies -3 to a sudoku with 2 repeated numbers in 
         * the same global row
         */
        @Test
	public void testRule3() {
             assertEquals(-3, sudVer.verify("438294756"+
                                            "126758139"+
                                            "759163842"+
                                            "591437268"+
                                            "264819375"+ 
                                            "873625914"+
                                            "617942583"+ 
                                            "985376421"+
                                            "342581697"));
        } 	
        /***
         * Test to verify if it replies -4 to a sudoku with 2 repeated numbers in 
         * the same global column
         */
        @Test
	public void test4() {
            assertEquals(-4, sudVer.verify( "831294756"+
                                            "426758139"+
                                            "759163842"+
                                            "591437268"+
                                            "264819375"+ 
                                            "873625914"+
                                            "617942583"+ 
                                            "985376421"+
                                            "342581697"));
        }
}
