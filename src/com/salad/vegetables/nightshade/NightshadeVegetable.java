package com.salad.vegetables.nightshade;

import com.salad.Color;
import com.salad.vegetables.Vegetable;

public abstract class NightshadeVegetable extends Vegetable {

    public NightshadeVegetable(int caloricity, int weight, Color color) {
        super(caloricity, weight, color);
    }

    public String getVegetableTypeDescription() {
        return "семейство двудольных спайнолепестных растений, содержащее много съедобных и культивируемых видов," +
                " таких как картофель, баклажан, табак, томат и овощной перец (не путать с растениями семейства" +
                " Перечные), стручковый перец, дереза, паслён, паслён чёрный, пепино, санберри, хотя также есть и" +
                " ядовитые представители, например, дурман и белена.";
    }
}
