# Lab1

1. Create an interface ProductOperations with methods addProduct(Product product), removeProduct(Product product), and findProductByName(String name).
2. Create an abstract class Product with attributes: name, price, rating.
3. Create Book and VideoGame classes inheriting from Product.
4. Create a Warehouse class implementing ProductOperations, which stores a list of products.


<details>
  <summary>Solution Hint!</summary>
  <p>

```java
public interface ProductOperations {
    void addProduct(Product product);
    void removeProduct(Product product);
    Product findProductByName(String name);
}
public abstract class Product {
    private String name;
    private double price;
    private double rating;

    // Constructor, getters, and setters
}
public class Book extends Product {
    // Specific implementation for a book
}

public class VideoGame extends Product {
    // Specific implementation for a video game
}
public class Warehouse implements ProductOperations {
    private List<Product> products = new ArrayList<>();

    // Implementation of interface methods
}


  ```
  </p>
  </details>

# Lab 2


Task: Hotel Room Reservation System
Task Description:
You are designing a system to manage hotel room reservations. The system should facilitate the management of rooms, clients, and reservations.

Features and Methods:
Room Management
<p>
  
    
<br>```addRoom(int roomNumber, String type, double price)```: Add a new room to the system.</br>
<br>```removeRoom(int roomNumber)```: Remove a room from the system.</br>
<br>```updateRoomDetails(int roomNumber, String type, double price)```: Update the details of a room.</br>
<br>```findRoom(int roomNumber)```: Find a room by its number.</br>
<br>```findRoomsByType(String type)```: Find rooms by their type.</br>
<br>```findRoomsInPriceRange(double minPrice, double maxPrice)```: Find rooms within a specific price range.</br>

</p>
<p>

Client Management
<br>```addClient(String firstName, String lastName, String id)```: Register a new client.</br>
<br>```updateClientInfo(String id, String newFirstName, String newLastName)```: Update client information.</br>
<br>```findClient(String id)```: Find a client by their ID.</br>
</p>
<p>
  
Reservation Management
<br>```createReservation(String clientId, int roomNumber, LocalDate checkIn, LocalDate checkOut)```: Create a new reservation.</br>
<br>```cancelReservation(String clientId, int roomNumber)```: Cancel an existing reservation.</br>
<br>```findReservation(String clientId, int roomNumber)```: Find a reservation by client ID and room number.</br>
<br>```checkRoomAvailability(int roomNumber, LocalDate checkIn, LocalDate checkOut)```: Check if a room is available between specific dates.</br>

</p>

<details>
  <summary>Solution Hint!</summary>
  <p>

```java
public interface RoomManagement {
    void addRoom(int roomNumber, String type, double price);
    void removeRoom(int roomNumber);
    void updateRoomDetails(int roomNumber, String type, double price);
    Room findRoom(int roomNumber);
    List<Room> findRoomsByType(String type);
    List<Room> findRoomsInPriceRange(double minPrice, double maxPrice);
}

public interface ClientManagement {
    void addClient(String firstName, String lastName, String id);
    void updateClientInfo(String id, String newFirstName, String newLastName);
    Client findClient(String id);
}

public interface ReservationManagement {
    void createReservation(String clientId, int roomNumber, LocalDate checkIn, LocalDate checkOut);
    void cancelReservation(String clientId, int roomNumber);
    Reservation findReservation(String clientId, int roomNumber);
    boolean checkRoomAvailability(int roomNumber, LocalDate checkIn, LocalDate checkOut);
}
public class Room {
    private int roomNumber;
    private String type;
    private double price;
    // Constructor, getters, and setters
}

public class Client {
    private String firstName;
    private String lastName;
    private String id;
    // Constructor, getters, and setters
}

public class Reservation {
    private String clientId;
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    // Constructor, getters, and setters
}

public class HotelManagement implements RoomManagement, ClientManagement, ReservationManagement {
    // Implement all the methods defined in the interfaces
}

  ```
  </p>
  </details>

# Additional tasks 

<a href="https://www.codewars.com/kata/search/java?q=&tags=Object-oriented%20Programming&beta=false&order_by=popularity%20desc/">Click Here!</a>
