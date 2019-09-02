package collectors.custom.working;

import collectors.Param;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collector;

/**
 * Useful when mutliple stats are wanted.
 *
 * IDEA: write your own version of this thing
 */
public class StatisticCollector {


    private DoubleSummaryStatistics stat = new DoubleSummaryStatistics();


    public void accept(Param param) {
        stat.accept(param.getDoubleValue());
    }

    public StatisticCollector combine (StatisticCollector stats) {
        stat.combine(stats.stat);

        return this;
    }

    public static Collector<Param, StatisticCollector, DoubleSummaryStatistics> collector() {
        return Collector.of(StatisticCollector::new, StatisticCollector::accept, StatisticCollector::combine,
                statisticCollector -> statisticCollector.stat);
    }


    //TODO: find leaner way to do this
    private double transformToPrimitive(Double val) {
        return (val != null) ? val : 0.0;
    }
}



