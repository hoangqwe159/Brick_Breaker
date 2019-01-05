package game.maps;

import game.brick.BrickSummoner;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    public void generate() {
        for (int titleY = 0; titleY < height; titleY++) {
            for (int titleX = 0; titleX < width; titleX++) {
                int mapData = data.get(titleY * width + titleX);
                if (mapData != 0) {
                    if (mapData == 1)
                        BrickSummoner.summonType2(titleX * 40, titleY * 20);
                    else if (mapData == 2)
                        BrickSummoner.summonType1(titleX * 40, titleY * 20);
                    else if (mapData == 3)
                        BrickSummoner.summonType3(titleX * 40, titleY * 20);
                }
            }
        }
    }
}
