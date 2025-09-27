// TestTwoWayLinkedList.java
public class TestTwoWayLinkedList {
    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();

        list.add("America"); // Add to end
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add to beginning
        System.out.println("(2) " + list);

        list.add("Russia"); // Add to end
        System.out.println("(3) " + list);

        list.add("France"); // Add to end
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Insert at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Insert at index 5
        System.out.println("(6) " + list);

        list.add(0, "Poland"); // Insert at index 0
        System.out.println("(7) " + list);

        // Remove elements
        list.remove(0); // Remove first
        System.out.println("(8) " + list);

        list.remove(2); // Remove index 2
        System.out.println("(9) " + list);

        list.remove(list.size() - 1); // Remove last
        System.out.println("(10) " + list);
    }
}



