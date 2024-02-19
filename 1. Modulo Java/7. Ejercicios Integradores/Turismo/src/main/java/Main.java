import Models.Cliente;
import Models.Producto;
import Repositories.ProductoRepository;
import Enums.ProductNames.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductoRepository productRepository = new ProductoRepository();

        productRepository.create(new Producto(1, 100, "Lujoso Hotel", EnumProductType.RESERVA_HOTEL));
        productRepository.create(new Producto(2, 50, "Lujosa Comida", EnumProductType.COMIDA));
        productRepository.create(new Producto(3, 20, "Lujoso Tiquete", EnumProductType.TICKET));
        productRepository.create(new Producto(4, 30, "Lujoso Carro", EnumProductType.TRANSPORTE));



    }
}