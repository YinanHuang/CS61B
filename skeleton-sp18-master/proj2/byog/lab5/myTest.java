package byog.lab5;

import byog.TileEngine.*;
public class myTest {
    public static void main(String[] args){
        int WIDTH = 50;
        int HEIGHT = 50;
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        stuffCreation.addLine(3,5,5, Tileset.FLOWER, world, "Horizontal");
        String string = TETile.toString(world);
        System.out.print(string);
        //ter.renderFrame(world);
    }
}
