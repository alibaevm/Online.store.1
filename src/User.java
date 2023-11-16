import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String firsName;
    private String lastName;
    private String email;
    private String password;
    private  Product[] products = new Product[0];

    public User() {
    }

    public User(String firsName, String lastName, String email, String password, Product[] products) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = products;
    }

    public static User[]  addUserToArray(User[] users, User registerUser) {
        User[] newArray = Arrays.copyOf(users, users.length + 1 );
        newArray[newArray.length - 1 ] = registerUser;
        return newArray;
    }

    public static User login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email :");
        String email = scanner.nextLine();
        System.out.println("Enter your password : ");
        String password = scanner.nextLine();

        for (User user : users) {
            if ((user.getEmail().equals(email) && user.getPassword().equals(password))){
                return user;
            }

        }
        return null;
    }


    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public static User  register(User newUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first Name: ");
        newUser.setFirsName(scanner.nextLine());
        System.out.println("Enter Last Name :");
        newUser.setLastName(scanner.nextLine());
        System.out.println("Enter email : ");
        newUser.setEmail(scanner.nextLine());
        System.out.println("Enter password : ");
        newUser.setPassword(scanner.nextLine());
        return newUser;

    }

    @Override
    public String toString() {
        return "User{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
