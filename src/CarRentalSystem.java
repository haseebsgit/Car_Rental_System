import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
            if (car.isAvailable()){
                car.rent();
                rentals.add(new Rental(car, customer, days));
            }else {
                System.out.println("Car is not available for rent");
            }
        }


    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully");
            car.returnCar();
        } else {
            System.out.println("Car was not returned");
        }
    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to car rental system");
            System.out.println("Press 1 to rent a car");
            System.out.println("Press 2 to return a car");
            System.out.println("Press 3 to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice==1){
                System.out.println("Enter your name :");
                String name = scanner.nextLine();
                System.out.println("Cars available");
                for (Car car: cars){
                    {
                        if (car.isAvailable()){
                            System.out.println(car.getCarId()+ " - " +car.getCarBrand()+ " " + car.getCarModel());
                        }
                    }
                }
                System.out.println("Enter the id of the car you want to rent");
                 String carId = scanner.nextLine();
                System.out.println("Enter the number of days");
                int days = scanner.nextInt();
                scanner.nextLine();
                Customer newCustomer = new Customer("Customer" + (customers.size()+1) , name);
                addCustomer(newCustomer);
                Car selectedCar = null;
                for (Car car:cars){
                    if (car.getCarId().equals(carId) && car.isAvailable() ){
                        selectedCar=car;
                        break;
                    }
                }
                if (selectedCar!=null){
                    double totalPrice = selectedCar.calculatePrice(days);
                    System.out.println("Customer Name : " + name);
                    System.out.println("Car chosen : " +selectedCar.getCarBrand() +" "+ selectedCar.getCarModel());
                    System.out.println("Total rent : " + totalPrice);
                    System.out.println("Press 1 if you want to confirm");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    if (choice2==1){
                        rentCar(selectedCar,newCustomer,days);
                        System.out.println("Car rented successfully");
                    }else {
                        System.out.println("Car was not rented or not available ");
                    }
                }
            }
            if(choice==2){
                System.out.println("Enter the Id of the car you want to return");
                String carId = scanner.nextLine();
                for (Car car:cars){
                    if (car.getCarId().equals(carId) && !car.isAvailable()){
                        rentals.remove(car);
                        System.out.println("Car returned successfully");
                        break;
                    }else {
                        System.out.println("Car was not returned or borrowed");
                        break;
                    }
                }

            }
            if (choice==3)
                System.out.println("Thank you for using Car Rental System");
                break;
        }
    }

    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car car1 = new Car("Car-001","Toyota","Grande",5000);
        Car car2 = new Car("Car-002","Honda","Civic",6000);
        Car car3 = new Car("Car-003","Changan","Alsvin",4000);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);

        carRentalSystem.menu();
    }
}