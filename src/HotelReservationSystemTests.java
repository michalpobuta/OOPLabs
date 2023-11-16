import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationSystemTests {

    @Test
    public void testAddingClient() {
        ClientManagement management = new HotelManagement();
        management.addClient("John", "Doe", "001");
        assertNotNull(management.findClient("001"));
    }

    @Test
    public void testUpdatingClientInfo() {
        ClientManagement management = new HotelManagement();
        management.addClient("Jane", "Doe", "002");
        management.updateClientInfo("002", "Jane", "Smith");
        Client updatedClient = management.findClient("002");
        assertEquals("Smith", updatedClient.getLastName());
    }

    @Test
    public void testCheckingRoomAvailability() {
        RoomManagement roomManagement = new HotelManagement();
        ReservationManagement reservationManagement = new HotelManagement();

        roomManagement.addRoom(201, "Single", 100.0);
        assertTrue(reservationManagement.checkRoomAvailability(201, LocalDate.now(), LocalDate.now().plusDays(1)));

        reservationManagement.createReservation("003", 201, LocalDate.now(), LocalDate.now().plusDays(1));
        assertFalse(reservationManagement.checkRoomAvailability(201, LocalDate.now(), LocalDate.now().plusDays(1)));
    }

    @Test
    public void testReservationCreationAndCancellation() {
        ReservationManagement management = new HotelManagement();
        management.createReservation("004", 202, LocalDate.now(), LocalDate.now().plusDays(2));
        Reservation reservation = management.findReservation("004", 202);
        assertNotNull(reservation);

        management.cancelReservation("004", 202);
        assertNull(management.findReservation("004", 202));
    }
    @Test
    public void testRoomDetailUpdates() {
        RoomManagement management = new HotelManagement();
        management.addRoom(203, "Deluxe", 500.0);
        management.updateRoomDetails(203, "Deluxe", 550.0);
        Room updatedRoom = management.findRoom(203);
        assertEquals(550.0, updatedRoom.getPrice());
    }

    @Test
    public void testSearchRoomByPriceRange() {
        RoomManagement management = new HotelManagement();
        management.addRoom(204, "Suite", 700.0);
        management.addRoom(205, "Standard", 300.0);

        List<Room> roomsInRange = management.findRoomsInPriceRange(200.0, 600.0);
        assertTrue(roomsInRange.contains(management.findRoom(205)));
        assertFalse(roomsInRange.contains(management.findRoom(204)));
    }

}
