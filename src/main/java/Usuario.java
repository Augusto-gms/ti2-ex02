public class Usuario {
    private int codigo;
    private String nome;
    private String sobrenome;
    private char sexo;
    
    public Usuario() {
        this.codigo = -1;
        this.nome = "";
        this.sobrenome = "";
        this.sexo = '*';
    }
    
    public Usuario(int codigo, String nome, String sobrenome, char sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", sexo=" + sexo + "]";
    }    
}