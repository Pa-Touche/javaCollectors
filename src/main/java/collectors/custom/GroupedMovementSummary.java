package collectors.custom;

import collectors.GroupedMovement;
import collectors.Movement;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class GroupedMovementSummary {
    private DoubleSummaryStatistics valueStatistics;

    private List<GroupedMovement> groupedMovements;
    private List<List<Movement>> plainMovements;

    public GroupedMovementSummary() {
    }

    public DoubleSummaryStatistics getValueStatistics() {
        return valueStatistics;
    }

    public void setValueStatistics(DoubleSummaryStatistics valueStatistics) {
        this.valueStatistics = valueStatistics;
    }

    public List<GroupedMovement> getGroupedMovements() {
        return groupedMovements;
    }

    public void setGroupedMovements(List<GroupedMovement> groupedMovements) {
        this.groupedMovements = groupedMovements;
    }

    public List<List<Movement>> getPlainMovements() {
        return plainMovements;
    }

    public void setPlainMovements(List<List<Movement>> plainMovements) {
        this.plainMovements = plainMovements;
    }

    @Override
    public String toString() {
        return "GroupedMovementSummary{" +
                "valueStatistics=" + valueStatistics +
                ", groupedMovements=" + groupedMovements +
                ", plainMovements=" + plainMovements +
                '}';
    }
}
