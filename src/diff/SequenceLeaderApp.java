package diff;

public class SequenceLeaderApp {
    public static void main(String[] args) {
        int leader = leader(new int[]{4,6,6,6,6,8,8});
        if (leader != -1)
            System.out.println("leader is " + leader);
        else
            System.out.println("no leader");
    }

    private static int leader(int[] A) {
        int leader = -1;
        int size = 0, value = -1;

        for (int i : A) {
            if (size == 0) {
                value = i;
                size++;
            } else {
                if (i == value)
                    size++;
                else
                    size--;
            }
        }

        if (size <= 0) return leader;

        int count = 0;
        for (int i : A) if (i == value) count++;

        if (count > A.length / 2)
            leader = value;

        return leader;
    }
}
