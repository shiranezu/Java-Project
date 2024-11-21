//Hospital Appointment Booking System (The system the details of the customer and welcomes them with their names to your application and allows
//the patient to book an appointment or to do a checkup.  Then it should allow the user to book an appointment with the registered doctor and 
//their specializations, the department, and the date and time for the appointment).
 
import java.util.Scanner;

class Customer {
    String name;
    int age;
    String gender;
    String contact;

    Customer(String name, int age, String gender, String contact) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;
    String department;

    Doctor(int id, String name, String specialization, String department) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.department = department;
    }
}

class Appointment {
    Customer customer;
    Doctor doctor;
    String date;
    String time;

    Appointment(Customer customer, Doctor doctor, String date, String time) {
        this.customer = customer;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
}

public class Hospital2 {
    static Doctor[] doctors = {
        new Doctor(1, "Dr. John Smith", "Cardiologist", "Cardiology"),
        new Doctor(2, "Dr. Emily Davis", "Neurologist", "Neurology"),
        new Doctor(3, "Dr. Michael Brown", "Dermatologist", "Dermatology")
    };
	
	
    static Appointment[] appointments = new Appointment[10]; 
    static int appointmentCount = 0;
	

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hospital Appointment Booking System");
		
        System.out.print("Please, enter your name: ");
        String name = scanner.nextLine();
		
        System.out.print("Please, enter your age: ");
        int age = scanner.nextInt();
		
        scanner.nextLine();  // Consume newline
		
        System.out.print("Please, enter your gender: ");
        String gender = scanner.nextLine();
		
        System.out.print("Please, enter your phone number: ");
        String contact = scanner.nextLine();

        Customer customer = new Customer(name, age, gender, contact);
        System.out.println("Hello " + name + ", welcome to our system!\n");

        while (true) {
            System.out.println("1. Book an appointment");
            System.out.println("2. Exit");
			
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
			
            if (choice == 1) {
                bookAppointment(scanner, customer);
            } 
			else if (choice == 2) {
                System.out.println("Thank you for using the system. Goodbye!");
                break;
            } 
			else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    public static void displayDoctors() {
        System.out.println("Available Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("ID: " + doctor.id + ", Name: " + doctor.name + ", Specialization: " + doctor.specialization + ", Department: " + doctor.department);
        }
    }

    public static void bookAppointment(Scanner scanner, Customer customer) {
        displayDoctors();
		
        System.out.print("Enter the Doctor ID to book an appointment: ");
        int doctorId = scanner.nextInt();
		
        scanner.nextLine();

        Doctor selectedDoctor = null;
		
        for (Doctor doctor : doctors) {
            if (doctor.id == doctorId) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Invalid Doctor ID. Try again.");
            return;
        }

        System.out.print("Enter the appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
		
        System.out.print("Enter the appointment time (HH:MM): ");
        String time = scanner.nextLine();

        if (appointmentCount < appointments.length) {
            appointments[appointmentCount++] = new Appointment(customer, selectedDoctor, date, time);
            System.out.println("Appointment booked with Dr. " + selectedDoctor.name + " on " + date + " at " + time + ".\n");
        } 
		else {
            System.out.println("No available slots for appointments. Please try again later.");
        }
    }
}