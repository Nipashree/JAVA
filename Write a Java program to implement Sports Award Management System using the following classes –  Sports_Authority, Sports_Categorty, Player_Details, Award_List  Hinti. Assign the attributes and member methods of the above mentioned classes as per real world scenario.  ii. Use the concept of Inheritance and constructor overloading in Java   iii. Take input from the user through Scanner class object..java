import java.util.Scanner;

// Base class
class Sports_Authority {
    String authorityName;
    String location;

    // Constructor
    Sports_Authority(String authorityName, String location) {
        this.authorityName = authorityName;
        this.location = location;
    }

    void displayAuthorityDetails() {
        System.out.println("Sports Authority: " + authorityName);
        System.out.println("Location: " + location);
    }
}

// Derived class
class Sports_Category extends Sports_Authority {
    String categoryName;
    String categoryType;

    // Constructor overloading
    Sports_Category(String authorityName, String location, String categoryName) {
        super(authorityName, location);
        this.categoryName = categoryName;
    }

    Sports_Category(String authorityName, String location, String categoryName, String categoryType) {
        super(authorityName, location);
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    void displayCategoryDetails() {
        System.out.println("Sports Category: " + categoryName);
        if (categoryType != null) {
            System.out.println("Category Type: " + categoryType);
        }
    }
}

// Derived class
class Player_Details extends Sports_Category {
    String playerName;
    int playerAge;

    // Constructor
    Player_Details(String authorityName, String location, String categoryName, String categoryType, String playerName, int playerAge) {
        super(authorityName, location, categoryName, categoryType);
        this.playerName = playerName;
        this.playerAge = playerAge;
    }

    void displayPlayerDetails() {
        System.out.println("Player Name: " + playerName);
        System.out.println("Player Age: " + playerAge);
    }
}

// Derived class
class Award_List extends Player_Details {
    String awardName;

    // Constructor
    Award_List(String authorityName, String location, String categoryName, String categoryType, String playerName, int playerAge, String awardName) {
        super(authorityName, location, categoryName, categoryType, playerName, playerAge);
        this.awardName = awardName;
    }

    void displayAwardDetails() {
        System.out.println("Award Name: " + awardName);
    }
}

// Main class
public class SportsAwardManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter Sports Authority Name: ");
        String authorityName = scanner.nextLine();

        System.out.print("Enter Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Sports Category Name: ");
        String categoryName = scanner.nextLine();

        System.out.print("Enter Category Type: ");
        String categoryType = scanner.nextLine();

        System.out.print("Enter Player Name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter Player Age: ");
        int playerAge = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Award Name: ");
        String awardName = scanner.nextLine();

        // Creating an object of Award_List (inherits all other classes)
        Award_List award = new Award_List(authorityName, location, categoryName, categoryType, playerName, playerAge, awardName);

        // Displaying details
        System.out.println("\n--- Sports Award Management System ---");
        award.displayAuthorityDetails();
        award.displayCategoryDetails();
        award.displayPlayerDetails();
        award.displayAwardDetails();

        scanner.close();
    }
}
