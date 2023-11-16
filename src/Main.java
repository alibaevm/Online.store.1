import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[0];
        User currentUser = null;


        OuterLoop:
        while (true) {
            System.out.println("""
                    1. Register
                    2.Get all users
                    3. Login
                    4. Exit
                    choice commands: 
                    """);
            switch (scanner.nextLine().toLowerCase()) {

                case "1", "register" -> {
                    User registerUser = User.register(new User());
                    users = User.addUserToArray(users, registerUser);
                    System.out.println("Users information succesfully saved");
                }
                case "2", "get " -> {
                    System.out.println(Arrays.toString(users));
                }
                case "3", "login" -> {
                    User loginUser = User.login(users);
                    currentUser = loginUser;
                    System.out.println("Login succes! ");

                    InnerLoop:
                    while (true) {
                        System.out.println("""
                                0.Logout
                                1.Add Product
                                2.Get all Products
                                3.Get all Book
                                4.Get all Device
                                5.Delete product by id
                                6.Delete product by ids
                                choice commands : 
                                """);
                        switch (scanner.nextLine().toLowerCase()) {
                            case "0", "logout" -> {
                                break InnerLoop;

                            }
                            case "1", "add" -> {
                                System.out.println("Book or Device : ");
                                switch (scanner.nextLine().toLowerCase()) {
                                    case "book" -> {
                                        Book product = new Book();
                                        if (currentUser != null) {
                                            Product[] products = product.addNewProduct(currentUser.getProducts());
                                            currentUser.setProducts(products);
                                            System.out.println("Book added");
                                        }
                                    }
                                    case "device" -> {}
                                }

                            }
                            case "2" -> {
                                if (currentUser != null) Product.getAllProducts(currentUser.getProducts());

                            }
                            case "3", "get all book" -> {
                                new Book().getProducts(currentUser.getProducts());

                            }
                            case "4" -> {
                                new Device().getProducts(currentUser.getProducts());


                            }
                            case "5" -> {
                                System.out.println("Enter id :");
                                Product[] products = Product.deleteProduct(currentUser.getProducts(), scanner.nextLong());
                                currentUser.setProducts(products);
                                System.out.println("Succesfully deleted");
                            }
                            case "6" -> {
                                System.out.println("Enter ids :");
                                int length = scanner.nextInt();
                                long[] ids = new long[length];
                                for (int i = 0; i < length; i++) {
                                    ids[i] = scanner.nextLong();


                                }
                                Product[] newProducts = Product.deleteProduct(currentUser.getProducts(), ids);
                                currentUser.setProducts(newProducts);
                                System.out.println("Succesfully deleted");
                            }
                        }
                    }

                }
                case "4" -> {
                    break OuterLoop;
                }
            }
        }
    }
}



