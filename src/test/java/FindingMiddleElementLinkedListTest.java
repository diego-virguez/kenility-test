import static org.junit.jupiter.api.Assertions.assertEquals;

import com.challenge2.FindingMiddleElementLinkedList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FindingMiddleElementLinkedListTest {

  @Test
  public void testFindMiddleNode_odd_listLength_case() throws Exception {
    FindingMiddleElementLinkedList linkedList = new FindingMiddleElementLinkedList();
    FindingMiddleElementLinkedList.Node node1 = new FindingMiddleElementLinkedList.Node(1);
    FindingMiddleElementLinkedList.Node node2 = new FindingMiddleElementLinkedList.Node(2);
    FindingMiddleElementLinkedList.Node node3 = new FindingMiddleElementLinkedList.Node(3);
    FindingMiddleElementLinkedList.Node node4 = new FindingMiddleElementLinkedList.Node(4);
    FindingMiddleElementLinkedList.Node node5 = new FindingMiddleElementLinkedList.Node(5);
    FindingMiddleElementLinkedList.Node node6 = new FindingMiddleElementLinkedList.Node(6);
    FindingMiddleElementLinkedList.Node node7 = new FindingMiddleElementLinkedList.Node(7);
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    linkedList.setStart(node1);
    // Find middle element.
    FindingMiddleElementLinkedList.Node middleNode = linkedList.findMiddleNode();
    linkedList.printList();
    log.info("Output: {}", middleNode.getValue());
    assertEquals(4, middleNode.getValue());
  }

  @Test
  public void testFindMiddleNode_even_listLength_case() throws Exception {
    FindingMiddleElementLinkedList linkedList = new FindingMiddleElementLinkedList();
    FindingMiddleElementLinkedList.Node node1 = new FindingMiddleElementLinkedList.Node(1);
    FindingMiddleElementLinkedList.Node node2 = new FindingMiddleElementLinkedList.Node(2);
    FindingMiddleElementLinkedList.Node node3 = new FindingMiddleElementLinkedList.Node(3);
    FindingMiddleElementLinkedList.Node node4 = new FindingMiddleElementLinkedList.Node(4);
    FindingMiddleElementLinkedList.Node node5 = new FindingMiddleElementLinkedList.Node(5);
    FindingMiddleElementLinkedList.Node node6 = new FindingMiddleElementLinkedList.Node(6);
    FindingMiddleElementLinkedList.Node node7 = new FindingMiddleElementLinkedList.Node(7);
    FindingMiddleElementLinkedList.Node node8 = new FindingMiddleElementLinkedList.Node(8);
    FindingMiddleElementLinkedList.Node node9 = new FindingMiddleElementLinkedList.Node(9);
    FindingMiddleElementLinkedList.Node node10 = new FindingMiddleElementLinkedList.Node(10);
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    node7.setNext(node8);
    node8.setNext(node9);
    node9.setNext(node10);
    linkedList.setStart(node1);
    // Find middle element.
    FindingMiddleElementLinkedList.Node middleNode = linkedList.findMiddleNode();
    linkedList.printList();
    log.info("Output: {}", middleNode.getValue());
    assertEquals(5, middleNode.getValue());
  }
}
