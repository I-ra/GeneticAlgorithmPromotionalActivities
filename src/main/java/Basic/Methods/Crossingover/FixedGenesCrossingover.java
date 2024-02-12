package Basic.Methods.Crossingover;

import Basic.Methods.Selection.EasyPeasySelection;
import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

import java.util.Random;

public class FixedGenesCrossingover implements Crossingover {

    public void crossMain(PopulationCreator pop, int countTwice){
        if (pop.popList.size() < countTwice) countTwice = pop.popList.size();
        for (int i = 0; i < countTwice - 1; i++) {
            OneIndividium mum = pop.popList.get(i);
            i++;
            OneIndividium dad = pop.popList.get(i);
            OneIndividium childOne = new OneIndividium();
            OneIndividium childTwo = new OneIndividium();
            cross(pop, mum, dad, childOne,childTwo);

        }
        pop.sort();
    }

    public void cross(PopulationCreator pop, OneIndividium mum, OneIndividium dad, OneIndividium childOne, OneIndividium childTwo){
        Random random = new Random();
        int crossoverPoint = random.nextInt((mum.getIND_SIZE()/4));

        childOne.setAction(mum);
        childTwo.setAction(dad);

        for (int i = 0; i < crossoverPoint; i++) {
            int temp = childOne.action[i];
            childOne.action[i] = childTwo.action[i];
            childTwo.action[i] = temp;
        }

        childOne.calculateFF();
        childTwo.calculateFF();

        pop.popList.add(childOne);
        pop.popList.add(childTwo);

    }
}
