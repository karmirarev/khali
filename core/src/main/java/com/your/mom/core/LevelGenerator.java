//package com.your.mom.core;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.your.mom.Khali;
//import com.your.mom.Position;
//import com.your.mom.Room;
//
//import java.util.HashMap;
//
//public class LevelGenerator implements Screen {
//    final Khali game;
//    private Texture floor;
//    private Texture door;
//
//    private Room room;
//    private Position position;
//
//    HashMap<Position, Room> roomMap = new HashMap<Position, Room>();
//
//    public LevelGenerator(Room room, Position position, Khali game) {
//        this.game = game;
//        this.room = room;
//
//        floor = new Texture("floor.png");
//        door = new Texture("door.png");
//    }
//
//    // create the starting room
//    // when game starts call this with event listener?
//    public void SetRoom(Room room, Position position) {
//        if (!roomMap.containsKey(position)) {
//            roomMap.put(position, new Room());
//            SetDoors();
//        }
//        GenerateNeighborRooms();
//        // further: check game state and update the new room generation
//    }
//
//    private void GenerateNeighborRooms() {
//        // generate the 4 neighboring rooms
//    }
//
//    private void SetDoors() {
//        if (roomMap.size() == 1) {
//            // set the 4 doors
//
//        }
//        else {
//            // check sides from position
//            // check free busy sides
//            // place the doors according to the new calculation
//        }
//    }
//
//    public void render() {
//        draw();
//    }
//
//    private void draw() {
////        game.viewport.apply();
////        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
//
//        game.batch.begin();
////        float midWidth = (background.getWidth() - floor.getWidth()) / 2;
////        float midHeight = (background.getHeight() - floor.getHeight()) / 2;
//        game.batch.draw(floor, 0, 0);
//        PlaceDoors();
//        game.batch.end();
//    }
//
//    private void PlaceDoors() {
//        float midWidth = (Gdx.graphics.getWidth() - floor.getWidth()) / 2;
//        float midHeight = (Gdx.graphics.getHeight() - floor.getHeight()) / 2;
//        float midFloorWidth = floor.getWidth() / 2;
//        float midFloorHeight = floor.getHeight() / 2;
//
//        Sprite doorSprite = new Sprite(door);
//        doorSprite.setSize(door.getWidth(), door.getHeight());
//        doorSprite.setOriginCenter();
//
//        // top door
//        doorSprite.setX(midWidth + midFloorWidth - door.getWidth() / 2f);
//        doorSprite.setY(midHeight + floor.getHeight() - door.getHeight() / 2f);
//        doorSprite.setRotation(0);
//        doorSprite.draw(game.batch);
//
//        // bottom door
//        doorSprite.setX(midWidth + midFloorWidth - door.getWidth() / 2f);
//        doorSprite.setY(midHeight - door.getHeight() / 2f);
//        doorSprite.setRotation(180);
//        doorSprite.draw(game.batch);
//
//        // left door
//        doorSprite.setX(midWidth - door.getWidth() / 2f);
//        doorSprite.setY(midHeight + midFloorHeight - door.getHeight() / 2f);
//        doorSprite.setRotation(90);
//        doorSprite.draw(game.batch);
//
//        // right door
//        doorSprite.setX(midWidth + floor.getWidth() - door.getWidth() / 2f);
//        doorSprite.setY(midHeight + midFloorHeight - door.getHeight() / 2f);
//        doorSprite.setRotation(270);
//        doorSprite.draw(game.batch);
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        floor.dispose();
//        door.dispose();
//    }
//}
