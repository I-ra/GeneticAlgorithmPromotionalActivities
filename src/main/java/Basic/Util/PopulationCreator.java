package Basic.Util;

import Basic.Methods.Selection.EasyPeasySelection;

import java.util.*;

public class PopulationCreator {
    public List<OneIndividium> popList = new ArrayList<>();

    public EasyPeasySelection sel = new EasyPeasySelection();

    public void create(int size){
        for (int i = 0; i < size; i++) {
            popList.add(new OneIndividium());
        }
    }

    public void sort(){
        popList.sort(new Comparator<OneIndividium>() {
            @Override
            public int compare(OneIndividium o1, OneIndividium o2) {
                return o1.ff < o2.ff ? -1: o1.ff > o2.ff ? 1: 0;
            }
        });
    }
    public OneIndividium getBestOne(PopulationCreator pop){
        return popList.get(0);
    }

    public int getSizeList(){
        return popList.size();
    }


}
