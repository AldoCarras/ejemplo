package grupo2.inf391;

/**
 * Created by ALDO on 7/5/2017.
 */

public class Modelo {
    protected String modelo;
    protected long id;

    public Modelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
