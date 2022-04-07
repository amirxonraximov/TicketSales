package models.stadium;

public class Seat {
    String id;
    int number;
    boolean isBusy;

    public Seat(String id, int number) {
        this.id = id;
        this.number = number;
        this.isBusy = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
