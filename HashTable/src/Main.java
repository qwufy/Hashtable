import java.util.Random;

public class Main {
    public static void main(String[] args) {
        myHashTable<Hashtabletest, Student> table = new myHashTable<>();

        Random random = new Random();
        for(int i = 0; i<10000; i++) {
            Hashtabletest key = new Hashtabletest(random.nextInt(100), "name" + i);
            Student value = new Student("student" + i);
            table.put(key, value);
        }
        table.printBucketSizes();
    }
}
