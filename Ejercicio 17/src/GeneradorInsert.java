public class GeneradorInsert {
    public String insertEmpleado(Empleado empleado){
        return "INSERT INTO EMPLEADO VALUES(" + empleado.getId() + ",'" + empleado.getNombre() + "'," + empleado.getEdad() + ",'" + empleado.getEmpresa() + "','"+empleado.getFechaComienzo() + "');\n";
    };
}
