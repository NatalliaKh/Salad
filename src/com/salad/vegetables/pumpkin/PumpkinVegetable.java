package com.salad.vegetables.pumpkin;

import com.salad.Color;
import com.salad.vegetables.Vegetable;

public abstract class PumpkinVegetable extends Vegetable {

    public PumpkinVegetable(int caloricity, int weight, Color color) {
        super(caloricity, weight, color);
    }

    public String getVegetableTypeDescription() {
        return "семейство двудольных цветковых растений. Большинство тыквенных (всех их насчитывается более 600 " +
                "видов) — однолетние или многолетние травы, перезимовывающие при посредстве корневых клубней или " +
                "нижних частей стебля, и лишь немногие из них кустарники и полукустарники.";
    }
}
