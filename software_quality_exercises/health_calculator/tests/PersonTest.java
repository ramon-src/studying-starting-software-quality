
import org.junit.Assert;
import org.junit.Test;
import Person.Person;
import Person.Genre;

public class PersonTest {

    @Test
    public void getFemGenreFromANewPerson(){
        Person resultedPerson = new Person("FEM", 1.65, 56.0);
        Genre expectedGenre = Genre.FEM;
        Assert.assertEquals(expectedGenre.name(), resultedPerson.getGenre());
    }
}
