package in.ashwanik.programming.ds;

import in.ashwanik.programming.coding.ds.QuadTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuadTreeTest {
    @Test
    public void testQuadTree() {
        QuadTree quadTree = new QuadTree(new QuadTree.Rectangle(2, 2, 10, 10), 4);
        quadTree.insert(new QuadTree.Point(4, 4));
        quadTree.insert(new QuadTree.Point(4, 5));
        quadTree.insert(new QuadTree.Point(4.2, 5.1));
        quadTree.insert(new QuadTree.Point(4.1, 4.2));
        quadTree.insert(new QuadTree.Point(4.1, 4.3));
        assertThat(quadTree.getPoints().size()).isEqualTo(4);
        List<QuadTree.Point> points = new ArrayList<>();
        quadTree.query(new QuadTree.Rectangle(7, 7, 5, 5), points);
        assertThat(points.size()).isEqualTo(5);
    }
}
