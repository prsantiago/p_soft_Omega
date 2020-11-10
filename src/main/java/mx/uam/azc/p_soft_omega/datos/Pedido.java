package mx.uam.azc.p_soft_omega.datos;

import java.util.ArrayList;

/**
 *
 * @author Omega
 */
public class Pedido {
    
    private String _clave;
    private String _claveCliente;
    private ArrayList<Producto> _claveProducto;
    private ArrayList<Integer> _cantidadProducto;
    private int _total;

    public Pedido(String clave, String claveCliente, int total) {
        this._clave = clave;
        this._claveCliente = claveCliente;
        this._claveProducto = new ArrayList<Producto>();
        this._cantidadProducto = new ArrayList<Integer>();
        this._total = total;
    }
    
    public Pedido() {
        this._claveProducto = new ArrayList<Producto>();
        this._cantidadProducto = new ArrayList<Integer>();
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
        return _claveProducto.get(index);
    }

    public void setClaveProducto(Producto _claveProducto) {
        this._claveProducto.add(_claveProducto);
    }

    public int getCantidadProducto(int index) {
        return _cantidadProducto.get(index);
    }

    public void setCantidadProducto(int _cantidadProducto) {
        this._cantidadProducto.add(_cantidadProducto);
    }
    
    public int getSizeProductos() {
        return this._claveProducto.size();
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


