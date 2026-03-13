public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private char tipo;
    
    public Carro() {
        this.id = -1;
        this.modelo = "";
        this.marca = "";
        this.tipo = '*';
    }
    
    public Carro(int id, String modelo, String marca, char tipo) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Carro [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", tipo=" + tipo + "]";
    }    
}