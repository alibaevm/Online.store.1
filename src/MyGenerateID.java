public class MyGenerateID {
    private static long counter = 1;

    public static long generateId(){
        return counter++;
    }
}
