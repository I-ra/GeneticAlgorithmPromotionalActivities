package Basic.Methods.Mutator;

import Basic.Methods.Selection.EasyPeasySelection;
import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SuperPuperRandomMutator implements Mutator {

    private final int GEN = 3;

    public void mainMutator(PopulationCreator pop, int p){
        for (int i = 0; i < p; i++) {
            Random rn = new Random();
            int mutP = rn.nextInt(pop.popList.size());
            mut(pop.popList.get(mutP));
        }
        pop.sort();
    }

    public void mut(OneIndividium ind) {
        List<OneIndividium> data = new ArrayList<>();

        Random rn = new Random();

        int countPoint = rn.nextInt(ind.action.length);

        for (int i = 0; i < GEN; i++) {
            OneIndividium mutInd = new OneIndividium();
            mutInd.setAction(ind);
            for (int j = 0; j < countPoint; j++) {
                int mutationPoint = rn.nextInt(ind.action.length);
                int mutationValue = rn.nextInt(ind.getMaxSale() - ind.getMinSale() + 1) + ind.getMinSale();
                ind.action[mutationPoint] = mutationValue;
            }
            mutInd.calculateFF();
            data.add(mutInd);
        }
        data.sort(new Comparator<OneIndividium>() {
            @Override
            public int compare(OneIndividium o1, OneIndividium o2) {
                return o1.ff < o2.ff ? -1: o1.ff > o2.ff ? 1: 0;
            }
        });
        ind = data.get(0);
    }
}
