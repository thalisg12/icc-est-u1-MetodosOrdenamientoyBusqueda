import controllers.Controlador;
import controllers.MetodosBusqueda;
import controllers.MetodosOrdenamiento;
import views.View;

public class App {
    public static void main(String[] args) {
        View vista = new View();
        MetodosOrdenamiento ordenamiento = new MetodosOrdenamiento();
        MetodosBusqueda busqueda = new MetodosBusqueda();
        Controlador controlador = new Controlador(vista, ordenamiento, busqueda);
        controlador.iniciar();
    }
}
