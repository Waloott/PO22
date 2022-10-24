package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void testOptionsParser(){
        OptionsParser o = new OptionsParser();
        MoveDirection[] directions = o.parse(new String[]{"a","r","f","f","x","left","u","backward"});
        assertArrayEquals(new MoveDirection[] {MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD}, directions);

        MoveDirection[] directions2 = o.parse(new String[]{"left","right","backward","forward","x","x","l","l","b","o","f","r"});
        assertArrayEquals(new MoveDirection[] {MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.RIGHT},directions2);
    }

    @Test
    public void testAnimalMovement(){
        Animal a = new Animal();

        assertEquals("Północ, (2,2)",a.toString());

        OptionsParser o = new OptionsParser();
        MoveDirection[] moves = o.parse(new String[]{"f","b","b","b","b","b","l"});
        for (MoveDirection move : moves) a.move(move);
        assertEquals("Zachód, (2,0)",a.toString());

        MoveDirection[] moves2 = o.parse(new String[]{"right","right","f","f","f","f","f","f"});
        for (MoveDirection move : moves2) a.move(move);
        assertEquals("Wschód, (4,0)", a.toString());

        MoveDirection[] moves3 = o.parse(new String[]{"b","b","r","f","f","l","l","b","f","f","r","r"});
        for (MoveDirection move : moves3) a.move(move);
        assertEquals("Południe, (2,2)", a.toString());
    }


}
