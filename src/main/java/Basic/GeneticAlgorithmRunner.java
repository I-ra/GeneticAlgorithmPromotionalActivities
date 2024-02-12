package Basic;

import Basic.Methods.Crossingover.FixedGenesCrossingover;
import Basic.Methods.Mutator.DummyMutator;
import Basic.Methods.Selection.EasyPeasySelection;
import Basic.Util.Parsing;
import Basic.Util.PopulationCreator;

public class GeneticAlgorithmRunner {


    private static final int POP_SIZE = 500;
    private static final int POP_COUNT = 500;

    private static final int COUNT_TWICE = 250;
    private static final int COUNT_MUTATION = 100;

    private static final Parsing pars = new Parsing();

    private static final EasyPeasySelection sel = new EasyPeasySelection();
    private static final FixedGenesCrossingover fixedGenesCrossingover = new FixedGenesCrossingover();
    private static final DummyMutator mutator = new DummyMutator();



    public static void main(String[] args) {

        PopulationCreator population = new PopulationCreator();
        population.create(POP_SIZE);


        for (int i = 0; i < POP_COUNT; i++) {
            sel.sort(population);

            fixedGenesCrossingover.crossMain(population, COUNT_TWICE);

            mutator.mainMutator(population,COUNT_MUTATION);

            System.out.println(population.getBestOne(population));

            System.gc();
        }
        sel.sort(population);
        System.out.println(population.getBestOne(population));
        System.out.println(population.getBestOne(population).ff);
        pars.write(population.getBestOne(population));
    }
}
