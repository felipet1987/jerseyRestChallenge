package minimal;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.TimeZone;

import static junit.framework.Assert.assertEquals;


/**
 * Trivial test class. Demonstrates the syntax of JUnit4.
 * Important: Do NOT inherit this class from TestCase() or JUnit3.x is enforced
 *
 * @author Sascha Tayefeh
 */
public class DoSomeActionTest extends JerseyTest {




    @Override
    protected Application configure() {
        return new ResourceConfig(HelloResource.class);
    }

    @Ignore
    @Test
    public void helloTest() {
        final String hello = target("hello").request().get(String.class);
        assertEquals("Hello World!", hello);
    }

    @Ignore
    @Test
    public void PostTest() {

        Input input = new Input();
        input.setData("Hello");

        Entity<Input> entity = Entity.entity(input, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("post").request().post(Entity.json(input));

        assertEquals("Hello", response.readEntity(Input.class).getData());

    }
    @Test
    public void devolverMayusculasTest() {

        Word input = new Word();
        input.setPalabra("hola");

        Entity<Word> entity = Entity.entity(input, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("word").request().post(Entity.json(input));

        Respuesta output = new Respuesta();
        output.setCode("00");
        output.setDescription("OK");
        output.setData("HOLA");

        Respuesta resultado = response.readEntity(Respuesta.class);

        assertEquals(output.getDescription(), resultado.getDescription());
        assertEquals(output.getCode(), resultado.getCode());
        assertEquals(output.getData(), resultado.getData());


    }

    @Test
    public void devolverHoraTest() throws ParseException {

        Response response = target("time").queryParam("value", "20:15:30").request().get();


        Respuesta output = new Respuesta();
        output.setCode("00");
        output.setDescription("OK");
        output.setData("1970-01-01:08:15:00:0");

        Respuesta resultado = response.readEntity(Respuesta.class);

        assertEquals(output.getDescription(), resultado.getDescription());
        assertEquals(output.getCode(), resultado.getCode());
        assertEquals(output.getData(), resultado.getData());


    }


}


