package Basic.Methods.Mutator;

import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

import java.util.Random;

public class DummyMutator implements Mutator {
    public void mainMutator(PopulationCreator pop, int p){
        for (int i = 0; i < p; i++) {
            Random rn = new Random();
            int mutP = rn.nextInt(pop.popList.size());
            mut(pop.popList.get(mutP));
        }
        pop.sort();
    }
    public void  mut(OneIndividium ind) {
        Random rn = new Random();
        int mutationPoint = rn.nextInt(ind.action.length);
        int mutationValue = rn.nextInt(ind.getMaxSale() - ind.getMinSale() + 1) + ind.getMinSale();
        ind.action[mutationPoint] = mutationValue;
        ind.calculateFF();
    }
}
