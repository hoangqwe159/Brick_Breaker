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
                        BrickSummoner.summonType0_1(titleX * 40, titleY * 20);
                    else if (mapData == 2)
                        BrickSummoner.summonType0_2(titleX * 40, titleY * 20);
                    else if (mapData == 3)
                        BrickSummoner.summonType1(titleX * 40, titleY * 20);
                    else if (mapData == 4)
                        BrickSummoner.summonType2(titleX * 40, titleY * 20);
                    else if (mapData == 5)
                        BrickSummoner.summonType3(titleX * 40, titleY * 20);
                    else if (mapData == 6)
                        BrickSummoner.summonType4(titleX * 40, titleY * 20);
                    else if (mapData == 7)
                        BrickSummoner.summonType5_1(titleX * 40, titleY * 20);
                    else if (mapData == 8)
                        BrickSummoner.summonType5_2(titleX * 40, titleY * 20);
                    else if (mapData == 9)
                        BrickSummoner.summonType6(titleX * 40, titleY * 20);
                    else if (mapData == 10)
                        BrickSummoner.summonType7_1(titleX * 40, titleY * 20);
                    else if (mapData == 11)
                        BrickSummoner.summonType7_2(titleX * 40, titleY * 20);
                    else if (mapData == 12)
                        BrickSummoner.summonType8(titleX * 40, titleY * 20);
                    else if (mapData == 13)
                        BrickSummoner.summonType9_1(titleX * 40, titleY * 20);
                    else if (mapData == 14)
                        BrickSummoner.summonType9_2(titleX * 40, titleY * 20);
                }
            }
        }
    }
}
