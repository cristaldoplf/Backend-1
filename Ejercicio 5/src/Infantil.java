public class Infantil extends Menu{
    private int cantJuguetes;

    public Infantil(double precioBase, int cantJuguetes) {
        super(precioBase);
        this.cantJuguetes = cantJuguetes;
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()+cantJuguetes*3;
    }

    @Override
    public void informarArmadoPedido() {
        System.out.println("Armar menu Infantil");
    }
}
