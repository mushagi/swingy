package models.players;

import org.junit.jupiter.api.Test;d import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {


    @Test
    void getLevel() {
        Hero hero = new Hero("Mushagi");
        assertEquals("Mushagi", hero.getName());    }

}