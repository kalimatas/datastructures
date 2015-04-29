package hashtable;

public class HashTableApp {
    public static void main(String[] args) {
        HashTableOALinear htOALiner = new HashTableOALinear(30);

        htOALiner.insert(new DataItem(7));
        htOALiner.insert(new DataItem(8));
        htOALiner.insert(new DataItem(37));

        htOALiner.display();

        DataItem found = htOALiner.find(37);
        if (found != null) System.out.printf("Found: %d\n", found.getKey());

        htOALiner.delete(37);
        htOALiner.display();
        htOALiner.insert(new DataItem(37));
        htOALiner.display();

        System.out.println();

        HashTableOADoubleHashing htOADouble = new HashTableOADoubleHashing(30);
        htOADouble.insert(new DataItem(7));
        htOADouble.insert(new DataItem(8));
        htOADouble.insert(new DataItem(37));
        htOADouble.insert(new DataItem(67));

        htOADouble.display();
    }
}
