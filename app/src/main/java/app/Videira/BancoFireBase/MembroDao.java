package app.Videira.BancoFireBase;

public class MembroDao {
    private String id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String idade;
    private String batizado;

    public MembroDao(String id,String nome,String email,String telefone,String idade,String endereco,String batizado ){
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.idade = idade;
    this.endereco = endereco;
    this.batizado = batizado;
    }

    public MembroDao() {

    }

    public String  getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getBatizado() {
        return batizado;
    }

    public void setBatizado(String batizado) {
        this.batizado = batizado;
    }

    @Override
    public String toString() {
        return   nome+ email+ telefone+ idade+ endereco+ batizado;
    }
}
