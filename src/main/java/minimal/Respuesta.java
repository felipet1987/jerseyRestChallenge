package minimal;

/**
 * Created by felipe on 21/12/2016.
 */
public class Respuesta {
    String Code;
    String Description;
    String Data;

    public Respuesta() {

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
