package byog.TileEngine;

public class stuffCreation {

    // add a Line to the world, from (positionX, positionY)
    public static void addLine(int length, int positionX, int positionY, TETile tile,
                                 TETile[][] world, String direction){
        if(positionX > world.length || positionX < 0 || positionY >world[0].length || positionY < 0){
            throw new RuntimeException("The line to be created is out of the world!");
        }
        int dx = 0, dy = 0;
        if(direction.equals("Vertical")){
            length = Math.min(length, world[0].length + 1 - positionY);
            for(dy = 0; dy < length;dy++){
                world[positionX + dx][positionY + dy] = tile;
            }
        }
        if(direction.equals("Horizontal")){
            length = Math.min(length, world.length + 1 - positionX);
            for(dx = 0; dx < length;dx++){
                world[positionX + dx][positionY + dy] = tile;
            }
        }
    }
    // default addLine
    public static void addLine(int length, int positionX, int positionY, TETile tile,
                               TETile[][] world){
        if(positionX > world.length || positionX < 0 || positionY >world[0].length || positionY < 0){
            throw new RuntimeException("The line to be created is out of the world!");
        }
        int dx = 0;
        length = Math.min(length, world.length + 1 - positionX);
        for(dx = 0; dx < length;dx++){
            world[positionX + dx][positionY] = tile;
        }
    }

    private static void createHexagon(int size, int positionX, int positionY, TETile[][] world){

    }
    public static void addHexagon(int size, int positionX, int positionY, TETile tile,
                                  TETile[][] world){
        for(int i = 0;i < size;i++){
            addLine(size + 2 * i, positionX - i, positionY + i, tile, world);
        }
        for(int i = 0;i < size;i++){
            addLine(3 * size -2 - 2*i, positionX - size + 1 + i,
                    positionY + size + i, tile, world);
        }
    }
}
