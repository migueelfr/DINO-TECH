public class Cliente extends Pessoa {
    private String email;

    public Cliente(String usuario, String senha, String email) {
        super(usuario, senha);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}
