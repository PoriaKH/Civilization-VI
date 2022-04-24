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
    public void showMap(String ANSI_COLORS[]){//tik
        char block = '\u2588';
        String block1 = "   /" + block + block + block + block + block + block + "\\";
        String block2 = "  /" + block + block + block + block + block + block + block + block + "\\";
        String block3 = " /" + block + block + block + block + block + block + block + block + block + block + "\\";
        String block4 = "|" + block + block + block + block + block + block + block + block + block + block + block + block + "|";
        String block5 = " \\" + block + block + block + block + block + block + block + block + block + block + "/";
        String block6 = "  \\" + block + block + block + block + block + block + block + block + "/";
        String block7 = "   \\" + block + block + block + block + block + block + "/";


        System.out.println( ANSI_COLORS[0] + block1 + "   " +  ANSI_COLORS[11] + block1 + "   " + ANSI_COLORS[22] + block1 + "   " + ANSI_COLORS[33] + block1 + "   " + ANSI_COLORS[44] + block1 + "   " + ANSI_COLORS[55] + block1 + "   " + ANSI_COLORS[66] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block2 + "  " +  ANSI_COLORS[11] + block2 + "  " + ANSI_COLORS[22] + block2 + "  " + ANSI_COLORS[33] + block2 + "  " + ANSI_COLORS[44] + block2 + "  " + ANSI_COLORS[55] + block2 + "  " + ANSI_COLORS[66] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block3 + " " +  ANSI_COLORS[11] + block3 +  " " + ANSI_COLORS[22] + block3 + " " + ANSI_COLORS[33] + block3 + " " + ANSI_COLORS[44] + block3 + " " + ANSI_COLORS[55] + block3 + " " + ANSI_COLORS[66] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block4 +  ANSI_COLORS[11] + block4 + ANSI_COLORS[22] +  block4 + ANSI_COLORS[33] + block4 + ANSI_COLORS[44] + block4 + ANSI_COLORS[55] + block4 + ANSI_COLORS[66] + block4 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block5 + " " +  ANSI_COLORS[11] + block5 +  " " + ANSI_COLORS[22] + block5 + " " + ANSI_COLORS[33] + block5 + " " + ANSI_COLORS[44] + block5 + " " + ANSI_COLORS[55] + block5 + " " + ANSI_COLORS[66] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block6 + "  " +  ANSI_COLORS[11] + block6 + "  " + ANSI_COLORS[22] + block6 + "  " + ANSI_COLORS[33] + block6 + "  " + ANSI_COLORS[44] + block6 + "  " + ANSI_COLORS[55] + block6 + "  " + ANSI_COLORS[66] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[0] + block7 + "   " +  ANSI_COLORS[11] + block7 +  "   " + ANSI_COLORS[22] + block7 + "   " + ANSI_COLORS[33] + block7 + "   " + ANSI_COLORS[44] + block7 + "   " + ANSI_COLORS[55] + block7 + "   " + ANSI_COLORS[66] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[6] + "       " + block1 + ANSI_COLORS[17] + "   " + block1 + ANSI_COLORS[28] + "   " + block1 + ANSI_COLORS[39] + "   " + block1 + ANSI_COLORS[50] + "   " + block1 + ANSI_COLORS[61] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block2 + ANSI_COLORS[17] + "  " + block2 + ANSI_COLORS[28] + "  " + block2 + ANSI_COLORS[39] + "  " + block2 + ANSI_COLORS[50] + "  " + block2 + ANSI_COLORS[61] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block3 + ANSI_COLORS[17] + " " + block3 + ANSI_COLORS[28] +  " " + block3 + ANSI_COLORS[39] + " " + block3 + ANSI_COLORS[50] + " " + block3 + ANSI_COLORS[61] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block4 + ANSI_COLORS[17] + block4 + ANSI_COLORS[28] +  block4 + ANSI_COLORS[39] + block4 + ANSI_COLORS[50] + block4 + ANSI_COLORS[61] + block4 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block5 + ANSI_COLORS[17] + " " + block5 + ANSI_COLORS[28] +  " " + block5 + ANSI_COLORS[39] + " " + block5 + ANSI_COLORS[50] + " " + block5 +  ANSI_COLORS[61] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block6 + ANSI_COLORS[17] + "  " + block6 + ANSI_COLORS[28] + "  " + block6 + ANSI_COLORS[39] + "  " + block6 + ANSI_COLORS[50] + "  " + block6 + ANSI_COLORS[61] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[6] + "       " + block7 + ANSI_COLORS[17] + "   " + block7 + ANSI_COLORS[28] +  "   " + block7 + ANSI_COLORS[39] + "   " + block7 + ANSI_COLORS[50] + "   " + block7 + ANSI_COLORS[61] + "   " + block7 + ANSI_RESET);



        System.out.println( ANSI_COLORS[1] + block1 + "   " +  ANSI_COLORS[12] + block1 + "   " + ANSI_COLORS[23] + block1 + "   " + ANSI_COLORS[34] + block1 + "   " + ANSI_COLORS[45] + block1 + "   " + ANSI_COLORS[56] + block1 + "   " + ANSI_COLORS[67] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block2 + "  " +  ANSI_COLORS[12] + block2 + "  " + ANSI_COLORS[23] + block2 + "  " + ANSI_COLORS[34] + block2 + "  " + ANSI_COLORS[45] + block2 + "  " + ANSI_COLORS[56] + block2 + "  " + ANSI_COLORS[67] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block3 + " " +  ANSI_COLORS[12] + block3 +  " " + ANSI_COLORS[23] + block3 + " " + ANSI_COLORS[34] + block3 + " " + ANSI_COLORS[45] + block3 + " " + ANSI_COLORS[56] + block3 + " " + ANSI_COLORS[67] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block4 +  ANSI_COLORS[12] + block4 + ANSI_COLORS[23] +  block4 + ANSI_COLORS[34] + block4 + ANSI_COLORS[45] + block4 + ANSI_COLORS[56] + block4 + ANSI_COLORS[67] + block4 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block5 + " " +  ANSI_COLORS[12] + block5 +  " " + ANSI_COLORS[23] + block5 + " " + ANSI_COLORS[34] + block5 + " " + ANSI_COLORS[45] + block5 + " " + ANSI_COLORS[56] + block5 + " " + ANSI_COLORS[67] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block6 + "  " +  ANSI_COLORS[12] + block6 + "  " + ANSI_COLORS[23] + block6 + "  " + ANSI_COLORS[34] + block6 + "  " + ANSI_COLORS[45] + block6 + "  " + ANSI_COLORS[56] + block6 + "  " + ANSI_COLORS[67] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[1] + block7 + "   " +  ANSI_COLORS[12] + block7 +  "   " + ANSI_COLORS[23] + block7 + "   " + ANSI_COLORS[34] + block7 + "   " + ANSI_COLORS[45] + block7 + "   " + ANSI_COLORS[56] + block7 + "   " + ANSI_COLORS[67] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[7] + "       " + block1 + ANSI_COLORS[18] + "   " + block1 + ANSI_COLORS[29] + "   " + block1 + ANSI_COLORS[40] + "   " + block1 + ANSI_COLORS[51] + "   " + block1 + ANSI_COLORS[62] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block2 + ANSI_COLORS[18] + "  " + block2 + ANSI_COLORS[29] + "  " + block2 + ANSI_COLORS[40] + "  " + block2 + ANSI_COLORS[51] + "  " + block2 + ANSI_COLORS[62] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block3 + ANSI_COLORS[18] + " " + block3 + ANSI_COLORS[29] +  " " + block3 + ANSI_COLORS[40] + " " + block3 + ANSI_COLORS[51] + " " + block3 + ANSI_COLORS[62] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block4 + ANSI_COLORS[18] + block4 + ANSI_COLORS[29] +  block4 + ANSI_COLORS[40] + block4 + ANSI_COLORS[51] + block4 + ANSI_COLORS[62] + block4 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block5 + ANSI_COLORS[18] + " " + block5 + ANSI_COLORS[29] +  " " + block5 + ANSI_COLORS[40] + " " + block5 + ANSI_COLORS[51] + " " + block5 +  ANSI_COLORS[62] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block6 + ANSI_COLORS[18] + "  " + block6 + ANSI_COLORS[29] + "  " + block6 + ANSI_COLORS[40] + "  " + block6 + ANSI_COLORS[51] + "  " + block6 + ANSI_COLORS[62] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[7] + "       " + block7 + ANSI_COLORS[18] + "   " + block7 + ANSI_COLORS[29] +  "   " + block7 + ANSI_COLORS[40] + "   " + block7 + ANSI_COLORS[51] + "   " + block7 + ANSI_COLORS[62] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[2] + block1 + "   " +  ANSI_COLORS[13] + block1 + "   " + ANSI_COLORS[24] + block1 + "   " + ANSI_COLORS[35] + block1 + "   " + ANSI_COLORS[46] + block1 + "   " + ANSI_COLORS[57] + block1 + "   " + ANSI_COLORS[68] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block2 + "  " +  ANSI_COLORS[13] + block2 + "  " + ANSI_COLORS[24] + block2 + "  " + ANSI_COLORS[35] + block2 + "  " + ANSI_COLORS[46] + block2 + "  " + ANSI_COLORS[57] + block2 + "  " + ANSI_COLORS[68] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block3 + " " +  ANSI_COLORS[13] + block3 +  " " + ANSI_COLORS[24] + block3 + " " + ANSI_COLORS[35] + block3 + " " + ANSI_COLORS[46] + block3 + " " + ANSI_COLORS[57] + block3 + " " + ANSI_COLORS[68] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block4 +  ANSI_COLORS[13] + block4 + ANSI_COLORS[24] +  block4 + ANSI_COLORS[35] + block4 + ANSI_COLORS[46] + block4 + ANSI_COLORS[57] + block4 + ANSI_COLORS[68] + block4 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block5 + " " +  ANSI_COLORS[13] + block5 +  " " + ANSI_COLORS[24] + block5 + " " + ANSI_COLORS[35] + block5 + " " + ANSI_COLORS[46] + block5 + " " + ANSI_COLORS[57] + block5 + " " + ANSI_COLORS[68] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block6 + "  " +  ANSI_COLORS[13] + block6 + "  " + ANSI_COLORS[24] + block6 + "  " + ANSI_COLORS[35] + block6 + "  " + ANSI_COLORS[46] + block6 + "  " + ANSI_COLORS[57] + block6 + "  " + ANSI_COLORS[68] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[2] + block7 + "   " +  ANSI_COLORS[13] + block7 +  "   " + ANSI_COLORS[24] + block7 + "   " + ANSI_COLORS[35] + block7 + "   " + ANSI_COLORS[46] + block7 + "   " + ANSI_COLORS[57] + block7 + "   " + ANSI_COLORS[68] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[8] + "       " + block1 + ANSI_COLORS[19] + "   " + block1 + ANSI_COLORS[30] + "   " + block1 + ANSI_COLORS[41] + "   " + block1 + ANSI_COLORS[52] + "   " + block1 + ANSI_COLORS[63] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block2 + ANSI_COLORS[19] + "  " + block2 + ANSI_COLORS[30] + "  " + block2 + ANSI_COLORS[41] + "  " + block2 + ANSI_COLORS[52] + "  " + block2 + ANSI_COLORS[63] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block3 + ANSI_COLORS[19] + " " + block3 + ANSI_COLORS[30] +  " " + block3 + ANSI_COLORS[41] + " " + block3 + ANSI_COLORS[52] + " " + block3 + ANSI_COLORS[63] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block4 + ANSI_COLORS[19] + block4 + ANSI_COLORS[30] +  block4 + ANSI_COLORS[41] + block4 + ANSI_COLORS[52] + block4 + ANSI_COLORS[63] + block4 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block5 + ANSI_COLORS[19] + " " + block5 + ANSI_COLORS[30] +  " " + block5 + ANSI_COLORS[41] + " " + block5 + ANSI_COLORS[52] + " " + block5 +  ANSI_COLORS[63] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block6 + ANSI_COLORS[19] + "  " + block6 + ANSI_COLORS[30] + "  " + block6 + ANSI_COLORS[41] + "  " + block6 + ANSI_COLORS[52] + "  " + block6 + ANSI_COLORS[63] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[8] + "       " + block7 + ANSI_COLORS[19] + "   " + block7 + ANSI_COLORS[30] +  "   " + block7 + ANSI_COLORS[41] + "   " + block7 + ANSI_COLORS[52] + "   " + block7 + ANSI_COLORS[63] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[3] + block1 + "   " +  ANSI_COLORS[14] + block1 + "   " + ANSI_COLORS[25] + block1 + "   " + ANSI_COLORS[36] + block1 + "   " + ANSI_COLORS[47] + block1 + "   " + ANSI_COLORS[58] + block1 + "   " + ANSI_COLORS[69] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block2 + "  " +  ANSI_COLORS[14] + block2 + "  " + ANSI_COLORS[25] + block2 + "  " + ANSI_COLORS[36] + block2 + "  " + ANSI_COLORS[47] + block2 + "  " + ANSI_COLORS[58] + block2 + "  " + ANSI_COLORS[69] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block3 + " " +  ANSI_COLORS[14] + block3 +  " " + ANSI_COLORS[25] + block3 + " " + ANSI_COLORS[36] + block3 + " " + ANSI_COLORS[47] + block3 + " " + ANSI_COLORS[58] + block3 + " " + ANSI_COLORS[69] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block4 +  ANSI_COLORS[14] + block4 + ANSI_COLORS[25] +  block4 + ANSI_COLORS[36] + block4 + ANSI_COLORS[47] + block4 + ANSI_COLORS[58] + block4 + ANSI_COLORS[69] + block4 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block5 + " " +  ANSI_COLORS[14] + block5 +  " " + ANSI_COLORS[25] + block5 + " " + ANSI_COLORS[36] + block5 + " " + ANSI_COLORS[47] + block5 + " " + ANSI_COLORS[58] + block5 + " " + ANSI_COLORS[69] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block6 + "  " +  ANSI_COLORS[14] + block6 + "  " + ANSI_COLORS[25] + block6 + "  " + ANSI_COLORS[36] + block6 + "  " + ANSI_COLORS[47] + block6 + "  " + ANSI_COLORS[58] + block6 + "  " + ANSI_COLORS[69] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[3] + block7 + "   " +  ANSI_COLORS[14] + block7 +  "   " + ANSI_COLORS[25] + block7 + "   " + ANSI_COLORS[36] + block7 + "   " + ANSI_COLORS[47] + block7 + "   " + ANSI_COLORS[58] + block7 + "   " + ANSI_COLORS[69] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[9] + "       " + block1 + ANSI_COLORS[20] + "   " + block1 + ANSI_COLORS[31] + "   " + block1 + ANSI_COLORS[42] + "   " + block1 + ANSI_COLORS[53] + "   " + block1 + ANSI_COLORS[64] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block2 + ANSI_COLORS[20] + "  " + block2 + ANSI_COLORS[31] + "  " + block2 + ANSI_COLORS[42] + "  " + block2 + ANSI_COLORS[53] + "  " + block2 + ANSI_COLORS[64] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block3 + ANSI_COLORS[20] + " " + block3 + ANSI_COLORS[31] +  " " + block3 + ANSI_COLORS[42] + " " + block3 + ANSI_COLORS[53] + " " + block3 + ANSI_COLORS[64] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block4 + ANSI_COLORS[20] + block4 + ANSI_COLORS[31] +  block4 + ANSI_COLORS[42] + block4 + ANSI_COLORS[53] + block4 + ANSI_COLORS[64] + block4 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block5 + ANSI_COLORS[20] + " " + block5 + ANSI_COLORS[31] +  " " + block5 + ANSI_COLORS[42] + " " + block5 + ANSI_COLORS[53] + " " + block5 +  ANSI_COLORS[64] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block6 + ANSI_COLORS[20] + "  " + block6 + ANSI_COLORS[31] + "  " + block6 + ANSI_COLORS[42] + "  " + block6 + ANSI_COLORS[53] + "  " + block6 + ANSI_COLORS[64] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[9] + "       " + block7 + ANSI_COLORS[20] + "   " + block7 + ANSI_COLORS[31] +  "   " + block7 + ANSI_COLORS[42] + "   " + block7 + ANSI_COLORS[53] + "   " + block7 + ANSI_COLORS[64] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[4] + block1 + "   " +  ANSI_COLORS[15] + block1 + "   " + ANSI_COLORS[26] + block1 + "   " + ANSI_COLORS[37] + block1 + "   " + ANSI_COLORS[48] + block1 + "   " + ANSI_COLORS[59] + block1 + "   " + ANSI_COLORS[70] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block2 + "  " +  ANSI_COLORS[15] + block2 + "  " + ANSI_COLORS[26] + block2 + "  " + ANSI_COLORS[37] + block2 + "  " + ANSI_COLORS[48] + block2 + "  " + ANSI_COLORS[59] + block2 + "  " + ANSI_COLORS[70] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block3 + " " +  ANSI_COLORS[15] + block3 +  " " + ANSI_COLORS[26] + block3 + " " + ANSI_COLORS[37] + block3 + " " + ANSI_COLORS[48] + block3 + " " + ANSI_COLORS[59] + block3 + " " + ANSI_COLORS[70] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block4 +  ANSI_COLORS[15] + block4 + ANSI_COLORS[26] +  block4 + ANSI_COLORS[37] + block4 + ANSI_COLORS[48] + block4 + ANSI_COLORS[59] + block4 + ANSI_COLORS[70] + block4 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block5 + " " +  ANSI_COLORS[15] + block5 +  " " + ANSI_COLORS[26] + block5 + " " + ANSI_COLORS[37] + block5 + " " + ANSI_COLORS[48] + block5 + " " + ANSI_COLORS[59] + block5 + " " + ANSI_COLORS[70] + block5 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block6 + "  " +  ANSI_COLORS[15] + block6 + "  " + ANSI_COLORS[26] + block6 + "  " + ANSI_COLORS[37] + block6 + "  " + ANSI_COLORS[48] + block6 + "  " + ANSI_COLORS[59] + block6 + "  " + ANSI_COLORS[70] + block6 + ANSI_RESET);
        System.out.println( ANSI_COLORS[4] + block7 + "   " +  ANSI_COLORS[15] + block7 +  "   " + ANSI_COLORS[26] + block7 + "   " + ANSI_COLORS[37] + block7 + "   " + ANSI_COLORS[48] + block7 + "   " + ANSI_COLORS[59] + block7 + "   " + ANSI_COLORS[70] + block7 + ANSI_RESET);

        System.out.println(ANSI_COLORS[10] + "       " + block1 + ANSI_COLORS[21] + "   " + block1 + ANSI_COLORS[32] + "   " + block1 + ANSI_COLORS[43] + "   " + block1 + ANSI_COLORS[54] + "   " + block1 + ANSI_COLORS[65] + "   " + block1 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block2 + ANSI_COLORS[21] + "  " + block2 + ANSI_COLORS[32] + "  " + block2 + ANSI_COLORS[43] + "  " + block2 + ANSI_COLORS[54] + "  " + block2 + ANSI_COLORS[65] + "  " + block2 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block3 + ANSI_COLORS[21] + " " + block3 + ANSI_COLORS[32] +  " " + block3 + ANSI_COLORS[43] + " " + block3 + ANSI_COLORS[54] + " " + block3 + ANSI_COLORS[65] + " " + block3 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block4 + ANSI_COLORS[21] + block4 + ANSI_COLORS[32] +  block4 + ANSI_COLORS[43] + block4 + ANSI_COLORS[54] + block4 + ANSI_COLORS[65] + block4 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block5 + ANSI_COLORS[21] + " " + block5 + ANSI_COLORS[32] +  " " + block5 + ANSI_COLORS[43] + " " + block5 + ANSI_COLORS[54] + " " + block5 +  ANSI_COLORS[65] + " " + block5 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block6 + ANSI_COLORS[21] + "  " + block6 + ANSI_COLORS[32] + "  " + block6 + ANSI_COLORS[43] + "  " + block6 + ANSI_COLORS[54] + "  " + block6 + ANSI_COLORS[65] + "  " + block6 + ANSI_RESET);
        System.out.println(ANSI_COLORS[10] + "       " + block7 + ANSI_COLORS[21] + "   " + block7 + ANSI_COLORS[32] +  "   " + block7 + ANSI_COLORS[43] + "   " + block7 + ANSI_COLORS[54] + "   " + block7 + ANSI_COLORS[65] + "   " + block7 + ANSI_RESET);


        System.out.println( ANSI_COLORS[5] + block1 + "   " +  ANSI_COLORS[16] + block1 + "   " + ANSI_COLORS[27] + block1 + "   " + ANSI_COLORS[38] + block1 + "   " + ANSI_COLORS[49] + block1 + "   " + ANSI_COLORS[60] + block1 + "   " + ANSI_COLORS[71] + block1 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block2 + "  " +  ANSI_COLORS[16] + block2 + "  " + ANSI_COLORS[27] + block2 + "  " + ANSI_COLORS[38] + block2 + "  " + ANSI_COLORS[49] + block2 + "  " + ANSI_COLORS[60] + block2 + "  " + ANSI_COLORS[71] + block2 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block3 + " " +  ANSI_COLORS[16] + block3 +  " " + ANSI_COLORS[27] + block3 + " " + ANSI_COLORS[38] + block3 + " " + ANSI_COLORS[49] + block3 + " " + ANSI_COLORS[60] + block3 + " " + ANSI_COLORS[71] + block3 + ANSI_RESET);
        System.out.println( ANSI_COLORS[5] + block4 +  ANSI_COLORS[16] + block4 + ANSI_COLORS[27] +  block4 + ANSI_COLORS[38] + block4 + ANSI_COLORS[49] + block4 + ANSI_COLORS[60] + block4 + ANSI_COLORS[71] + block4 + ANSI_RESET);
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
    public String moveUnit(Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map, Unit unit){
        String str;
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
        int i = 0;
        while (true) {
            if (i == unit.getPath().size() - 1) {
                unit.setMp(unit.getConstantMP());
                unit.setPath(null);
                str = "unit reached the destination !";
                break;
            }

            Tile originTile = unit.getPath().get(i).tile;
            Tile destinationTile = unit.getPath().get(i + 1).tile;

            if (unit.getMp() >= destinationTile.getMpCost()) {
                originTile.removeUnit(unit);
                destinationTile.addUnit(unit);
                int newMP = unit.getMp() - destinationTile.getMpCost();
                unit.getPath().remove(i);
                unit.setMp(newMP);
                i++;
            }
            else {
                str = "unit mp isn't enough, wait until next turn !";
                break;
            }
        }
        return str;
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

    public City findTile (float x, float y, ArrayList<Tile> map, Civilization civilization) {
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
          ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int i1 = 0; i1 < tiles.size(); i1++) {
                if (tiles.get(i1).getX() == x &&
                        tiles.get(i1).getY() == y ) {
                    return cities.get(i);
                }
            }
        }
        return null;
    }
