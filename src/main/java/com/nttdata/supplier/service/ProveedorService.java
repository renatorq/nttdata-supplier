package com.nttdata.supplier.service;

import com.nttdata.supplier.model.Proveedor;

import java.util.List;

public interface ProveedorService {

    void registroProveedor(Proveedor proveedor) throws Exception;
    Proveedor actualizarProveedor(Proveedor proveedor) throws Exception;
    List<Proveedor> listarProveedores() throws Exception;

    Proveedor buscarProveedor(int id) throws Exception;

}
