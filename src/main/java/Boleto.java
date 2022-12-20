public class Boleto {
    
    private float valor;
    private BoletoEstado estado;

    public Boleto() {
        this.estado = BoletoEstadoCriado.getInstance();
    }
    
    public void setEstado(BoletoEstado estado) {
        this.estado = estado;
    }
    
    public boolean criar() {
        return estado.criar(this);
    }
    
    public boolean pagar() {
        return estado.pagar(this);
    }
    
    public boolean vencer() {
        return estado.vencer(this);
    }
    
    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public BoletoEstado getEstado() {
        return estado;
    }    
}
