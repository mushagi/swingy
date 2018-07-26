package controllers;

import models.players.Hero;
import models.players.Player;
import utils.Formulas;

public class HeroController {
    Hero hero;

    void updateExperience(Player playerWonAgainst) {
        int experiencedGained = calculateExperience(playerWonAgainst);
        playerWonAgainst.setExperience(playerWonAgainst.getExperience() + experiencedGained);
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
    }

    private int calculateExperience(Player playerWonAgainst) {
        return 0;
    }
}
