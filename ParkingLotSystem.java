
import java.util.*;

class Vehicle {
    String type;
    String registrationNumber;
    String color;

    public Vehicle(String type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}

class ParkingSlot {
    String type;
    boolean isOccupied;

    public ParkingSlot(String type) {
        this.type = type;
        this.isOccupied = false;
    }
}

class ParkingFloor {
    int floorNumber;
    List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
    }
}

public class ParkingLotSystem {
    private static Map<String, ParkingFloor> parkingFloors;
    private static Map<String, Vehicle> parkedVehicles;
    private static int floors;
    private static int slotsPerFloor;
    private static int truckSlots;
    private static int bikeSlots;
    private static int carSlots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        parkingFloors = new HashMap<>();
        parkedVehicles = new HashMap<>();

        while (true) {
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = command.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "create_parking_lot":
                    createParkingLot(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    break;
                case "park_vehicle":
                    parkVehicle(parts[1], parts[2], parts[3]);
                    break;
                case "unpark_vehicle":
                    unparkVehicle(parts[1]);
                    break;
                case "display":
                    display(parts[1], parts[2]);
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static void createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        floors = noOfFloors;
        slotsPerFloor = noOfSlotsPerFloor;

        // We will assume that the first slot on each floor will be for a truck,
        // the next 2 for bikes, and all the other slots for cars.
        truckSlots = 1;
        bikeSlots = 2;
        carSlots = noOfSlotsPerFloor - truckSlots - bikeSlots;

        for (int i = 1; i <= noOfFloors; i++) {
            ParkingFloor floor = new ParkingFloor(i);
            for (int j = 1; j <= noOfSlotsPerFloor; j++) {
                String type;
                if (j <= truckSlots) {
                    type = "TRUCK";
                } else if (j <= truckSlots + bikeSlots) {
                    type = "BIKE";
                } else {
                    type = "CAR";
                }
                ParkingSlot slot = new ParkingSlot(type);
                floor.parkingSlots.add(slot);
            }
            parkingFloors.put(parkingLotId + "_" + i, floor);
        }

        System.out.println("Created parking lot with " + noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
    }

    private static void parkVehicle(String vehicleType, String registrationNumber, String color) {
        String ticketId = findAvailableSlot(vehicleType);
        if (ticketId == null) {
            System.out.println("Parking Lot Full");
            return;
        }

        parkedVehicles.put(ticketId, new Vehicle(vehicleType, registrationNumber, color));
        System.out.println("Parked vehicle. Ticket ID: " + ticketId);
    }

    private static String findAvailableSlot(String vehicleType) {
        for (int i = 1; i <= floors; i++) {
            ParkingFloor floor = parkingFloors.get("PR1234_" + i);
            for (int j = 0; j < floor.parkingSlots.size(); j++) {
                ParkingSlot slot = floor.parkingSlots.get(j);
                if (!slot.isOccupied && slot.type.equals(vehicleType)) {
                    slot.isOccupied = true;
                    return "PR1234_" + i + "_" + (j + 1);
                }
            }
        }
        return null;
    }

    private static void unparkVehicle(String ticketId) {
        if (!parkedVehicles.containsKey(ticketId)) {
            System.out.println("Invalid Ticket");
            return;
        }

        Vehicle vehicle = parkedVehicles.remove(ticketId);
        String[] parts = ticketId.split("_");
        int floorNumber = Integer.parseInt(parts[1]);
        int slotNumber = Integer.parseInt(parts[2]);
        ParkingFloor floor = parkingFloors.get("PR1234_" + floorNumber);
        floor.parkingSlots.get(slotNumber - 1).isOccupied = false;

        System.out.println("Unparked vehicle with Registration Number: " + vehicle.registrationNumber +
                " and Color: " + vehicle.color);
    }

    private static void display(String displayType, String vehicleType) {
        for (int i = 1; i <= floors; i++) {
            ParkingFloor floor = parkingFloors.get("PR1234_" + i);
            int freeCount = 0;
            List<Integer> freeSlots = new ArrayList<>();
            List<Integer> occupiedSlots = new ArrayList<>();

            for (int j = 0; j < floor.parkingSlots.size(); j++) {
                ParkingSlot slot = floor.parkingSlots.get(j);
                if (!slot.isOccupied && slot.type.equals(vehicleType)) {
                    freeCount++;
                    freeSlots.add(j + 1);
                } else if (slot.isOccupied && slot.type.equals(vehicleType)) {
                    occupiedSlots.add(j + 1);
                }
            }

            if (displayType.equalsIgnoreCase("free_count")) {
                System.out.println("No. of free slots for " + vehicleType + " on Floor " + i + ": " + freeCount);
            } else if (displayType.equalsIgnoreCase("free_slots")) {
                System.out.println("Free slots for " + vehicleType + " on Floor " + i + ": " + freeSlots);
            } else if (displayType.equalsIgnoreCase("occupied_slots")) {
                System.out.println("Occupied slots for " + vehicleType + " on Floor " + i + ": " + occupiedSlots);
            } else {
                System.out.println("Invalid display type.");
            }
        }
    }
}
