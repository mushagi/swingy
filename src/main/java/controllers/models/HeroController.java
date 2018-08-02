package controllers.models;

import factory.HeroFactory;
import models.players.APlayer;
import models.players.Hero;
import utils.Formulas;

public class HeroController {
    private Hero hero;

    void updateExperience(APlayer playerWonAgainst) {
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

    private int calculateExperience(APlayer playerWonAgainst) {
        return 100 + playerWonAgainst.getExperience();
    }

    Hero createHero(String type, String playerName) {
        Hero hero = HeroFactory.newHero(type, playerName);
        this.hero = hero;
        return hero;
    }
}