package in.ashwanik.programming.backtracking;

import in.ashwanik.programming.coding.backtracking.NQueenProblem;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NQueenProblemTest {

    @Test
    public void checkValidSolution() {
        int[][] board = new int[4][4];
        NQueenProblem nQueenProblem = new NQueenProblem();
        boolean isSolved = nQueenProblem.solve(board, 4);
        assertThat(isSolved).isTrue();
    }
}
