package mx.uam.azc.p_soft_omega.datos;

/**
 *
 * @author Omega
 */
public class Pedido {
    
    private String _clave;
    private String _claveCliente;
    private Producto[] _claveProducto;
    private int[] _cantidadProducto;
    private int _total;

    public Pedido(String clave, String claveCliente, int total) {
        this._clave = clave;
        this._claveCliente = claveCliente;
        this._claveProducto = new Producto[100];
        this._cantidadProducto = new int[100];
        this._total = total;
    }
    
    public Pedido() {
    }

    public String getClave() {
        return _clave;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
    }

    public String getClaveCliente() {
        return _claveCliente;
    }

    public void setClaveCliente(String _claveCliente) {
        this._claveCliente = _claveCliente;
    }

    public Producto getClaveProducto(int index) {
        return _claveProducto[index];
    }

    public void setClaveProducto(Producto _claveProducto, int index) {
        this._claveProducto[index] = _claveProducto;
    }

    public int getCantidadProducto(int index) {
        return _cantidadProducto[index];
    }

    public void setCantidadProducto(int _cantidadProducto, int index) {
        this._cantidadProducto[index] = _cantidadProducto;
    }

    public int getTotal() {
        return _total;
    }

    public void setTotal(int _total) {
        this._total = _total;
    }
    
    /**
    * Validar los datos de un pedido antes de insertar o modificar
    * @param pedido A not-null instancia de Pedido
    * @return Un boleano que indica que los valores de Pedido son validos
    */
    private boolean validarPedido(Pedido pedido) {
        if(pedido==null || pedido.getClave()==null || pedido.getClaveCliente()==null ||
           pedido.getTotal() <= 0)
            return false;

        for (int i=0; i<5; ++i) {
            if(pedido.getClaveProducto(i) == null || 
               pedido.getCantidadProducto(i) <= 0)
                return false;
        }

        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pedido [_clave=");
        builder.append(_clave).append('\n');
        builder.append(", _claveCliente=");
        builder.append(_claveCliente).append('\n');
        builder.append(", _total=");
        builder.append(_total);
        builder.append("]\n");
        return builder.toString();
    }
}


