package Basic.Methods.Crossingover;

import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

public interface Crossingover {

   void crossMain(PopulationCreator pop, int countTwice);
    void cross(PopulationCreator pop, OneIndividium mum, OneIndividium dad, OneIndividium childOne, OneIndividium childTwo);
}