// TODO ... duration dorost set nashode 100 gozashtam felan
    public void preUnitMaker (Matcher matcher, Civilization civilization, ArrayList<Tile> map) {
        matcher.find();
        String unitName = matcher.group("unitName").toLowerCase();
        float x = Float.parseFloat(matcher.group("x"));
        float y = Float.parseFloat(matcher.group("y"));
        City city = findTile(x, y, map, civilization);

        if (unitName.equals("archer")) {
           Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 70, false
                   , 0, 4, 2, 6, false, false, true, false,
                   false, false, false, false, false, false, false,
                   false, false, false, false, false, false, false,
                   false, false, false, false, false);
           createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("chariot archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 60, false
                    , 0, 3, 2, 6, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("scout")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 25, false
                    , 0, 4, -1, -1, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("settler")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 100, 89, true, false, true);
            createUnit(civilization, city, civilian, map);
        }
        else if (unitName.equals("worker")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 100, 70, true, true, false);
            createUnit(civilization, city, civilian, map);
        }
        else if (unitName.equals("spearman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 50, false
                    , 0, 7, -1, -1, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("warrior")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 40, false
                    , 0, 6, -1, -1, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("catapult")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 100, false
                    , 0, 4, 2, 14, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("horseman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 80, false
                    , 0, 12, -1, -1, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("swordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 80, false
                    , 0, 11, -1, -1, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("crossbowman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 120, false
                    , 0, 6, 2, 12, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("knight")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("longswordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("pikeman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 100, false
                    , 0, 10, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("trebuchet")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 170, false
                    , 0, 6, 2, 20, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("canon")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 250, false
                    , 0, 10, 2, 26, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("cavalry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 100, 260, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("lancer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 220, false
                    , 0, 22, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("musketman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 120, false
                    , 0, 16, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("rifleman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 200, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("anti-tank gun")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 300, false
                    , 0, 32, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("artillery")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 420, false
                    , 0, 16, 32, 3, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("infantry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 100, 300, false
                    , 0, 36, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("panzer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 5, 5, 100, 450, false
                    , 0, 60, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false);
            createUnit(civilization, city, warrior, map);
        }
        else if (unitName.equals("tank")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 100, 450, false
                    , 0, 50, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true);
            createUnit(civilization, city, warrior, map);
        }
        else {
            createUnit(civilization, city, null, map);
        }
    }

    public String createUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "this unit name does not exit !";
            return str;
        }

        if (city == null) {
            str = "this tile does not belong to your cities !";
            return str;
        }

        if (unit.getGoldCost() > city.getGold()) {
            str = "your gold is not enough !";
            return str;
        }

        if (!unit.isCivilian() && !isTechnologyAvailableForUnit (unit, civilization)) {
            str = "you don't have necessary technology !";
            return str;
        }

        if (!unit.isCivilian() && !isResourceAvailableForUnit (unit, city)) {
            str = "you don't have necessary resource !";
            return str;
        }

        Tile centerTile = city.getCenterTile();
        if (!unit.isCivilian() && isUnitWarrior (centerTile)) {
            str = "there is a military unit !";
            return str;
        }

        if (unit.isCivilian() && isUnitCivilian (centerTile)) {
            str = "there is a civilian unit !";
            return str;
        }

        centerTile.addUnit(unit);
        str = "unit created !";
        return str;
    }
    public String purchaseUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createCity(Civilization civilization, Civilian civilian,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String attackTile(Civilization civilization, Warrior warrior,Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }
    // sleepUnit, .... civilization baraye playeri hast ke alan dare dastor mide
    //TODO ... bayad function marboot be darkhast amaliat va royat doshman dar atraf baraye behavior ha piyade shavad
    public String sleepUnit(Civilization civilization, Unit unit, ArrayList<Tile> map, Tile selected){
        String str;

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
    public String lockCitizen(Civilization civilization, Citizen citizen, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String unLockCitizen(Civilization civilization, Citizen citizen,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String purchaseTile(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
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
    public String workOnTile(Civilization civilization, City city, Citizen citizen,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createImprovement(Civilization civilization, Civilian civilian, Tile tile,Improvement improvement,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createRoad(Civilization civilization,Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createRailRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeImprovement(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeRailRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

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
    public StringBuilder nextTurn(Civilization civilization){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
}
