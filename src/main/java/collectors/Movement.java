package collectors;

import utils.StringUtils;

import java.util.Objects;

public class Movement {

    public static final String PENDING = "Pending";
    public static final String CANCELLED = "Cancelled";
    public static final String VALIDATED = "Validated";

    private int id = (int) Math.round(Math.random() * 1000);

    private String investorName = StringUtils.generateRandom();


    private double value;

    private String status;


    public Movement(double value, String status) {
        this.value = value;
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return id == movement.id &&
                Double.compare(movement.value, value) == 0 &&
                Objects.equals(investorName, movement.investorName) &&
                Objects.equals(status, movement.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, investorName, value, status);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", investorName='" + investorName + '\'' +
                ", value=" + value +
                ", status='" + status + '\'' +
                '}';
    }
}
