package Basic.Methods.Selection;

import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

import java.util.Comparator;
import java.util.Random;

public class EasyPeasySelection implements Selection {
    public void sort (PopulationCreator pop){
        cutOff(pop);
        pop.popList.sort(new Comparator<OneIndividium>() {
            @Override
            public int compare(OneIndividium o1, OneIndividium o2) {
                return o1.ff < o2.ff ? -1: o1.ff > o2.ff ? 1: 0;
            }
        });
    }

    public void cutOff(PopulationCreator pop){
        for (int j = pop.getSizeList()-1; j > 0; j--) {
               if (pop.popList.get(j).ff > 15000 || pop.popList.size() > 500) {
                pop.popList.remove(pop.popList.get(j));
            } else break;
        }
    }
}
