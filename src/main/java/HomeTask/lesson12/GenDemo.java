package HomeTask.lesson12;

public class GenDemo {
    public static void main(String[] args) {
        String[] array = new String[2];

        GenArray<String> genArray = new GenArray<String>(array);
        genArray.set(1, "test");
        System.out.println(genArray.get(1));

    }
}
