package Basic.Util;

import java.util.Arrays;
import java.util.Random;

public class OneIndividium implements Individium, FitnessFunction {

    private final Parsing data = new Parsing();

    private final double maxBattery = 6000;
    private final double minBattery = 500;
    private final double zeroBattery = 1000;
    private final int IND_SIZE = 24;
    private final Double[] generatorSchedule = data.getArrayGeneration();
    private final Double[] loadSchedule = data.getArrayLoad();
    private final Double[] energyPriceSchedule = data.getArrayPrice();
    public int [] action = new int[IND_SIZE];
    private final int maxSale = 4;
    private final int minSale = -4;
    public double ff;

    public int getIND_SIZE() {
        return IND_SIZE;
    }
    public int getMaxSale() {
        return maxSale;
    }
    public int getMinSale() {
        return minSale;
    }


    public OneIndividium() {
        arrayCompletion();
        this.ff = calculateFF();
    }

    public void arrayCompletion(){
        for (int i = 0; i < action.length; i++) {
            Random random = new Random();
            action[i] = random.nextInt(maxSale - minSale + 1) + minSale ;
        }
    }

    @Override
    public String toString() {
        return "Individium{" +
                "solution =" + Arrays.toString(action) + " FF = " + ff +
                '}';
    }

    @Override
    public double calculateFF() {
        ff = 0;
        double pre = zeroBattery;
        for (int i = 0; i < IND_SIZE; i++) {
            if ((pre - loadSchedule[i] + generatorSchedule[i] + action[i] * 1000 < minBattery) ||
                    (pre - loadSchedule[i] + generatorSchedule[i] + action[i] * 1000 > maxBattery)) {
                ff += 1000;
            }
            ff = ff + action[i] * energyPriceSchedule[i];
            pre = pre + action[i] * 1000 - loadSchedule[i] + generatorSchedule[i];

        }
        return ff;
    }

    public void setAction(OneIndividium ind){
        int [] indSolution = ind.action;
        int [] copyIndSolution = new int[indSolution.length];
        System.arraycopy(indSolution,0,copyIndSolution,0, indSolution.length);
        this.action = copyIndSolution;
    }

}
