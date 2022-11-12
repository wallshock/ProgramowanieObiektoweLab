package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    public GrassField(int p){
        this.grassList = new ArrayList<Grass>();
        this.lowerBound = new Vector2d(0, 0);
        this.upperBound = new Vector2d((int)Math.sqrt(p*10), (int)Math.sqrt(p*10));
        placeGrass(p);
        updateMap();

    }

    private void placeGrass(int grassLimit) {
        Random rand = new Random();
        int Max = (int) Math.sqrt(10 * grassLimit) + 1;
        int i = 0;
        while (i < grassLimit) {
            int randX = rand.nextInt(Max);
            int randY = rand.nextInt(Max);
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (objectAt(grassPosition) == null) {
                grassList.add(new Grass(grassPosition));
                i++;
            }
        }
    }


    public void updateMap(){
        this.lowerBound= grassList.get(0).getPosition();
        this.upperBound= grassList.get(0).getPosition();
        for (Animal animal : animalList){
            this.lowerBound = lowerBound.lowerLeft(animal.getPosition());
            this.upperBound = upperBound.upperRight(animal.getPosition());
        }


        for (Grass grass : grassList){
            this.lowerBound = lowerBound.lowerLeft(grass.getPosition());
            this.upperBound = upperBound.upperRight(grass.getPosition());
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass g : grassList) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object a = super.objectAt(position);
        if (a != null) {
            return a;
        }
        for (Grass g : grassList) {
            if (g.getPosition().equals(position)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        if(obj instanceof Grass){
            for(int i=0;i<grassList.size();i++){
                if(grassList.get(i).getPosition().equals(((Grass) obj).getPosition())){
                    grassList.remove(i);
                    placeGrass(1);
                    break;
                }
            }
        }
        return obj == null || obj instanceof Grass;
    }
}
