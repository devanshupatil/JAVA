import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

// Book class to represent a book
class Book {
    private String title;
    private String author;
    private int quantity;
    private final String id;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.id = UUID.randomUUID().toString();
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Member class to represent a library member
class Member {
    private String name;
    private String id;

    public Member(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

// Library class to manage books
class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public boolean issueBook(String title) {
        Book book = findBook(title);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            return true;
        }
        return false;
    }
}

// Librarian class to manage library operations
class Librarian {
    private Library library;
    private List<Member> members = new ArrayList<>();

    public Librarian(Library library) {
        this.library = library;
    }

    public void displayAvailableBooks() {
        System.out.println("\n------ Available Books ------");
        for (Book book : library.getAllBooks()) {
            System.out.println(
                    "Title: " + book.getTitle() + ",\t Quantity: " + book.getQuantity() + ",\t ID: " + book.getId());
        }
        System.out.println("-----------------------------\n");
    }

    public void issueBook(Member member, String bookTitle) {
        if (library.issueBook(bookTitle)) {
            System.out.println("Book '" + bookTitle + "' successfully issued to " + member.getName());
        } else {
            System.out.println("Book '" + bookTitle + "' is not available!");
        }
    }

    public void returnBook(Member member, String bookTitle) {
        if (library.returnBook(bookTitle)) {
            System.out.println("Book '" + bookTitle + "' successfully returned by " + member.getName());
        } else {
            System.out.println("Invalid book return attempt!");
        }
    }

    public void addNewBook(String title, String author, int quantity) {
        Book newBook = new Book(title, author, quantity);
        library.addBook(newBook);
        System.out.println("New book added: " + title);
    }

    public Member registerMember(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
}

// UserInterface class to handle user interaction
class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Librarian librarian;

    public UserInterface(Librarian librarian) {
        this.librarian = librarian;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            processUserChoice(choice);
            if (choice == 6)
                break;
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Display Available Books");
        System.out.println("2. Issue a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Add New Book");
        System.out.println("5. Register New Member");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void processUserChoice(int choice) {
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                librarian.displayAvailableBooks();
                break;
            case 2:
                issueBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                addNewBook();
                break;
            case 5:
                registerNewMember();
                break;
            case 6:
                System.out.println("\nThank you for using the Library Management System!\n");
                break;
            default:
                System.out.println("\nInvalid choice. Please try again.");
        }
    }

    private void issueBook() {
        System.out.println("");
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        Member member = new Member(memberName);
        librarian.issueBook(member, bookTitle);
    }

    private void returnBook() {
        System.out.println("");
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        Member member = new Member(memberName);
        librarian.returnBook(member, bookTitle);
    }

    private void addNewBook() {
        System.out.println("");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        librarian.addNewBook(title, author, quantity);
    }

    private void registerNewMember() {
        System.out.println("");
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        Member newMember = librarian.registerMember(name);
        System.out.println("New member registered: " + newMember.getName() + " (ID: " + newMember.getId() + ")");
    }
}

// Main class
public class Library_Management_System {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        UserInterface ui = new UserInterface(librarian);

        // Add some initial books
        librarian.addNewBook("The Great Gatsby", "F. Scott Fitzgerald", 2);
        librarian.addNewBook("To Kill a Mockingbird", "Harper Lee", 3);
        librarian.addNewBook("1984", "George Orwell", 4);
        librarian.addNewBook("Pride and Prejudice", "Jane Auste", 5);
        librarian.addNewBook("Wuthering Heights", "Emily Brontë ", 9);
        librarian.addNewBook("The guide", "R K Narayan ", 5);
        librarian.addNewBook("The Post Office", "R K Narayan ", 7);

        ui.start();
    }
}