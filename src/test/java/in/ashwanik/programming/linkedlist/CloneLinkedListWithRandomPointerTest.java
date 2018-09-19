package in.ashwanik.programming.linkedlist;

import in.ashwanik.programming.coding.linkedlist.CloneLinkedListWithRandomPointer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloneLinkedListWithRandomPointerTest {
    private CloneLinkedListWithRandomPointer cloneLinkedListWithRandomPointer;

    @Before
    public void setup() {
        cloneLinkedListWithRandomPointer = new CloneLinkedListWithRandomPointer();
    }


    @Test
    public void testClonedWithSingleNode() {
        CloneLinkedListWithRandomPointer.Node head = new CloneLinkedListWithRandomPointer.Node(5);
        assertThat(head).isNotEqualTo(cloneLinkedListWithRandomPointer.cloned(head));
    }

    @Test
    public void testClonedWithMultipleNode() {
        CloneLinkedListWithRandomPointer.Node head = new CloneLinkedListWithRandomPointer.Node(5);
        CloneLinkedListWithRandomPointer.Node next1 = new CloneLinkedListWithRandomPointer.Node(6);
        CloneLinkedListWithRandomPointer.Node next2 = new CloneLinkedListWithRandomPointer.Node(3);

        head.next = next1;
        head.random = next2;

        next1.next = next2;
        next1.random = head;

        CloneLinkedListWithRandomPointer.Node cloned = cloneLinkedListWithRandomPointer.cloned(head);
        CloneLinkedListWithRandomPointer.Node current = head;
        CloneLinkedListWithRandomPointer.Node clonedCurrent = cloned;

        while (current != null) {
            assertThat(current).isNotEqualTo(clonedCurrent);
            assertThat(current.data).isEqualTo(clonedCurrent.data);
            current = current.next;
            clonedCurrent = clonedCurrent.next;
        }
    }
}
