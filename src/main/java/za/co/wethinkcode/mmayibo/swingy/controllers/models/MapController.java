package za.co.wethinkcode.mmayibo.swingy.controllers.models;

import za.co.wethinkcode.mmayibo.swingy.enums.EDirection;
import za.co.wethinkcode.mmayibo.swingy.factory.EnemyFactory;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.players.Enemy;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Map;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;
import za.co.wethinkcode.mmayibo.swingy.utils.Formulas;

import java.util.ArrayList;

import static za.co.wethinkcode.mmayibo.swingy.enums.EDirection.EAST;
import static za.co.wethinkcode.mmayibo.swingy.enums.EDirection.WEST;

public class MapController {
    private final Map map;
    private Hero hero;

    public MapController(Map map) {
        this.map = map;
    }

    boolean moveHeroInTheMap(EDirection direction) {
        removePlayer(hero.getPosition());
        if (direction == EAST || direction == WEST)
            hero.getPosition().x += direction.getIncrement();
        else
            hero.getPosition().y += direction.getIncrement();
        return !isEnemyCollision();
    }

    private boolean isEnemyCollision() {
        if (playerExists(hero.getPosition()))
            return true;
        addPlayer(hero);
        return false;
    }

    void addMapValues(Hero hero) {
        this.hero = hero;
        map.getGameMap().clear();
        map.setSize(Formulas.calculateMapSquares(hero.getLevel()));
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies(map.getSize());
        changeThePositionOfTheHeroToBeInTheCenterOfTheMap(hero);
        addPlayers(enemies);
        addPlayer(hero);
    }

    private void changeThePositionOfTheHeroToBeInTheCenterOfTheMap(Hero hero) {
        Position position = hero.getPosition();
        position.x = map.getSize() / 2;
        position.y = map.getSize() / 2;
    }

    private boolean isMoveWithinBounds(int value) {
        return value >=0 && value < map.getSize();
    }

    boolean isMoveWithinBounds(EDirection direction) {
        if (direction == EAST || direction == WEST)
            return isMoveWithinBounds(hero.getPosition().x + direction.getIncrement());
        else
            return isMoveWithinBounds(hero.getPosition().y + direction.getIncrement());
    }

     boolean heroFoundARunAwayPosition() {
        return true;
    }


    private void addPlayer(Position position, AbstractPlayer player) {
        PositionValue positionValue = map.getGameMap().get(position);
        if (positionValue != null)
            clearPositionValueAddPlayer(positionValue, player);
        else
            addNewPositionValueWithPlayer(position, player);
	    map.getGameMap().get(position);
    }
    
    private void addNewPositionValueWithPlayer(Position position, AbstractPlayer player) {
        PositionValue positionValue = new PositionValue();
        positionValue.setOccupier(player);
        map.getGameMap().put(position, positionValue);
    }
    
    private void clearPositionValueAddPlayer(PositionValue positionValue, AbstractPlayer player) {
        positionValue.setOccupier(player);
    }
    
    private void removePlayer(Position position) {
	    PositionValue positionValue = map.getGameMap().get(position);
	    if (positionValue == null)
	    	return;
	    positionValue.setOccupier(null);
	    if (positionValue.getDroppedArtificats().size() == 0)
	    	map.getGameMap().remove(position);
    }

    private void addPlayers(ArrayList<Enemy> enemies) {
        for (AbstractPlayer player : enemies)
            addPlayer(player.getPosition(), player);
    }

    public AbstractPlayer getPlayer(Position position) {
        PositionValue positionValue = map.getGameMap().get(position);
        if (map.getGameMap().get(position) == null)
            return null;
        return positionValue.getOccupier();
    }

    private boolean playerExists(Position position) {
        PositionValue positionValue = map.getGameMap().get(position);
        if (positionValue == null || positionValue.getOccupier() == null)
        	return false;
        
        AbstractPlayer player = positionValue.getOccupier();
        return player.getPosition().hashCode() == position.hashCode()
                && player.getPosition().equals(position);
    }

    void addPlayer(AbstractPlayer player) {
        addPlayer(player.getPosition(), player);
    }
	
	public void addArtificat(Position position, Artifact artifact) {
		PositionValue positionValue = map.getGameMap().get(position);
		if (positionValue != null)
			positionValue.getDroppedArtificats().add(artifact);
	}
    
    public ArrayList<Artifact> getDroppedArtificat() {
        PositionValue positionValue = map.getGameMap().get(hero.getPosition());
    
        if (positionValue == null || positionValue.getDroppedArtificats().isEmpty())
            return null;
        return positionValue.getDroppedArtificats();
    }
	
	public void clearDroppedArtificacts() {
		PositionValue positionValue = map.getGameMap().get(hero.getPosition());
		
		if (positionValue == null || positionValue.getDroppedArtificats().isEmpty())
			return;
		positionValue.getDroppedArtificats().clear();
	}
    
    public void clear() {
        map.getGameMap().clear();
        map.setSize(0);
    }
}
