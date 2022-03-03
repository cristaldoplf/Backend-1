public class Clasico extends Menu{

    public Clasico(double precioBase) {
        super(precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase();
    }

    @Override
    public void informarArmadoPedido() {
        System.out.println("Armar menu Clasico");
    }
}
