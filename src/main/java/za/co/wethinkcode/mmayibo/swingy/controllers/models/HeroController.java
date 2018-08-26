package za.co.wethinkcode.mmayibo.swingy.controllers.models;

import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import za.co.wethinkcode.mmayibo.swingy.factory.HeroFactory;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.utils.Formulas;

import java.util.ArrayList;

public class HeroController {
    private Hero hero;

    void updateExperience(AbstractPlayer playerWonAgainst) {
        int experiencedGained = calculateExperience(playerWonAgainst);
        hero.setExperience(hero.getExperience() + experiencedGained);
    }

    void heroLevelUp() {
        int level = getLevel(hero.getExperience(), hero.getLevel());
        hero.setLevel(level);
    }

    private int getLevel(int experience, int level) {
        if (experience < Formulas.calculateRequiredLevelExperience(level + 1))
            return level;
        return getLevel(experience, ++level);
    }

    void registerHero(Hero hero) {
        this.hero = hero;
        resetHeroHitPoints();
    }

    private void resetHeroHitPoints() {
        hero.setHitPoint(100);
    }

    private int calculateExperience(AbstractPlayer playerWonAgainst) {
        return 100 + playerWonAgainst.getExperience();
    }

    Hero createHero(HeroType type) {
        Hero hero = HeroFactory.newHero(type);
        this.hero = hero;
        return hero;
    }
    
    public void returnToLastPoint() {
        hero.setPosition(hero.getLastPoint());
        hero.getPosition().x = hero.getLastPoint().x;
        hero.getPosition().y = hero.getLastPoint().y;
        hero.setLastPoint(null);
    }
    public void setLastPoint() {
        try {
            hero.setLastPoint((Position) hero.getPosition().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    
    public void addArtificats(ArrayList<Artifact> artifacts) {
        for (Artifact artificat: artifacts)
            hero.getArtifact().add(artificat);
    }
	
	public void setName(String name) {
		hero.setName(name);
	}
}