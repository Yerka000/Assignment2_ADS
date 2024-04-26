import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList<String> myArrayList = new MyArrayList<>();

        // Add elements
        myArrayList.add("Apple");
        myArrayList.add("Banana");
        myArrayList.add("Cherry");
        System.out.println("After adding elements: " + arrayToString(myArrayList));

        // Add elements at specific positions
        myArrayList.add(1, "Blueberry");
        System.out.println("After adding at index 1: " + arrayToString(myArrayList));

        // Get elements
        System.out.println("First element: " + myArrayList.getFirst());
        System.out.println("Last element: " + myArrayList.getLast());
        System.out.println("Element at index 2: " + myArrayList.get(2));

        // Set elements
        myArrayList.set(1, "Blackberry");
        System.out.println("After setting at index 1: " + arrayToString(myArrayList));
        // Remove elements
        myArrayList.removeFirst();
        System.out.println("After removing first element: " + arrayToString(myArrayList));
        myArrayList.removeLast();
        System.out.println("After removing last element: " + arrayToString(myArrayList));

        // Index and search
        System.out.println("Index of 'Cherry': " + myArrayList.indexOf("Cherry"));
        System.out.println("Does 'Banana' exist? " + myArrayList.exists("Banana"));

        // Iterating with an Iterator
        Iterator<String> iterator = myArrayList.iterator();
        System.out.print("Iterating through list: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Sorting the list (for simplicity, using Java's built-in Arrays.sort with a Comparator)
        myArrayList.add("Orange");
        myArrayList.add("Grapes");
        myArrayList.sort(new AlphabeticalComparator());
        System.out.println("After sorting alphabetically: " + arrayToString(myArrayList));

        // Clear the list
        myArrayList.clear();
        System.out.println("After clearing the list: " + arrayToString(myArrayList));
    }

    private static String arrayToString(MyList<?> list) {
        StringBuilder sb = new StringBuilder("[");
        for (Object item : list) {
            sb.append(item).append(", ");
        }
        if (list.size() > 0) {
            sb.delete(sb.length() - 2, sb.length()); // Remove trailing ", "
        }
        sb.append("]");
        return sb.toString();
    }

    private static class AlphabeticalComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
}
