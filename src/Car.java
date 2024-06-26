public class Car {
    private String carId;
    private String carModel;
    private String carBrand;
    private int rentPerDay;
    private boolean isAvailable;

    public Car(String carId,String carBrand,String carModel, int rentPerDay) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.rentPerDay = rentPerDay;
        this.isAvailable=true;
    }


    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(int rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void rent(){
        isAvailable = false;
    }
    public void returnCar(){
        isAvailable = true;
    }
    public int calculatePrice(int days){
        return rentPerDay*days;
    }
}
