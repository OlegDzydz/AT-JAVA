public class StringOperations {
    public static void main(String[] args) {
        // 1. Declare and initialize a String variable
        String message = "Hello, Java World!";

        // 2. Use length() method
        int length = message.length();
        System.out.println("Length of the string: " + length);

        // 3. Use substring() method
        String sub = message.substring(7, 11); // from index 7 to 10
        System.out.println("Substring (7, 11): " + sub);

        // 4. Use indexOf() method
        int index = message.indexOf("Java");
        System.out.println("Index of 'Java': " + index);

        // 5. Use toUpperCase() method
        String upper = message.toUpperCase();
        System.out.println("Uppercase: " + upper);

        // 6. Use toLowerCase() method
        String lower = message.toLowerCase();
        System.out.println("Lowercase: " + lower);
    }
}
