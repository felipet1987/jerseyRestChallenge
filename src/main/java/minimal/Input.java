package minimal;

/**
 * Created by felipe on 19/12/2016.
 */
public  class Input {

    String data;

    public Input() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Input{" +
                "data='" + data + '\'' +
                '}';
    }
}
