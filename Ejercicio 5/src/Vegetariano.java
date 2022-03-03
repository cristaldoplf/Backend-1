public class Vegetariano extends Menu{
    private boolean especias;
    private int cantSalsa;

    public Vegetariano(double precioBase, boolean especias, int cantSalsa) {
        super(precioBase);
        this.especias = especias;
        this.cantSalsa = cantSalsa;
    }

    @Override
    public double calcularPrecio() {
        double precio = getPrecioBase();
        if (especias){
            precio= precio*1.01;
        }

        if (cantSalsa>0){
            precio+= cantSalsa*2;
        }

        return precio;
    }

    @Override
    public String informarArmadoPedido() {
        return "Armar menu Vegetariano";
    }
}
