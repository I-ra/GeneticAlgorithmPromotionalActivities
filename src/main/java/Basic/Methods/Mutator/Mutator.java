package Basic.Methods.Mutator;

import Basic.Util.OneIndividium;
import Basic.Util.PopulationCreator;

public interface Mutator {
    void mainMutator(PopulationCreator pop, int p);
    void mut(OneIndividium ind);
}
