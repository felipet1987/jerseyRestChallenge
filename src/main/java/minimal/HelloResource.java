package minimal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by felipe on 19/12/2016.
 */

@Path("/")
public class HelloResource {

    @GET
    @Path("hello")
    public String getHello() {
        return "Hello World!";
    }


    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  doPost(Input data) {

        Input output = data;

        return Response.status(200).entity(output).build();

    }
    @POST
    @Path("word")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  devolverMayusculas(Word input) {

        Respuesta output = new Respuesta();
        output.setCode("00");
        output.setDescription("OK");
        output.setData(transformar(input.getPalabra()));

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("time")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  devolverHora(@QueryParam("value") String hora) throws ParseException {

        Respuesta output = new Respuesta();
        output.setCode("00");
        output.setDescription("OK");
        output.setData(transformarHora(hora));

        return Response.status(200).entity(output).build();

    }

    private String transformar(String palabra) {
        return palabra.toUpperCase();
    }
    private String transformarHora(String hora) throws ParseException {

        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        final java.util.Date dateObj = sdf.parse(hora);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   // This line converts the given date into UTC time zone
        String aRevisedDate = new SimpleDateFormat("YYYY-MM-DD:hh:mm:ss:s").format(dateObj);

        return aRevisedDate;
    }




}
