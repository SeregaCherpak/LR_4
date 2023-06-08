package abs.servlet;

import lombok.Getter;


public class Car {
    @Getter private String mark;
    @Getter private String model;
    @Getter private String price;
    @Getter private String year;
    @Getter private String engine_capacity;

    public Car(String mark, String model, String price, String year, String engine_capacity) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year = year;
        this.engine_capacity = engine_capacity;
        this.idInDatabase = idInDatabase;
    }
    @Override
    public boolean equals(Object obj) {
        Car res = (Car) obj;
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!mark.equals(res.mark)) return false;
        if (!model.equals(res.model)) return false;
        if (!price.equals(res.price)) return false;
        if (!year.equals(res.year)) return false;
        if (idInDatabase != series.idInDatabase) return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + engine_capacity.hashCode();
        result = 31 * result + mark.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + idInDatabase;
        return result;
    }
}
