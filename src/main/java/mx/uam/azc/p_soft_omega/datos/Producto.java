package mx.uam.azc.p_soft_omega.datos;

/**
 *
 * @author Omega
 */
public class Producto {
    
    private String _clave;
    private String _nombre;
    private int _cantidad;
    private int _precio;

    public Producto(String clave, String nombre, int cantidad, int precio) {
        this._clave = clave;
        this._nombre = nombre;
        this._cantidad = cantidad;
        this._precio = precio;
    }

    public Producto() {
    }

    public String getClave() {
        return _clave;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public int getPrecio() {
        return _precio;
    }

    public void setPrecio(int _precio) {
        this._precio = _precio;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Producto [_clave=");
        builder.append(_clave).append('\n');
        builder.append(", _nombre=");
        builder.append(_nombre).append('\n');
        builder.append(", _cantidad=");
        builder.append(_cantidad).append('\n');
        builder.append(", _precio=");
        builder.append(_precio);
        builder.append("]\n");
        return builder.toString();
    }
    
}
