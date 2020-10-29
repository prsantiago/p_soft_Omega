package mx.uam.azc.p_soft_omega.datos;

/**
 *
 * @author Omega
 */
public class Cliente {
    
    private String _clave;
    private String _nombre;
    private String _telefono;
    private String _direccion;
    
    public Cliente() {
    }
    
    public Cliente(String clave, String nombre, String telefono, String direccion) {
        _clave = clave;
        _nombre = nombre;
        _telefono = telefono;
        _direccion = direccion;
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

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente [_clave=");
        builder.append(_clave).append('\n');
        builder.append(", _nombre=");
        builder.append(_nombre).append('\n');
        builder.append(", _telefono=");
        builder.append(_telefono).append('\n');
        builder.append(", _direccion=");
        builder.append(_direccion);
        builder.append("]\n");
        return builder.toString();
    }
}
