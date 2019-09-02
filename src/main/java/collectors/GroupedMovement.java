package collectors;

import java.util.Objects;

public class GroupedMovement implements Comparable<GroupedMovement> {
    private double value;
    private String status;


    public GroupedMovement(Movement movement) {
        this.status = movement.getStatus();
        this.value = movement.getValue();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupedMovement that = (GroupedMovement) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, status);
    }

    @Override
    public String toString() {
        return "GroupedMovement{" +
                "value=" + value +
                ", status='" + status + '\'' +
                '}';
    }


    @Override
    public int compareTo(GroupedMovement groupedMovement) {
        return this.status.compareTo(groupedMovement.status);
    }
}
