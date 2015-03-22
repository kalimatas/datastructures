package array;

public class ArrayApp {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3,};

        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("%d ", intArray[i]);
        }

        System.out.println();

        HighArray highArray = new HighArray(10);
        highArray.insert(2);
        highArray.insert(4);
        highArray.insert(5);
        highArray.insert(8);
        highArray.insert(10);

        highArray.display();
        if (highArray.find(4) != -1) {
            System.out.println("found 4");
        }

        highArray.delete(10);
        highArray.display();

        System.out.println("Ordered array");
        OrderedArray orderedArray = new OrderedArray(10);
        orderedArray.insert(8);
        orderedArray.insert(4);
        orderedArray.insert(22);
        orderedArray.insert(16);
        orderedArray.insert(1);

        orderedArray.display();

        if (orderedArray.find(16) != orderedArray.size()) {
            System.out.println("found 16");
        }

        orderedArray.delete(4);
        orderedArray.display();
    }
}
