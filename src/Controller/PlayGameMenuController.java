package Controller;

import Model.*;
import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;

import java.util.*;
import java.util.regex.Matcher;

public class PlayGameMenuController {

    public ArrayList<Tile> mapCreator(int numOfCivilizations,ArrayList<Member> members){//tik
        int numOfTiles = 72;
        ArrayList<Tile> map = new ArrayList<>();
        float x0 = 10;
        float y0 = 10;

        Tile t0 = new Tile(0,false,false,false,true,false,false,false,false,x0,y0);
        float h = (float)t0.getH();
        float radius = t0.getRadius();

        map.add(t0);
        float x = x0;
        float y = y0 + 2 * h;
        map.add(new Tile(1,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(2,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(3,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(4,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(5,false,false,false,false,true,false,false,false,x,y));

        x = x0 + 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(6,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(7,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(8,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(9,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(10,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(11,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(12,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(13,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(14,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(15,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(16,false,false,false,false,false,false,true,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(17,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(18,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(19,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(20,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(21,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(22,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(23,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(24,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(25,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(26,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(27,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(28,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(29,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(30,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(31,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(32,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(33,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(34,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(35,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(36,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(37,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(38,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(39,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(40,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(41,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(42,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(43,false,false,false,false,false,false,true,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(44,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(45,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(46,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(47,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(48,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(49,true,false,false,false,false,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(50,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(51,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(52,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(53,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(54,true,false,false,false,false,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(55,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(56,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(57,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(58,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(59,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(60,false,false,false,false,false,false,false,true,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(61,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(62,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(63,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(64,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(65,false,false,false,false,false,false,false,true,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(66,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(67,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(68,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(69,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(70,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(71,false,false,false,true,false,false,false,false,x,y));


        return map;
    }
    public ArrayList<Civilization> initializeCivilizations(int numOfCivilizations, ArrayList<Tile> map, ArrayList<Member> members){
        ArrayList<Civilization> civilizations = new ArrayList<>();
        for(int i = 0; i < numOfCivilizations; i++){
            if(i == 0){
                Member member1 = members.get(0);
                City city1 = new City(map.get(7), map);
                civilizations.add(new Civilization(member1, city1));
            }
            else if(i == 1){
                Member member2 = members.get(1);
                City city2 = new City(map.get(48), map);
                civilizations.add(new Civilization(member2, city2));
            }
            else if(i == 2){
                Member member3 = members.get(2);
                City city3 = new City(map.get(62), map);
                civilizations.add(new Civilization(member3, city3));
            }
            else if(i == 3){
                Member member4 = members.get(3);
                City city4 = new City(map.get(45), map);
                civilizations.add(new Civilization(member4, city4));
            }
            else if(i == 4){
                Member member5 = members.get(4);
                City city5 = new City(map.get(30), map);
                civilizations.add(new Civilization(member5, city5));
            }
        }
        return civilizations;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String YELLOW = "\u001B[33m";// --> dessert
    public static final String DARK_GREEN = "\u001b[32m";// --> meadow
    public static final String LIGHT_GREEN = "\u001b[32;1m";// --> plain
    public static final String BLUE = "\u001B[34m";// --> ocean
    public static final String BROWN = "\u001B[34m";// --> mountain
    public static final String PURPLE = "\u001B[35m";// --> tundra
    public static final String SNOW = "\u001B[37m";// --> ice
    public static final String CYAN = "\033[0;36m";// --> hill
    public String[] setTileColors(ArrayList<Integer> tileStatusOfCivilization, ArrayList<Tile> map, HashMap<Integer, Tile> zeroStatusTilesCivilisation, String[] oldTileColors){
        String[] tileColors = new String[72];
        for (int i = 0; i < map.size(); i++) {
            if (tileStatusOfCivilization.get(i) == -1)
                tileColors[i]  = BLACK;
            else if (tileStatusOfCivilization.get(i) == 1){
                if (map.get(i).isDesert())
                    tileColors[i] = YELLOW;
                else if (map.get(i).isMeadow())
                    tileColors[i] = DARK_GREEN;
                else if (map.get(i).isPlain())
                    tileColors[i] = LIGHT_GREEN;
                else if (map.get(i).isOcean())
                    tileColors[i] = BLUE;
                else if (map.get(i).isMountain())
                    tileColors[i] = BROWN;
                else if (map.get(i).isTundra())
                    tileColors[i] = PURPLE;
                else if (map.get(i).isSnow())
                    tileColors[i] = SNOW;
                else if (map.get(i).isHill())
                    tileColors[i] = CYAN;
            }
            else {
                if (zeroStatusTilesCivilisation.get(i).isDesert())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isMeadow())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isPlain())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isOcean())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isMountain())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isTundra())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isSnow())
                    tileColors[i] = oldTileColors[i];
                else if (zeroStatusTilesCivilisation.get(i).isHill())
                    tileColors[i] = oldTileColors[i];
            }
        }
        return tileColors;
    }
    public String[] setTileType(ArrayList<Tile> map){
        String tileType[] = new String[72];
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getAttribute().isIce())
                tileType[i] = "i";
            else if (map.get(i).getAttribute().isMarsh())
                tileType[i] = "m";
            else if (map.get(i).getAttribute().isJungle())
                tileType[i] = "j";
            else if (map.get(i).getAttribute().isPlat())
                tileType[i] = "p";
            else if (map.get(i).getAttribute().isOasis())
                tileType[i] = "v";
            else if (map.get(i).getAttribute().isRainForest())
                tileType[i] = "r";
            else
                tileType[i] = "\u2588";
        }
        return tileType;
    }
    public void showMap(String ANSI_COLORS[], String number[], String types[]){//tik
        char block = '\u2588';
        String block1 = "   /" + block + block + block + block + block + block + "\\";
        String block2 = "  /" + block + block + block + block + block + block + block + block + "\\";
        String block3 = " /" + block + block + block + block + block + block + block + block + block + block + "\\";
        String block5 = " \\" + block + block + block + block + block + block + block + block + block + block + "/";
        String block6 = "  \\" + block + block + block + block + block + block + block + block + "/";
        String block7 = "   \\" + block + block + block + block + block + block + "/";


        System.out.println(ANSI_COLORS[0] + block1 + "   " +  ANSI_COLORS[11] + block1 + "   " + ANSI_COLORS[22] + block1 + "   " + ANSI_COLORS[33] + block1 + "   " + ANSI_COLORS[44] + block1 + "   " + ANSI_COLORS[55] + block1 + "   " + ANSI_COLORS[66] + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + block2 + "  " +  ANSI_COLORS[11] + block2 + "  " + ANSI_COLORS[22] + block2 + "  " + ANSI_COLORS[33] + block2 + "  " + ANSI_COLORS[44] + block2 + "  " + ANSI_COLORS[55] + block2 + "  " + ANSI_COLORS[66] + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + block3 + " " +  ANSI_COLORS[11] + block3 +  " " + ANSI_COLORS[22] + block3 + " " + ANSI_COLORS[33] + block3 + " " + ANSI_COLORS[44] + block3 + " " + ANSI_COLORS[55] + block3 + " " + ANSI_COLORS[66] + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + "|" + block + block + block + block + number[0] + block + types[0] + block + block + block + block + "|" +  ANSI_COLORS[11] + "|" + block + block + block + block + number[11] + block + types[11] + block + block + block + block + "|" + ANSI_COLORS[22] +  "|" + block + block + block + block + number[22] + block + types[22] + block + block + block + block + "|" + ANSI_COLORS[33] + "|" + block + block + block + block + number[33] + block + types[33] + block + block + block + block + "|" + ANSI_COLORS[44] + "|" + block + block + block + block + number[44] + block + types[44] + block + block + block + block + "|" + ANSI_COLORS[55] +"|" + block + block + block + block + number[55] + block + types[55] + block + block + block + block + "|" + ANSI_COLORS[66] + "|" + block + block + block + block + number[66] + block + types[66] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + block5 + " " +  ANSI_COLORS[11] + block5 +  " " + ANSI_COLORS[22] + block5 + " " + ANSI_COLORS[33] + block5 + " " + ANSI_COLORS[44] + block5 + " " + ANSI_COLORS[55] + block5 + " " + ANSI_COLORS[66] + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + block6 + "  " +  ANSI_COLORS[11] + block6 + "  " + ANSI_COLORS[22] + block6 + "  " + ANSI_COLORS[33] + block6 + "  " + ANSI_COLORS[44] + block6 + "  " + ANSI_COLORS[55] + block6 + "  " + ANSI_COLORS[66] + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[0] + block7 + "   " +  ANSI_COLORS[11] + block7 +  "   " + ANSI_COLORS[22] + block7 + "   " + ANSI_COLORS[33] + block7 + "   " + ANSI_COLORS[44] + block7 + "   " + ANSI_COLORS[55] + block7 + "   " + ANSI_COLORS[66] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[6] + "       " + block1 + ANSI_COLORS[17] + "   " + block1 + ANSI_COLORS[28] + "   " + block1 + ANSI_COLORS[39] + "   " + block1 + ANSI_COLORS[50] + "   " + block1 + ANSI_COLORS[61] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block2 + ANSI_COLORS[17] + "  " + block2 + ANSI_COLORS[28] + "  " + block2 + ANSI_COLORS[39] + "  " + block2 + ANSI_COLORS[50] + "  " + block2 + ANSI_COLORS[61] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block3 + ANSI_COLORS[17] + " " + block3 + ANSI_COLORS[28] +  " " + block3 + ANSI_COLORS[39] + " " + block3 + ANSI_COLORS[50] + " " + block3 + ANSI_COLORS[61] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + "|" + block + block + block + block + number[6] + block + types[6] + block + block + block + block + "|" + ANSI_COLORS[17] + "|" + block + block + block + block + number[17] + block + types[17] + block + block + block + block + "|" + ANSI_COLORS[28] +  "|" + block + block + block + block + number[28] + block + types[28] + block + block + block + block + "|" + ANSI_COLORS[39] + "|" + block + block + block + block + number[39] + block + types[39] + block + block + block + block + "|" + ANSI_COLORS[50] + "|" + block + block + block + block + number[50] + block + types[50] + block + block + block + block + "|" + ANSI_COLORS[61] + "|" + block + block + block + block + number[61] + block + types[61] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block5 + ANSI_COLORS[17] + " " + block5 + ANSI_COLORS[28] +  " " + block5 + ANSI_COLORS[39] + " " + block5 + ANSI_COLORS[50] + " " + block5 +  ANSI_COLORS[61] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block6 + ANSI_COLORS[17] + "  " + block6 + ANSI_COLORS[28] + "  " + block6 + ANSI_COLORS[39] + "  " + block6 + ANSI_COLORS[50] + "  " + block6 + ANSI_COLORS[61] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block7 + ANSI_COLORS[17] + "   " + block7 + ANSI_COLORS[28] +  "   " + block7 + ANSI_COLORS[39] + "   " + block7 + ANSI_COLORS[50] + "   " + block7 + ANSI_COLORS[61] + "   " + block7 + ANSI_RESET);



        System.out.println( ANSI_COLORS[1] + block1 + "   " +  ANSI_COLORS[12] + block1 + "   " + ANSI_COLORS[23] + block1 + "   " + ANSI_COLORS[34] + block1 + "   " + ANSI_COLORS[45] + block1 + "   " + ANSI_COLORS[56] + block1 + "   " + ANSI_COLORS[67] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block2 + "  " +  ANSI_COLORS[12] + block2 + "  " + ANSI_COLORS[23] + block2 + "  " + ANSI_COLORS[34] + block2 + "  " + ANSI_COLORS[45] + block2 + "  " + ANSI_COLORS[56] + block2 + "  " + ANSI_COLORS[67] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block3 + " " +  ANSI_COLORS[12] + block3 +  " " + ANSI_COLORS[23] + block3 + " " + ANSI_COLORS[34] + block3 + " " + ANSI_COLORS[45] + block3 + " " + ANSI_COLORS[56] + block3 + " " + ANSI_COLORS[67] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + "|" + block + block + block + block + number[1] + block + types[1] + block + block + block + block + "|" +  ANSI_COLORS[12] + "|" + block + block + block + block + number[12] + block + types[12] + block + block + block + block + "|" + ANSI_COLORS[23] +  "|" + block + block + block + block + number[23] + block + types[23] + block + block + block + block + "|" + ANSI_COLORS[34] + "|" + block + block + block + block + number[34] + block + types[34] + block + block + block + block + "|" + ANSI_COLORS[45] + "|" + block + block + block + block + number[45] + block + types[45] + block + block + block + block + "|" + ANSI_COLORS[56] + "|" + block + block + block + block + number[56] + block + types[56] + block + block + block + block + "|" + ANSI_COLORS[67] + "|" + block + block + block + block + number[67] + block + types[67] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block5 + " " +  ANSI_COLORS[12] + block5 +  " " + ANSI_COLORS[23] + block5 + " " + ANSI_COLORS[34] + block5 + " " + ANSI_COLORS[45] + block5 + " " + ANSI_COLORS[56] + block5 + " " + ANSI_COLORS[67] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block6 + "  " +  ANSI_COLORS[12] + block6 + "  " + ANSI_COLORS[23] + block6 + "  " + ANSI_COLORS[34] + block6 + "  " + ANSI_COLORS[45] + block6 + "  " + ANSI_COLORS[56] + block6 + "  " + ANSI_COLORS[67] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block7 + "   " +  ANSI_COLORS[12] + block7 +  "   " + ANSI_COLORS[23] + block7 + "   " + ANSI_COLORS[34] + block7 + "   " + ANSI_COLORS[45] + block7 + "   " + ANSI_COLORS[56] + block7 + "   " + ANSI_COLORS[67] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[7] + "       " + block1 + ANSI_COLORS[18] + "   " + block1 + ANSI_COLORS[29] + "   " + block1 + ANSI_COLORS[40] + "   " + block1 + ANSI_COLORS[51] + "   " + block1 + ANSI_COLORS[62] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block2 + ANSI_COLORS[18] + "  " + block2 + ANSI_COLORS[29] + "  " + block2 + ANSI_COLORS[40] + "  " + block2 + ANSI_COLORS[51] + "  " + block2 + ANSI_COLORS[62] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block3 + ANSI_COLORS[18] + " " + block3 + ANSI_COLORS[29] +  " " + block3 + ANSI_COLORS[40] + " " + block3 + ANSI_COLORS[51] + " " + block3 + ANSI_COLORS[62] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + "|" + block + block + block + block + number[7] + block + types[7] + block + block + block + block + "|" + ANSI_COLORS[18] + "|" + block + block + block + block + number[18] + block + types[18] + block + block + block + block + "|" + ANSI_COLORS[29] +  "|" + block + block + block + block + number[29] + block + types[29] + block + block + block + block + "|" + ANSI_COLORS[40] + "|" + block + block + block + block + number[40] + block + types[40] + block + block + block + block + "|" + ANSI_COLORS[51] + "|" + block + block + block + block + number[51] + block + types[51] + block + block + block + block + "|" + ANSI_COLORS[62] + "|" + block + block + block + block + number[62] + block + types[62] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block5 + ANSI_COLORS[18] + " " + block5 + ANSI_COLORS[29] +  " " + block5 + ANSI_COLORS[40] + " " + block5 + ANSI_COLORS[51] + " " + block5 +  ANSI_COLORS[62] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block6 + ANSI_COLORS[18] + "  " + block6 + ANSI_COLORS[29] + "  " + block6 + ANSI_COLORS[40] + "  " + block6 + ANSI_COLORS[51] + "  " + block6 + ANSI_COLORS[62] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block7 + ANSI_COLORS[18] + "   " + block7 + ANSI_COLORS[29] +  "   " + block7 + ANSI_COLORS[40] + "   " + block7 + ANSI_COLORS[51] + "   " + block7 + ANSI_COLORS[62] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[2] + block1 + "   " +  ANSI_COLORS[13] + block1 + "   " + ANSI_COLORS[24] + block1 + "   " + ANSI_COLORS[35] + block1 + "   " + ANSI_COLORS[46] + block1 + "   " + ANSI_COLORS[57] + block1 + "   " + ANSI_COLORS[68] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block2 + "  " +  ANSI_COLORS[13] + block2 + "  " + ANSI_COLORS[24] + block2 + "  " + ANSI_COLORS[35] + block2 + "  " + ANSI_COLORS[46] + block2 + "  " + ANSI_COLORS[57] + block2 + "  " + ANSI_COLORS[68] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block3 + " " +  ANSI_COLORS[13] + block3 +  " " + ANSI_COLORS[24] + block3 + " " + ANSI_COLORS[35] + block3 + " " + ANSI_COLORS[46] + block3 + " " + ANSI_COLORS[57] + block3 + " " + ANSI_COLORS[68] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + "|" + block + block + block + block + number[2] + block + types[2] + block + block + block + block + "|" +  ANSI_COLORS[13] + "|" + block + block + block + block + number[13] + block + types[13] + block + block + block + block + "|" + ANSI_COLORS[24] +  "|" + block + block + block + block + number[24] + block + types[24] + block + block + block + block + "|" + ANSI_COLORS[35] + "|" + block + block + block + block + number[35] + block + types[35] + block + block + block + block + "|" + ANSI_COLORS[46] + "|" + block + block + block + block + number[46] + block + types[46] + block + block + block + block + "|" + ANSI_COLORS[57] + "|" + block + block + block + block + number[57] + block + types[57] + block + block + block + block + "|" + ANSI_COLORS[68] + "|" + block + block + block + block + number[68] + block + types[68] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block5 + " " +  ANSI_COLORS[13] + block5 +  " " + ANSI_COLORS[24] + block5 + " " + ANSI_COLORS[35] + block5 + " " + ANSI_COLORS[46] + block5 + " " + ANSI_COLORS[57] + block5 + " " + ANSI_COLORS[68] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block6 + "  " +  ANSI_COLORS[13] + block6 + "  " + ANSI_COLORS[24] + block6 + "  " + ANSI_COLORS[35] + block6 + "  " + ANSI_COLORS[46] + block6 + "  " + ANSI_COLORS[57] + block6 + "  " + ANSI_COLORS[68] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block7 + "   " +  ANSI_COLORS[13] + block7 +  "   " + ANSI_COLORS[24] + block7 + "   " + ANSI_COLORS[35] + block7 + "   " + ANSI_COLORS[46] + block7 + "   " + ANSI_COLORS[57] + block7 + "   " + ANSI_COLORS[68] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[8] + "       " + block1 + ANSI_COLORS[19] + "   " + block1 + ANSI_COLORS[30] + "   " + block1 + ANSI_COLORS[41] + "   " + block1 + ANSI_COLORS[52] + "   " + block1 + ANSI_COLORS[63] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block2 + ANSI_COLORS[19] + "  " + block2 + ANSI_COLORS[30] + "  " + block2 + ANSI_COLORS[41] + "  " + block2 + ANSI_COLORS[52] + "  " + block2 + ANSI_COLORS[63] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block3 + ANSI_COLORS[19] + " " + block3 + ANSI_COLORS[30] +  " " + block3 + ANSI_COLORS[41] + " " + block3 + ANSI_COLORS[52] + " " + block3 + ANSI_COLORS[63] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + "|" + block + block + block + block + number[8] + block + types[8] + block + block + block + block + "|" + ANSI_COLORS[19] + "|" + block + block + block + block + number[19] + block + types[19] + block + block + block + block + "|" + ANSI_COLORS[30] +  "|" + block + block + block + block + number[30] + block + types[30] + block + block + block + block + "|" + ANSI_COLORS[41] + "|" + block + block + block + block + number[41] + block + types[41] + block + block + block + block + "|" + ANSI_COLORS[52] + "|" + block + block + block + block + number[52] + block + types[52] + block + block + block + block + "|" + ANSI_COLORS[63] + "|" + block + block + block + block + number[63] + block + types[63] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block5 + ANSI_COLORS[19] + " " + block5 + ANSI_COLORS[30] +  " " + block5 + ANSI_COLORS[41] + " " + block5 + ANSI_COLORS[52] + " " + block5 +  ANSI_COLORS[63] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block6 + ANSI_COLORS[19] + "  " + block6 + ANSI_COLORS[30] + "  " + block6 + ANSI_COLORS[41] + "  " + block6 + ANSI_COLORS[52] + "  " + block6 + ANSI_COLORS[63] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block7 + ANSI_COLORS[19] + "   " + block7 + ANSI_COLORS[30] +  "   " + block7 + ANSI_COLORS[41] + "   " + block7 + ANSI_COLORS[52] + "   " + block7 + ANSI_COLORS[63] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[3] + block1 + "   " +  ANSI_COLORS[14] + block1 + "   " + ANSI_COLORS[25] + block1 + "   " + ANSI_COLORS[36] + block1 + "   " + ANSI_COLORS[47] + block1 + "   " + ANSI_COLORS[58] + block1 + "   " + ANSI_COLORS[69] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block2 + "  " +  ANSI_COLORS[14] + block2 + "  " + ANSI_COLORS[25] + block2 + "  " + ANSI_COLORS[36] + block2 + "  " + ANSI_COLORS[47] + block2 + "  " + ANSI_COLORS[58] + block2 + "  " + ANSI_COLORS[69] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block3 + " " +  ANSI_COLORS[14] + block3 +  " " + ANSI_COLORS[25] + block3 + " " + ANSI_COLORS[36] + block3 + " " + ANSI_COLORS[47] + block3 + " " + ANSI_COLORS[58] + block3 + " " + ANSI_COLORS[69] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + "|" + block + block + block + block + number[3] + block + types[3] + block + block + block + block + "|" +  ANSI_COLORS[14] + "|" + block + block + block + block + number[14] + block + types[14] + block + block + block + block + "|" + ANSI_COLORS[25] +  "|" + block + block + block + block + number[25] + block + types[25] + block + block + block + block + "|" + ANSI_COLORS[36] + "|" + block + block + block + block + number[36] + block + types[36] + block + block + block + block + "|" + ANSI_COLORS[47] + "|" + block + block + block + block + number[47] + block + types[47] + block + block + block + block + "|" + ANSI_COLORS[58] + "|" + block + block + block + block + number[58] + block + types[58] + block + block + block + block + "|" + ANSI_COLORS[69] + "|" + block + block + block + block + number[69] + block + types[69] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block5 + " " +  ANSI_COLORS[14] + block5 +  " " + ANSI_COLORS[25] + block5 + " " + ANSI_COLORS[36] + block5 + " " + ANSI_COLORS[47] + block5 + " " + ANSI_COLORS[58] + block5 + " " + ANSI_COLORS[69] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block6 + "  " +  ANSI_COLORS[14] + block6 + "  " + ANSI_COLORS[25] + block6 + "  " + ANSI_COLORS[36] + block6 + "  " + ANSI_COLORS[47] + block6 + "  " + ANSI_COLORS[58] + block6 + "  " + ANSI_COLORS[69] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block7 + "   " +  ANSI_COLORS[14] + block7 +  "   " + ANSI_COLORS[25] + block7 + "   " + ANSI_COLORS[36] + block7 + "   " + ANSI_COLORS[47] + block7 + "   " + ANSI_COLORS[58] + block7 + "   " + ANSI_COLORS[69] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[9] + "       " + block1 + ANSI_COLORS[20] + "   " + block1 + ANSI_COLORS[31] + "   " + block1 + ANSI_COLORS[42] + "   " + block1 + ANSI_COLORS[53] + "   " + block1 + ANSI_COLORS[64] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block2 + ANSI_COLORS[20] + "  " + block2 + ANSI_COLORS[31] + "  " + block2 + ANSI_COLORS[42] + "  " + block2 + ANSI_COLORS[53] + "  " + block2 + ANSI_COLORS[64] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block3 + ANSI_COLORS[20] + " " + block3 + ANSI_COLORS[31] +  " " + block3 + ANSI_COLORS[42] + " " + block3 + ANSI_COLORS[53] + " " + block3 + ANSI_COLORS[64] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + "|" + block + block + block + block + number[9] + block + types[9] + block + block + block + block + "|" + ANSI_COLORS[20] + "|" + block + block + block + block + number[20] + block + types[20] + block + block + block + block + "|" + ANSI_COLORS[31] +  "|" + block + block + block + block + number[31] + block + types[31] + block + block + block + block + "|" + ANSI_COLORS[42] + "|" + block + block + block + block + number[42] + block + types[42] + block + block + block + block + "|" + ANSI_COLORS[53] + "|" + block + block + block + block + number[53] + block + types[53] + block + block + block + block + "|" + ANSI_COLORS[64] + "|" + block + block + block + block + number[64] + block + types[64] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block5 + ANSI_COLORS[20] + " " + block5 + ANSI_COLORS[31] +  " " + block5 + ANSI_COLORS[42] + " " + block5 + ANSI_COLORS[53] + " " + block5 +  ANSI_COLORS[64] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block6 + ANSI_COLORS[20] + "  " + block6 + ANSI_COLORS[31] + "  " + block6 + ANSI_COLORS[42] + "  " + block6 + ANSI_COLORS[53] + "  " + block6 + ANSI_COLORS[64] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block7 + ANSI_COLORS[20] + "   " + block7 + ANSI_COLORS[31] +  "   " + block7 + ANSI_COLORS[42] + "   " + block7 + ANSI_COLORS[53] + "   " + block7 + ANSI_COLORS[64] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[4] + block1 + "   " +  ANSI_COLORS[15] + block1 + "   " + ANSI_COLORS[26] + block1 + "   " + ANSI_COLORS[37] + block1 + "   " + ANSI_COLORS[48] + block1 + "   " + ANSI_COLORS[59] + block1 + "   " + ANSI_COLORS[70] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block2 + "  " +  ANSI_COLORS[15] + block2 + "  " + ANSI_COLORS[26] + block2 + "  " + ANSI_COLORS[37] + block2 + "  " + ANSI_COLORS[48] + block2 + "  " + ANSI_COLORS[59] + block2 + "  " + ANSI_COLORS[70] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block3 + " " +  ANSI_COLORS[15] + block3 +  " " + ANSI_COLORS[26] + block3 + " " + ANSI_COLORS[37] + block3 + " " + ANSI_COLORS[48] + block3 + " " + ANSI_COLORS[59] + block3 + " " + ANSI_COLORS[70] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + "|" + block + block + block + block + number[4] + block + types[4] + block + block + block + block + "|" +  ANSI_COLORS[15] + "|" + block + block + block + block + number[15] + block + types[15] + block + block + block + block + "|" + ANSI_COLORS[26] +  "|" + block + block + block + block + number[26] + block + types[26] + block + block + block + block + "|" + ANSI_COLORS[37] + "|" + block + block + block + block + number[37] + block + types[37] + block + block + block + block + "|" + ANSI_COLORS[48] + "|" + block + block + block + block + number[48] + block + types[48] + block + block + block + block + "|" + ANSI_COLORS[59] + "|" + block + block + block + block + number[59] + block + types[59] + block + block + block + block + "|" + ANSI_COLORS[70] + "|" + block + block + block + block + number[70] + block + types[70] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block5 + " " +  ANSI_COLORS[15] + block5 +  " " + ANSI_COLORS[26] + block5 + " " + ANSI_COLORS[37] + block5 + " " + ANSI_COLORS[48] + block5 + " " + ANSI_COLORS[59] + block5 + " " + ANSI_COLORS[70] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block6 + "  " +  ANSI_COLORS[15] + block6 + "  " + ANSI_COLORS[26] + block6 + "  " + ANSI_COLORS[37] + block6 + "  " + ANSI_COLORS[48] + block6 + "  " + ANSI_COLORS[59] + block6 + "  " + ANSI_COLORS[70] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block7 + "   " +  ANSI_COLORS[15] + block7 +  "   " + ANSI_COLORS[26] + block7 + "   " + ANSI_COLORS[37] + block7 + "   " + ANSI_COLORS[48] + block7 + "   " + ANSI_COLORS[59] + block7 + "   " + ANSI_COLORS[70] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[10] + "       " + block1 + ANSI_COLORS[21] + "   " + block1 + ANSI_COLORS[32] + "   " + block1 + ANSI_COLORS[43] + "   " + block1 + ANSI_COLORS[54] + "   " + block1 + ANSI_COLORS[65] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block2 + ANSI_COLORS[21] + "  " + block2 + ANSI_COLORS[32] + "  " + block2 + ANSI_COLORS[43] + "  " + block2 + ANSI_COLORS[54] + "  " + block2 + ANSI_COLORS[65] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block3 + ANSI_COLORS[21] + " " + block3 + ANSI_COLORS[32] +  " " + block3 + ANSI_COLORS[43] + " " + block3 + ANSI_COLORS[54] + " " + block3 + ANSI_COLORS[65] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + "|" + block + block + block + block + number[10] + block + types[10] + block + block + block + block + "|" + ANSI_COLORS[21] + "|" + block + block + block + block + number[21] + block + types[21] + block + block + block + block + "|" + ANSI_COLORS[32] +  "|" + block + block + block + block + number[32] + block + types[32] + block + block + block + block + "|" + ANSI_COLORS[43] + "|" + block + block + block + block + number[43] + block + types[43] + block + block + block + block + "|" + ANSI_COLORS[54] + "|" + block + block + block + block + number[54] + block + types[54] + block + block + block + block + "|" + ANSI_COLORS[65] + "|" + block + block + block + block + number[65] + block + types[65] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block5 + ANSI_COLORS[21] + " " + block5 + ANSI_COLORS[32] +  " " + block5 + ANSI_COLORS[43] + " " + block5 + ANSI_COLORS[54] + " " + block5 +  ANSI_COLORS[65] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block6 + ANSI_COLORS[21] + "  " + block6 + ANSI_COLORS[32] + "  " + block6 + ANSI_COLORS[43] + "  " + block6 + ANSI_COLORS[54] + "  " + block6 + ANSI_COLORS[65] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block7 + ANSI_COLORS[21] + "   " + block7 + ANSI_COLORS[32] +  "   " + block7 + ANSI_COLORS[43] + "   " + block7 + ANSI_COLORS[54] + "   " + block7 + ANSI_COLORS[65] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[5] + block1 + "   " +  ANSI_COLORS[16] + block1 + "   " + ANSI_COLORS[27] + block1 + "   " + ANSI_COLORS[38] + block1 + "   " + ANSI_COLORS[49] + block1 + "   " + ANSI_COLORS[60] + block1 + "   " + ANSI_COLORS[71] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block2 + "  " +  ANSI_COLORS[16] + block2 + "  " + ANSI_COLORS[27] + block2 + "  " + ANSI_COLORS[38] + block2 + "  " + ANSI_COLORS[49] + block2 + "  " + ANSI_COLORS[60] + block2 + "  " + ANSI_COLORS[71] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block3 + " " +  ANSI_COLORS[16] + block3 +  " " + ANSI_COLORS[27] + block3 + " " + ANSI_COLORS[38] + block3 + " " + ANSI_COLORS[49] + block3 + " " + ANSI_COLORS[60] + block3 + " " + ANSI_COLORS[71] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + "|" + block + block + block + block + number[5] + block + types[5] + block + block + block + block + "|" +  ANSI_COLORS[16] + "|" + block + block + block + block + number[16] + block + types[16] + block + block + block + block + "|" + ANSI_COLORS[27] +  "|" + block + block + block + block + number[27] + block + types[27] + block + block + block + block + "|" + ANSI_COLORS[38] + "|" + block + block + block + block + number[38] + block + types[38] + block + block + block + block + "|" + ANSI_COLORS[49] + "|" + block + block + block + block + number[49] + block + types[49] + block + block + block + block + "|" + ANSI_COLORS[60] + "|" + block + block + block + block + number[60] + block + types[60] + block + block + block + block + "|" + ANSI_COLORS[71] + "|" + block + block + block + block + number[71] + block + types[71] + block + block + block + block + "|" + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block5 + " " +  ANSI_COLORS[16] + block5 +  " " + ANSI_COLORS[27] + block5 + " " + ANSI_COLORS[38] + block5 + " " + ANSI_COLORS[49] + block5 + " " + ANSI_COLORS[60] + block5 + " " + ANSI_COLORS[71] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block6 + "  " +  ANSI_COLORS[16] + block6 + "  " + ANSI_COLORS[27] + block6 + "  " + ANSI_COLORS[38] + block6 + "  " + ANSI_COLORS[49] + block6 + "  " + ANSI_COLORS[60] + block6 + "  " + ANSI_COLORS[71] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block7 + "   " +  ANSI_COLORS[16] + block7 +  "   " + ANSI_COLORS[27] + block7 + "   " + ANSI_COLORS[38] + block7 + "   " + ANSI_COLORS[49] + block7 + "   " + ANSI_COLORS[60] + block7 + "   " + ANSI_COLORS[71] + block7 + ANSI_RESET);

    }
    // if distance between two tile center is (2rad3 * radius) they're neighbor
    private boolean isCityNeighbor(float x1, float y1, float x2, float y2, float radius){
        float distance = (float) Math.pow(0.5, (Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1)));
        if (radius * (float)Math.pow(0.5, 3) < distance && distance < 3 * radius * (float)Math.pow(0.5, 3))
            return true;
        return false;
    }
    private boolean isUnitNeighbor(float x1, float y1, float x2, float y2, float radius){
        float distance = (float) Math.pow(0.5, (Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1)));
        if (3 * radius * (float)Math.pow(0.5, 3) < distance && distance < 5 * radius * (float)Math.pow(0.5, 3))
            return true;
        return false;
    }
    // 1 -> vazeh, -1 -> fog
    public ArrayList<Integer> statusChecker(Civilization civilization, ArrayList<Tile> map){
        ArrayList<Integer> civilizationTiles  = new ArrayList<>(72);
        for (int i = 0; i < civilizationTiles.size(); i++)
            civilizationTiles.set(i, -1);
        ArrayList<City> cities = civilization.getCities();
        outerloop:
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < cities.size(); j++) {
                ArrayList<Tile> cityTiles = cities.get(j).getTiles();
                for (int k = 0; k < cityTiles.size(); k++) {
                    if (cityTiles.get(k).getUnits().size() == 0 && isCityNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())) {
                        civilizationTiles.set(i, 1);
                        break outerloop;
                    }
                    if (cityTiles.get(k).getUnits().size() > 0 && isUnitNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())
                    && !cityTiles.get(k).isBlocker()) {
                        civilizationTiles.set(i, 1);
                        break outerloop;
                    }
                    if (cityTiles.get(k).getUnits().size() > 0 && isCityNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())
                            && !cityTiles.get(k).isBlocker()) {
                        for (int l = 0; l < map.size(); l++)
                            if (2 * map.get(l).getTileNumber() == cityTiles.get(k).getTileNumber() + map.get(i).getTileNumber() && map.get(l).isBlocker())
                                break outerloop;
                        civilizationTiles.set(i, 1);
                        break outerloop;
                    }
                }
            }
        }
        return civilizationTiles;
    }
    // -1 -> fog, 0  -> moshakhas, 1 -> vazeh
    public ArrayList<Integer> statusComparator(ArrayList<Integer> old, ArrayList<Integer> now, HashMap<Integer, Tile> zeroStatusTiles, ArrayList<Tile> map){
        //TODO... if(now == fog of war && old == vazeh -> now = moshakhas)
        //TODO... return now;
        ArrayList<Integer> finalTileStatus = new ArrayList<>(72);
        for (int i = 0; i < finalTileStatus.size(); i++)
            finalTileStatus.set(i, -1);
        for (int i = 0; i < old.size(); i++) {
            if (now.get(i) == 1)
                finalTileStatus.set(i, 1);
            else if (now.get(i) == -1 && old.get(i) == 1) {
                finalTileStatus.set(i, 0);
                boolean exist = false;
                for (int j = 0; j < zeroStatusTiles.size(); j++) {
                    if (zeroStatusTiles.containsKey(i)) {
                        zeroStatusTiles.replace(i, map.get(i));
                        exist = true;
                        break;
                    }
                }
                if (!exist)
                    zeroStatusTiles.put(i, map.get(i));
            }
        }
        return finalTileStatus;
    }

    public StringBuilder researchInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder unitPanel(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder cityPanel(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder diplomaticInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder victoryImprovement(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder demographics(Civilization civilization,ArrayList<Tile> map){   //Jamiat shenasi
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder historyInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder generalUnitReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder economicalReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder diplomaticReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder tradeHistory(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public String tradeResource(Civilization civilization1, Civilization civilization2, Tile originTile, Resource originResource,Resource neededResource,ArrayList<Tile> map){
        String str;

        return str;
    }
    // finds all  the neighbours of a node (tile)
    public void findAllNeighbours(Node[] graph) {
        int column = 0;
        int counter = 0;
        for (int i = 0; i < graph.length; i++) {
            if (column % 2 == 0 && counter == 6) {
                counter = 0;
                column++;
            }
            if (column % 2 != 0 && counter == 5) {
                counter = 0;
                column++;
            }
            if (i - 1 >= 0 && counter != 0) {
                graph[i].neighbours.add(graph[i - 1]);
            }
            if (counter != 5 && counter != 4) {
                graph[i].neighbours.add(graph[i + 1]);
            }
            if (i - 6 >= 0 && (counter != 0 || column % 2 != 0)) {
                graph[i].neighbours.add(graph[i - 6]);
            }
            if (i - 5 >= 0 && counter != 5) {
                graph[i].neighbours.add(graph[i - 5]);
            }
            if (i + 6 <= 71 && counter != 5) {
                graph[i].neighbours.add(graph[i + 6]);
            }
            if (i + 5 <= 71 && (counter != 0 || column % 2 != 0)) {
                graph[i].neighbours.add(graph[i + 5]);
            }
            counter++;
        }
    }

    // set distance of two node (tile) based on destination mp.
    public int distanceOfTwoNode(Node node) {
        Tile tile = node.tile;
        if (tile.isMountain() || tile.isOcean() || tile.getAttribute().isIce()) {
            return 100000;
        }
        return tile.getMpCost();
    }
    // chase an algorithm based on graphs to find the shortest way.
    public void findThePath (HashMap<Node, Node> previousNode, HashMap<Node, Integer> distanceFromNode, ArrayList<Node> unreached, Node destinationNode) {
        while (unreached.size() > 0) {
            Node minimumBranch = null;
            for (int i = 0; i < unreached.size(); i++) {
                if (minimumBranch == null ||
                        distanceFromNode.get(unreached.get(i)) < distanceFromNode.get(minimumBranch)) {
                    minimumBranch = unreached.get(i);
                    unreached.remove(i);
                }
            }
            if (minimumBranch.equals(destinationNode)) break;

            for (int i = 0; i < minimumBranch.neighbours.size(); ++i) {
                Node neighbourOfBranch = minimumBranch.neighbours.get(i);
                int mpCost = distanceFromNode.get(minimumBranch) + distanceOfTwoNode(neighbourOfBranch);
                if (mpCost < distanceFromNode.get(neighbourOfBranch)) {
                    distanceFromNode.replace(neighbourOfBranch, mpCost);
                    previousNode.replace(neighbourOfBranch, minimumBranch);
                }
            }
        }
    }
    // find the shortest way from origin to destination based on mp.
    public void findTheShortestPath (Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map, Unit unit) {
        unit.setPath (null);
        Node[] graph = new Node[72];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node();
            graph[i].tile = map.get(i);
        }
        findAllNeighbours (graph);
        HashMap<Node, Integer> distanceFromNode = new HashMap<>();
        HashMap<Node, Node> previousNode = new HashMap<>();
        ArrayList<Node> unreached = new ArrayList<>();
        int originIndex = map.indexOf(origin);
        int destinationIndex = map.indexOf(destination);

        Node originNode = graph[originIndex];
        Node destinationNode = graph[destinationIndex];

        distanceFromNode.put(originNode, 0);
        previousNode.put(originNode, null);

        for (int i = 0; i < graph.length; i++) {
            if (!graph[i].equals(originNode)) {
                distanceFromNode.put(graph[i] ,100000);
                previousNode.put(graph[i], null);
            }
            unreached.add(graph[i]);
        }
        findThePath(previousNode, distanceFromNode, unreached, destinationNode);

        if (previousNode.get(destinationNode) == null) {
            unit.setPath(null);
            return;
        }

        ArrayList<Node> path = new ArrayList<>();
        Node currentNode = new Node();
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = previousNode.get(currentNode);
        }

        Collections.reverse(path);
        unit.setPath(path);
    }
    // create parameters like unit or origin or destination for moveUnit function
    public String preMoveUnit (Matcher matcher, Civilization civilization, ArrayList<Tile> map) {
        int numberOfOrigin = Integer.parseInt(matcher.group("numberO"));
        int numberOfDestination = Integer.parseInt(matcher.group("numberD"));
        String unitName = matcher.group("unitName").toLowerCase();

        Tile origin = map.get(numberOfOrigin);
        Tile destination = map.get(numberOfDestination);
        ArrayList<Unit> units = origin.getUnits();
        Unit unit = getUnitInTile(units, unitName);
        return moveUnit(civilization, origin, destination, map, unit);
    }
    //return a unit from specific tile
    public Unit getUnitInTile (ArrayList<Unit> units, String unitName) {
        for (int i = 0; i < units.size(); i++) {
            if (unitName.equals("archer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isArcher()) {
                    return units.get(i);
                }
            } else if (unitName.equals("chariot archer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isChariotArcher()) {
                    return units.get(i);
                }
            } else if (unitName.equals("scout") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isScout()) {
                    return units.get(i);
                }
            } else if (unitName.equals("settler") && units.get(i).isCivilian()) {
                if (((Civilian) units.get(i)).isSettler()) {
                    return units.get(i);
                }
            } else if (unitName.equals("worker") && units.get(i).isCivilian()) {
                if (((Civilian) units.get(i)).isWorker()) {
                    return units.get(i);
                }
            } else if (unitName.equals("spearman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isSpearman()) {
                    return units.get(i);
                }
            } else if (unitName.equals("warrior") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isWarrior()) {
                    return units.get(i);
                }
            } else if (unitName.equals("catapult") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCatapult()) {
                    return units.get(i);
                }
            } else if (unitName.equals("horseman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isHorseMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("swordsman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isSwordsMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("crossbowman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCrossbowMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("knight") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isKnight()) {
                    return units.get(i);
                }
            } else if (unitName.equals("longswordsman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isLongswordMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("pikeman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isPikeMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("trebuchet") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isTrebuchet()) {
                    return units.get(i);
                }
            } else if (unitName.equals("canon") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCanon()) {
                    return units.get(i);
                }
            } else if (unitName.equals("cavalry") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCavalry()) {
                    return units.get(i);
                }
            } else if (unitName.equals("lancer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isLancer()) {
                    return units.get(i);
                }
            } else if (unitName.equals("musketman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isMusketMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("rifleman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isRifleMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("anti-tank gun") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isAntiTankGun()) {
                    return units.get(i);
                }
            } else if (unitName.equals("artillery") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isArtillery()) {
                    return units.get(i);
                }
            } else if (unitName.equals("infantry") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isInfantry()) {
                    return units.get(i);
                }
            } else if (unitName.equals("panzer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isPanzer()) {
                    return units.get(i);
                }
            } else if (unitName.equals("tank") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isTank()) {
                    return units.get(i);
                }
            }
        }
            return null;
    }
    // check the road for units
    public boolean checkPath (Unit unit) {
        ArrayList<Node> nodes = unit.getPath();
        for (int i = 1; i < nodes.size(); i++) {
            ArrayList<Unit> units = nodes.get(i).tile.getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if ((!units.get(i1).isCivilian() &&
                        ((!unit.isCivilian()) || !units.get(i1).getCivilization().equals(unit.getCivilization()))) ||
                        (units.get(i1).isCivilian() && unit.isCivilian())){
                    return true;
                }
            }
        }
        return false;
    }

    public String moveUnit (Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map, Unit unit){
        String str;
        if (unit == null) {
            str = "there is no unit with this name !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (destination.isMountain() || destination.isOcean() || destination.getAttribute().isIce()) {
            str = "destination is unreachable !";
            return str;
        }
        if (unit.getPath() == null) {
            findTheShortestPath(civilization, origin, destination, map, unit);
        }
        if (unit.getPath() == null) {
            str = "there is no way to the destination !";
            return str;
        }
        if (checkPath(unit)) {
            unit.setOrigin(unit.getPath().get(0).tile);
            unit.setDestination(null);
            unit.setPath(null);
            str = "there is another civilization on the way !";
            return str;
        }
        unit.setOrigin(origin);
        unit.setDestination(destination);
        int i = 0;
        while (true) {
            if (i == unit.getPath().size() - 1) {
                unit.setMp(unit.getConstantMP());
                unit.setPath(null);
                unit.setOrigin(destination);
                unit.setDestination(null);
                str = "unit reached the destination !";
                break;
            }

            Tile originTile = unit.getPath().get(i).tile;
            Tile destinationTile = unit.getPath().get(i + 1).tile;

            if (unit.getMp() >= 1) {
                originTile.removeUnit(unit);
                destinationTile.addUnit(unit);
                int newMP;
                if (unit.getMp() >= destinationTile.getMpCost() + destinationTile.getAttribute().getMpCost()) {
                    newMP = unit.getMp() - destinationTile.getMpCost() - destinationTile.getAttribute().getMpCost();
                }
                else {
                    newMP = 0;
                }
                unit.getPath().remove(i);
                unit.setMp(newMP);
            }
            else {
                str = "unit mp isn't enough, wait until next turn !";
                break;
            }
        }
        return str;
    }
    // more than one turn moving function for units of playing civilization
    public void moveUnitWithMovesLeft (Civilization playingCivilization, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> units = map.get(i).getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if (units.get(i1).getCivilization().equals(playingCivilization) &&
                        units.get(i1).getPath() != null ) {
                    moveUnit(playingCivilization, units.get(i1).getOrigin(), units.get(i1).getDestination(), map, units.get(i1));
                }
            }
        }
    }

    // check the necessary technologies for unit
    public boolean checkTechnology (ArrayList<Technology> technologies, String name) {
        for (int i = 0; i < technologies.size(); i++) {
            if (technologies.get(i).getName().equals(name)) return false;
        }
        return true;
    }
    public boolean isTechnologyAvailableForUnit (Unit unit, Civilization civilization) {
        Warrior warrior = (Warrior) unit;
        ArrayList<Technology> technologies = civilization.getTechnologies();
        if (warrior.isArcher()) {
            if (checkTechnology(technologies, "Archery")) return false;
        }
        else if (warrior.isChariotArcher()) {
            if (checkTechnology(technologies, "The Wheel")) return false;
        }
        else if (warrior.isScout()) return true;
        else if (warrior.isSpearman()) {
            if (checkTechnology(technologies, "Bronze Working")) return false;
        }
        else if (warrior.isWarrior()) return true;
        else if (warrior.isCatapult()) {
            if (checkTechnology(technologies, "Mathematics")) return false;
        }
        else if (warrior.isHorseMan()) {
            if (checkTechnology(technologies, "Horseback Riding")) return false;
        }
        else if (warrior.isSwordsMan()) {
            if (checkTechnology(technologies, "Iron Working")) return false;
        }
        else if (warrior.isCrossbowMan()) {
            if (checkTechnology(technologies, "Machinery")) return false;
        }
        else if (warrior.isKnight()) {
            if (checkTechnology(technologies, "Chivalry")) return false;
        }
        else if (warrior.isLongswordMan()) {
            if (checkTechnology(technologies, "Steel")) return false;
        }
        else if (warrior.isPikeMan()) {
            if (checkTechnology(technologies, "Civil Service")) return false;
        }
        else if (warrior.isTrebuchet()) {
            if (checkTechnology(technologies, "Physics")) return false;
        }
        else if (warrior.isCanon()) {
            if (checkTechnology(technologies, "Chemistry")) return false;
        }
        else if (warrior.isCavalry()) {
            if (checkTechnology(technologies, "Military Science")) return false;
        }
        else if (warrior.isLancer()) {
            if (checkTechnology(technologies, "Metallurgy")) return false;
        }
        else if (warrior.isMusketMan()) {
            if (checkTechnology(technologies, "Gunpowder")) return false;
        }
        else if (warrior.isRifleMan()) {
            if (checkTechnology(technologies, "Rifling")) return false;
        }
        else if (warrior.isAntiTankGun()) {
            if (checkTechnology(technologies, "Replaceable Parts")) return false;
        }
        else if (warrior.isArtillery()) {
            if (checkTechnology(technologies, "Dynamite")) return false;
        }
        else if (warrior.isInfantry()) {
            if (checkTechnology(technologies, "Replaceable Parts")) return false;
        }
        else if (warrior.isPanzer()) {
            if (checkTechnology(technologies, "Combustion")) return false;
        }
        else if (warrior.isTank()) {
            if (checkTechnology(technologies, "Combustion")) return false;
        }
        return true;
    }
    //check the necessary resources for unit
    public boolean isResourceAvailableForUnit (Unit unit, City city) {
        Warrior warrior = (Warrior) unit;
        ArrayList<Tile> tiles = city.getTiles();
        for (int i = 0; i < tiles.size(); i++) {
           Resource resource = tiles.get(i).getResource();

                if (warrior.isArcher()) return true;
                else if (warrior.isChariotArcher()) {
                    if (resource.isHorse()) return true;
                }
                else if (warrior.isScout()) return true;
                else if (warrior.isSpearman()) return true;
                else if (warrior.isWarrior()) return true;

                else if (warrior.isCatapult()) {
                    if (resource.isMetal()) return true;
                }
                else if (warrior.isHorseMan()) {
                    if (resource.isHorse()) return true;
                }
                else if (warrior.isSwordsMan()) {
                    if (resource.isMetal()) return true;
                }
                else if (warrior.isCrossbowMan()) return true;
                else if (warrior.isKnight()) {
                    if (resource.isHorse()) return true;
                }
                else if (warrior.isLongswordMan()) {
                    if (resource.isMetal()) return true;
                }
                else if (warrior.isPikeMan()) return true;
                else if (warrior.isTrebuchet()) {
                    if (resource.isMetal()) return true;
                }
                else if (warrior.isCanon()) return true;
                else if (warrior.isCavalry()) {
                    if (resource.isHorse()) return true;
                }
                else if (warrior.isLancer()) {
                    if (resource.isHorse()) return true;
                }
                else if (warrior.isMusketMan()) return true;
                else if (warrior.isRifleMan()) return true;
                else if (warrior.isAntiTankGun()) return true;
                else if (warrior.isArtillery()) return true;
                else if (warrior.isInfantry()) return true;
                else if (warrior.isPanzer()) return true;
                else if (warrior.isTank()) return true;
        }
        return false;
    }
    // if unit is a warrior return true
    public boolean isUnitWarrior (Tile cityCenter) {
        ArrayList<Unit> units = cityCenter.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (!units.get(i).isCivilian()) return true;
        }
        return false;
    }
    //if unit is a civilian return true
    public boolean isUnitCivilian (Tile cityCenter) {
        ArrayList<Unit> units = cityCenter.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isCivilian()) return true;
        }
        return false;
    }
    // return a city that contains specific tile
    public City findTile (int index, ArrayList<Tile> map, Civilization civilization) {
        Tile tile = map.get(index);
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
          ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int i1 = 0; i1 < tiles.size(); i1++) {
                if (tiles.get(i1).equals(tile)) {
                    return cities.get(i);
                }
            }
        }
        return null;
    }
    // it makes parameters for unit maker such as unit or city
    public String preUnitMaker (Matcher matcher, Civilization civilization, ArrayList<Tile> map) {
        matcher.find();
        String unitName = matcher.group("unitName").toLowerCase();
        int index = Integer.parseInt(matcher.group("number"));
        City city = findTile(index, map, civilization);
        Unit unit = makeUnit(civilization, city, map, unitName);
        return createUnit(civilization, city, unit, map);
    }
    // TODO ... duration dorost set nashode 100 gozashtam felan
    public Unit makeUnit (Civilization civilization, City city, ArrayList<Tile> map, String unitName) {
        if (unitName.equals("archer")) {
           Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 70, false
                   , 0, 4, 2, 6, false, false, true, false,
                   false, false, false, false, false, false, false,
                   false, false, false, false, false, false, false,
                   false, false, false, false, false);
          return warrior;
        }
        else if (unitName.equals("chariot archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 60, false
                    , 0, 3, 2, 6, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("scout")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 25, false
                    , 0, 4, -1, -1, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("settler")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 100, 89, true, false, true);
           return civilian;
        }
        else if (unitName.equals("worker")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 100, 70, true, true, false);
           return civilian;
        }
        else if (unitName.equals("spearman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 50, false
                    , 0, 7, -1, -1, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("warrior")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 40, false
                    , 0, 6, -1, -1, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("catapult")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 100, false
                    , 0, 4, 2, 14, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("horseman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 80, false
                    , 0, 12, -1, -1, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("swordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 80, false
                    , 0, 11, -1, -1, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("crossbowman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 120, false
                    , 0, 6, 2, 12, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("knight")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("longswordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("pikeman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 100, false
                    , 0, 10, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("trebuchet")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 170, false
                    , 0, 6, 2, 20, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("canon")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 250, false
                    , 0, 10, 2, 26, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("cavalry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 260, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("lancer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 220, false
                    , 0, 22, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("musketman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 120, false
                    , 0, 16, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("rifleman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 200, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("anti-tank gun")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 300, false
                    , 0, 32, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false);
           return warrior;
        }
        else if (unitName.equals("artillery")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 420, false
                    , 0, 16, 32, 3, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false);
           return warrior;
        }
        else if (unitName.equals("infantry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 300, false
                    , 0, 36, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false);
           return warrior;
        }
        else if (unitName.equals("panzer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 5, 5, 100, 450, false
                    , 0, 60, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false);
           return warrior;
        }
        else if (unitName.equals("tank")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 450, false
                    , 0, 50, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true);
           return warrior;
        }
           return null;
    }

    public String createUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "this unit name doesn't exist!";
            return str;
        }

        if (city == null) {
            str = "this tile does not belong to your cities!";
            return str;
        }

        if (unit.getGoldCost() > city.getGold()) {
            str = "your gold is not enough!";
            return str;
        }

        if (!unit.isCivilian() && !isTechnologyAvailableForUnit (unit, civilization)) {
            str = "you don't have necessary technology!";
            return str;
        }

        if (!unit.isCivilian() && !isResourceAvailableForUnit (unit, city)) {
            str = "you don't have necessary resource!";
            return str;
        }

        Tile centerTile = city.getCenterTile();
        if (!unit.isCivilian() && isUnitWarrior (centerTile)) {
            str = "there is a military unit!";
            return str;
        }

        if (unit.isCivilian() && isUnitCivilian (centerTile)) {
            str = "there is a civilian unit!";
            return str;
        }

        centerTile.addUnit(unit);
        str = "unit created successfully!";
        return str;
    }
    public String purchaseUnit(Civilization civilization, ArrayList<Tile> map, Matcher matcher){
        String unitName = matcher.group("unitName");
        int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
        City city = this.findTile(tileNumber, map, civilization);
        Unit unit;
        if (unitName.equals("settler")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 0, 89, true, false, true);
            unit = civilian;
        }
        else if (unitName.equals("worker")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 0, 70, true, true, false);
            unit = civilian;
        }
        else if (unitName.equals("chariot archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 0, 60, false
                    , 0, 3, 2, 6, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 70, false
                    , 0, 4, 2, 6, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("scout")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 25, false
                    , 0, 4, -1, -1, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("catapult")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 100, false
                    , 0, 4, 2, 14, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("warrior")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 40, false
                    , 0, 6, -1, -1, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("spearman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 50, false
                    , 0, 7, -1, -1, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("horseman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 0, 80, false
                    , 0, 12, -1, -1, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("swordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 80, false
                    , 0, 11, -1, -1, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("crossbowman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 120, false
                    , 0, 6, 2, 12, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("knight")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 0, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("longswordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 0, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("pikeman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 100, false
                    , 0, 10, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("trebuchet")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 170, false
                    , 0, 6, 2, 20, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("canon")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 250, false
                    , 0, 10, 2, 26, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("cavalry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 0, 260, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("lancer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 0, 220, false
                    , 0, 22, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("rifleman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 200, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("anti-tank gun")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 300, false
                    , 0, 32, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("infantry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 300, false
                    , 0, 36, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false);
            unit = warrior;
        }
        else if (unitName.equals("musketman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 120, false
                    , 0, 16, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("artillery")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 0, 420, false
                    , 0, 16, 32, 3, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("panzer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 5, 5, 0, 450, false
                    , 0, 60, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false);
            unit = warrior;
        }
        else if (unitName.equals("tank")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 0, 450, false
                    , 0, 50, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true);
            unit = warrior;
        }
        else
            return "no unit with this name exists!";
        return this.createUnit(civilization, city, unit, map);
    }
    public String preCreateCity(Matcher matcher, Civilization civilization, ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        matcher.find();
        int tileNumber = Integer.parseInt(matcher.group("tile"));
        return createCity(civilization,tileNumber,map,civilizations);
    }
    public String createCity(Civilization civilization, int tileNumber,ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        if(tileNumber < 0 || tileNumber >= 72)
            return "invalid tile number";

        for(City city : civilization.getCities()){
            for(Tile tile : city.getTiles()){
                if(tile.getTileNumber() == tileNumber){
                    for(Unit unit : tile.getUnits()){
                        if(unit.getCivilization() == civilization){
                            if(unit.isCivilian()){
                                Civilian civilian = (Civilian) unit;
                                if(civilian.isSettler()){
                                    if(checkNeighboursForCreateCity(tile,map,civilizations)){
                                        while(tile.getUnits().size() > 0) {
                                            tile.getUnits().remove(0);
                                        }
                                        City city1 = new City(tile,map);
                                        civilization.getCities().add(city1);
                                        return "city has been created successfully";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return "you can't create city here";
    }
    public boolean checkNeighboursForCreateCity(Tile tile, ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(Tile tempTile : map){
            if(tempTile == tile){
                if(tile.getUnits().size() != 1)
                    return false;
            }
            if(areTilesNeighbour(tile,tempTile)){
                if(tempTile.getUnits().size() > 0)
                    return false;
                if(tempTile.getImprovements().size() > 0)
                    return false;
                if(tempTile.getRailRoads().size() > 0)
                    return false;
                if(tempTile.getRoads().size() > 0)
                    return false;
                if(doesTileBelongToAnyCivilization(tempTile,map,civilizations))
                    return false;
            }
        }
        return true;
    }
    public boolean areTilesNeighbour(Tile tile1, Tile tile2){
        float distance = (float)Math.sqrt(Math.pow(tile1.getX() - tile2.getX(), 2) + Math.pow(tile1.getY() - tile2.getY(), 2));
        if(distance <= tile1.getRadius() * Math.sqrt(3))
            return true;

        return false;
    }
    public String attackTile(Civilization civilization, Warrior warrior,Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }
    // makes parameters for unit behaviours functions
    public String preUnitBehaviour (Matcher matcher, Civilization civilization, ArrayList<Tile> map, String command) {
        String unitName = matcher.group("unitName");
        int index = Integer.parseInt(matcher.group("number"));
        Tile tile = map.get(index);
        ArrayList<Unit> units = tile.getUnits();
        Unit unit = getUnitInTile(units, unitName);

        if (command.equals("sleep")) {
          return  sleepUnit(civilization, unit, map);
        }
        else if (command.equals("alert")) {
            return WarFootingUnit(civilization, unit, map);
        }
        else if (command.equals("fortify")) {
            return boostUnit(civilization, unit, map);
        }
        else if (command.equals("heal")) {
            return boostTillRecoverUnit(civilization, unit, map);
        }
        else if (command.equals("deploy")) {
            return deploymentUnit(civilization, unit, map);
        }
        else if (command.equals("range")) {
            return readyForRangedBattleUnit(civilization, unit, map);
        }
        else if (command.equals("wake")) {
            return wakeUpUnit(civilization, unit, map);
        }
        return "";
    }

    // sleepUnit, .... civilization baraye playeri hast ke alan dare dastor mide
    //TODO ... bayad function marboot be darkhast amaliat va royat doshman dar atraf baraye behavior ha piyade shavad
    public String sleepUnit(Civilization civilization, Unit unit, ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }

        unit.setOnSleep(true);
        str = "selected unit is sleeping";
        return str;
    }
    public String WarFootingUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        unit.setOnWarFooting(true);
        str = "this unit is on standby !";
        return str;
    }
    public String boostUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        Warrior warrior = (Warrior) unit;
        int newDamage = warrior.getDamage() + 1;
        warrior.setDamage(newDamage);
        warrior.setOnBoost(true);
        str = "booster has been activated for this unit !";
        return str;
    }
    public String boostTillRecoverUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        Warrior warrior = (Warrior) unit;
        int newHealth = warrior.getHealth() + 1;
        warrior.setHealth(newHealth);
        warrior.setOnBoostTillRecover(true);
        str = "booster until full recovery has been activated for this unit !";
        return str;
    }

    //if unit tile is city center (tile) return true
    public boolean isTileCityCenter (Civilization civilization, Unit unit) {
        ArrayList<City> cities = civilization.getCities();
        Tile tile = unit.getOrigin();
        for (int i = 0; i < cities.size(); i++) {
            if (tile.equals(cities.get(i).getCenterTile())) return true;
        }
        return false;
    }
    public String deploymentUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (!isTileCityCenter(civilization, unit)) {
            str = "this unit isn't in the city !";
            return str;
        }

        unit.setOnDeployment(true);
        str = "the unit is deployed in city !";
        return str;
    }
    public String readyForRangedBattleUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        ((Warrior)unit).setReadyForRangedBattle(true);
        str = "the unit is ready for ranged battle !";
        return str;
    }
    public String lootTile(Civilization civilization, Warrior warrior, Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String cancelCommand(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String wakeUpUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }

        unit.setOnSleep(false);
        str = "selected unit is awake";
        return str;
    }
    public String deleteUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String recoverUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String preLockCitizen(Matcher matcher,Civilization civilization, ArrayList<Tile> map){
        matcher.find();
        int originTileNumber = Integer.parseInt(matcher.group("origin"));
        int destinationTileNumber = Integer.parseInt(matcher.group("destination"));
        if(originTileNumber >= 72 || originTileNumber < 0 || destinationTileNumber >= 72 || destinationTileNumber < 0)
            return "invalid number";
        if(originTileNumber == destinationTileNumber)
            return "numbers are equal";

        Tile origin = map.get(originTileNumber);
        Tile destination = map.get(destinationTileNumber);
        return lockCitizen(civilization,origin,destination,map);
    }
    public String lockCitizen(Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map){//move citizen from origin to destination
        for(City city : civilization.getCities()){
            for(Tile tile1 : city.getTiles()){
                if(tile1 == origin){
                    for(Tile tile2 : city.getTiles()){
                        if(tile2 == destination){
                            if(tile2.getCitizen() == null){
                                if(tile1.getCitizen() != null){
                                    tile2.setCitizen(tile1.getCitizen());
                                    tile1.setCitizen(null);
                                    return "citizen has been locked successfully";
                                }
                                return "origin tile doesn't have any citizen !";
                            }
                            return "destination tile already has a citizen !";
                        }
                    }
                    return "tiles do not belong to one city !";
                }
            }
        }
        return "tiles do not belong to your civilization !";
    }
    public String prePurchaseTile(Matcher matcher, Civilization civilization, ArrayList<Tile> map,ArrayList<Civilization> civilizations){
        matcher.find();
        int tileNumber = Integer.parseInt(matcher.group("tile"));
        if(tileNumber < 0 || tileNumber >= 72)
            return "invalid number";

        Tile tile = map.get(tileNumber);
        return purchaseTile(civilization,tile,map,civilizations);
    }
    public String purchaseTile(Civilization civilization, Tile tile,ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(City city : civilization.getCities()){
            for(Tile tempTile : city.getTiles()){
                if(areTilesNeighbour(tile,tempTile)){
                    if(tile == tempTile)
                        return "this tile is already yours";
                    if(!doesTileBelongToAnyCivilization(tile,map,civilizations)){
                        if(tile.getUnits().size() == 0 && tile.getImprovements().size() == 0){
                            if(civilization.getGold() >= 50){
                                civilization.addGold(-50);
                                city.getTiles().add(tile);
                                return "purchase tile was successful";
                            }
                            return "you don't have enough gold";
                        }
                    }
                    return "you can't purchase this tile";
                }
            }
        }
        return "this tile isn't neighbour with any of your cities";
    }
    public boolean doesTileBelongToAnyCivilization(Tile tile, ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(Civilization civilization : civilizations){
            for(City city : civilization.getCities()){
                for(Tile tempTile : city.getTiles()){
                    if(tile == tempTile)
                        return true;//it belongs
                }
            }
        }
        return false;//it doesn't
    }
    public StringBuilder showProductionsInProcess(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder showTechnologyMenu(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public String chooseTechnologyToLearn(Civilization civilization, Technology technology,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String changeTechnologyToLearn(Civilization civilization, Technology newTechnology,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String workOnTile(Civilization civilization, int cityNumber, int tileNumber, int citizenNumber, ArrayList<Tile> map){
        City city = civilization.getCities().get(cityNumber);
        ArrayList<Tile> cityTiles = city.getTiles();
        Tile chosenTile = map.get(tileNumber);
        boolean isInRange = false;
        for (int i = 0; i < cityTiles.size(); i++) {
            if (cityTiles.get(i).equals(chosenTile)){
                cityTiles.get(i).setCitizen(city.getCitizens().get(citizenNumber));
                city.getCitizens().get(citizenNumber).setTile(chosenTile);
                isInRange = true;
                break;
            }
            else{
                float x1 = cityTiles.get(i).getX();
                float y1 = cityTiles.get(i).getY();
                float x2 = chosenTile.getX();
                float y2 = chosenTile.getY();
                //9rad3
                if (Math.pow(2, (x2 - x1)) + Math.pow(2, (y2 - y1)) <= 243){
                    if (chosenTile.getCitizen() == null) {
                        city.getCitizens().get(citizenNumber).setTile(chosenTile);
                        chosenTile.setCitizen(city.getCitizens().get(citizenNumber));
                        isInRange = true;
                        break;
                    }
                    else
                        return "there are already a unit in this tile";
                }
            }
        }
        if (isInRange)
            return "citizen is set to work on chosen tile";
        else
            return "this tile isn't your city tiles or city neighbors";
    }
    public Unit preCreateImprovement(int civilianNumber, Civilization civilization){
        ArrayList<City> cities = civilization.getCities();
        ArrayList<Tile> cityTiles = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int j = 0; j < tiles.size(); j++)
                cityTiles.add(tiles.get(j));
        }
        ArrayList<Unit> allUnits = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Unit> units = cityTiles.get(i).getUnits();
            for (int j = 0; j < units.size(); j++)
                allUnits.add(units.get(j));
        }
        return allUnits.get(civilianNumber);
    }
    public String createImprovement(Civilization civilization, Civilian civilian, int tileNumber, String improvementName, ArrayList<Tile> map){
        if (civilian.isWorker()) {
            Tile tile = map.get(tileNumber);
            ArrayList<Technology> techs = civilization.getTechnologies();
            ArrayList<String> technologies = new ArrayList<>();
            for (int i = 0; i < techs.size(); i++)
                technologies.add(techs.get(i).getName());
            if (improvementName.equals("camp")) {//camp duration = 5
                if (tile.getAttribute().isJungle() || tile.isTundra() || tile.isHill() || tile.isDesert()) {
                    if (technologies.contains("trapping")) {
                        Improvement improvement = new Improvement(true, false, false, false, false, false, false, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 5);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "camp can't be build in this tile";
            } else if (improvementName.equals("farm")) {
                if (tile.getAttribute().isRainForest()) {
                    if (technologies.contains("mining tech")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 10);
                    } else
                        return "you don't have the prerequisite technology";
                } else if (tile.getAttribute().isJungle()) {
                    if (technologies.contains("bronze working tech")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 13);
                    } else
                        return "you don't have the prerequisite technology";
                } else if (tile.getAttribute().isMarsh()) {
                    if (technologies.contains("masonry tech")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 12);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "farm can't be build in this tile";
            } else if (improvementName.equals("lumberMill")) {     //duration = 7
                if (tile.getAttribute().isJungle()) {
                    if (technologies.contains("building")) {
                        Improvement improvement = new Improvement(false, false, true, false, false, false, false, false, false, 0, 1, 0);
                        tile.addToImprovementEarnedPercent(improvement, 7);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "lumberMill can't be build in this tile";
            } else if (improvementName.equals("mine")) {       //duration = 14
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isSnow() || tile.isHill() || tile.getAttribute().isJungle() || tile.getAttribute().isRainForest() || tile.getAttribute().isMarsh()) {
                    if (technologies.contains("mining tech")) {
                        Improvement improvement = new Improvement(false, false, false, true, false, false, false, false, false, 0, 1, 0);
                        tile.addToImprovementEarnedPercent(improvement, 14);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "mine can't be build in this tile";
            } else if (improvementName.equals("paddock")) {        //duration = 8
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isHill()) {
                    Improvement improvement = new Improvement(false, false, false, false, true, false, false, false, false, 0, 0, 0);
                    tile.addToImprovementEarnedPercent(improvement, 8);
                } else
                    return "paddock can't be build in this tile";
            } else if (improvementName.equals("agriculture")) {
                if (tile.isPlain() || tile.isMeadow() || tile.getAttribute().isJungle() || tile.getAttribute().isRainForest() || tile.getAttribute().isMarsh() || tile.getAttribute().isPlat()) {
                    if (technologies.contains("date")) {        //duration = 5
                        Improvement improvement = new Improvement(false, false, false, false, false, true, false, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 5);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "agriculture can't be build in this tile";
            } else if (improvementName.equals("stoneMine")) {      //duration = 15
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isHill()) {
                    if (technologies.contains("stone mining tech")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, true, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 15);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "stoneMine can't be build in this tile";
            } else if (improvementName.equals("tradingPost")) {        //duration = 10
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra()) {
                    if (technologies.contains("trapping")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, false, true, false, 0, 0, 1);
                        tile.addToImprovementEarnedPercent(improvement, 10);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "tradingPost can't be build in this tile";
            } else if (improvementName.equals("laboratory")) {     //duration = 20
                //plain, dessert, meadow, tundra, snow
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isSnow()) {
                    if (technologies.contains("engineering")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, false, false, true, 0, 2, 0);
                        tile.addToImprovementEarnedPercent(improvement, 20);
                    } else
                        return "you don't have the prerequisite technology";
                } else
                    return "laboratory can't be build in this tile";
            } else
                return "no improvement with this name exists!";
            civilian.setWorkingTile(tile);
            tile.addUnit(civilian);
            return "improvement created successfully";
        }
        else
            return "only workers can work on improvements";
    }
    // after every turn check for road or rail making in your civilization,,, if work is making ->true if it is removing->false
    public void consumeTurnForRoadMaking (Civilization civilization, ArrayList<Tile> map, boolean typeOfWork) {
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> units = map.get(i).getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if (units.get(i1).getCivilization().equals(civilization) && units.get(i1).isCivilian()) {
                    if (((Civilian) units.get(i1)).isWorker() && map.get(i).sizeOfHashMapRoad() != 0) {
                        int newTurn = map.get(i).getNumberOfTurnsRoad(units.get(i1)) - 1;
                        if (newTurn == 0) {
                            map.get(i).removeWorkerFromRoad(units.get(i1));
                            ((Civilian) units.get(i1)).setWorkingTile(null);
                            map.get(i).setDoesHaveRoad(typeOfWork);
                        } else {
                            map.get(i).setNewNumberForTurnRoad(units.get(i1), newTurn);
                        }
                    }
                        if (((Civilian) units.get(i1)).isWorker() && map.get(i).sizeOfHashMapRail() != 0) {
                            int newTurn = map.get(i).getNumberOfTurnsRail(units.get(i1)) - 1;
                            if (newTurn == 0) {
                                map.get(i).removeWorkerFromRail(units.get(i1));
                                ((Civilian) units.get(i1)).setWorkingTile(null);
                                map.get(i).setDoesHaveRailWay(typeOfWork);
                            } else {
                                map.get(i).setNewNumberForTurnRail(units.get(i1), newTurn);
                            }
                        }
                    }
                }
            }
        }

    public Unit getWorker (Tile tile) {
        ArrayList<Unit> units = tile.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isCivilian()) {
                    return units.get(i);
            }
        }
        return null;
    }
    public String createRoad(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;
        Unit unit = getWorker(tile);
        if (unit == null) {
            str = "this tile doesn't have any worker !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this worker does not belong to you !";
            return str;
        }
        if (!((Civilian)unit).isWorker()) {
            str = "this unit is not worker !";
            return str;
        }
        if (tile.isDoesHaveRoad()) {
            str = "there is already a road on this tile !";
            return str;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            str = "worker is working on something else !";
            return str;
        }

        tile.assignWorkerToRoad(unit, 3);
        ((Civilian)unit).setWorkingTile(tile);
        str = "the road will be ready in 3 turns";
        return str;
    }

    public String createRailRoad(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;
        Unit unit = getWorker(tile);
        if (unit == null) {
            str = "this tile doesn't have any worker !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this worker does not belong to you !";
            return str;
        }
        if (!((Civilian)unit).isWorker()) {
            str = "this unit is not worker !";
            return str;
        }
        if (tile.isDoesHaveRailWay()) {
            str = "there is already a rail way on this tile !";
            return str;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            str = "worker is working on something else !";
            return str;
        }

        tile.assignWorkerToRail(unit, 3);
        ((Civilian)unit).setWorkingTile(tile);
        str = "the rail way will be ready in 3 turns";
        return str;
    }
    public Improvement preRemoveImprovement(String improvementName){
        if (improvementName.equals("camp"))
            return new Improvement(true, false, false, false, false, false, false, false, false, 0, 0, 0);
        else if (improvementName.equals("farm"))
            return new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
        else if (improvementName.equals("lumberMill"))
            return new Improvement(false, false, true, false, false, false, false, false, false, 0, 1, 0);
        else if (improvementName.equals("mine"))
            return new Improvement(false, false, false, true, false, false, false, false, false, 0, 1, 0);
        else if (improvementName.equals("paddock"))
            return new Improvement(false, false, false, false, true, false, false, false, false, 0, 0, 0);
        else if (improvementName.equals("agriculture"))
            return new Improvement(false, false, false, false, false, true, false, false, false, 0, 0, 0);
        else if (improvementName.equals("stoneMine"))
            return new Improvement(false, false, false, false, false, false, true, false, false, 0, 0, 0);
        else if (improvementName.equals("tradingPost"))
            return new Improvement(false, false, false, false, false, false, false, true, false, 0, 0, 1);
        else if (improvementName.equals("laboratory"))
           return new Improvement(false, false, false, false, false, false, false, false, true, 0, 2, 0);
        else
            return null;
    }
    public String removeImprovement(Civilization civilization, Improvement improvement, int tileNumber ,ArrayList<Tile> map){
        ArrayList<City> cities = civilization.getCities();
        ArrayList<Tile> cityTiles = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int j = 0; j < tiles.size(); j++)
                cityTiles.add(tiles.get(j));
        }
        Tile tile = map.get(tileNumber);
        boolean isOurs = false;
        for (int i = 0; i < cityTiles.size(); i++) {
            if (cityTiles.get(i).equals(tile)) {
                isOurs = true;
                break;
            }
        }
        if (!isOurs)
            return "this tile doesn't belong to your civilization";
        ArrayList<Improvement> improvements = tile.getImprovements();
        for (int i = 0; i < improvements.size(); i++)
            if (improvements.get(i).equals(improvement)){
                improvements.remove(i);
                tile.setImprovements(improvements);
                return "improvement deleted successfully";
            }
        return "no such improvement exists!";
    }
    public String removeRoad(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;
        Unit unit = getWorker(tile);
        if (unit == null) {
            str = "this tile doesn't have any worker !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this worker does not belong to you !";
            return str;
        }
        if (!((Civilian)unit).isWorker()) {
            str = "this unit is not worker !";
            return str;
        }
        if (!tile.isDoesHaveRoad()) {
            str = "there is no road on this tile !";
            return str;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            str = "worker is working on something else !";
            return str;
        }

        tile.assignWorkerToRoad(unit, 3);
        ((Civilian)unit).setWorkingTile(tile);
        str = "the road will be removed in 3 turns";
        return str;
    }
    public String removeRailRoad(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;
        Unit unit = getWorker(tile);
        if (unit == null) {
            str = "this tile doesn't have any worker !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this worker does not belong to you !";
            return str;
        }
        if (!((Civilian)unit).isWorker()) {
            str = "this unit is not worker !";
            return str;
        }
        if (!tile.isDoesHaveRailWay()) {
            str = "there is no rail way on this tile !";
            return str;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            str = "worker is working on something else !";
            return str;
        }

        tile.assignWorkerToRail(unit, 3);
        ((Civilian)unit).setWorkingTile(tile);
        str = "the rail way will be removed in 3 turns";
        return str;
    }
    public String cancelImprovementOnProcess(Civilization civilization,Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairImprovement(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairWholeTile(Civilization civilization,Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String updateWarrior(Civilization civilization, Warrior warrior, Warrior newWarrior,ArrayList<Tile> map){
        String str;

        return str;
    }
    public StringBuilder showCurrentScore(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    //TODO
    /*
    public boolean winCheck(){

    }
     */
    public String nextTurn(Civilization civilization, ArrayList<Tile> map){
        String str;

        return str;
    }
}
