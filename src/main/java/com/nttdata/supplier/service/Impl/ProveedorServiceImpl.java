package com.nttdata.supplier.service.Impl;

import com.nttdata.supplier.model.Proveedor;
import com.nttdata.supplier.repository.ProveedorRepository;
import com.nttdata.supplier.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void registroProveedor(Proveedor proveedor) throws Exception {
        Proveedor proveedorLocal = proveedorRepository.findByNroDocumento(proveedor.getNroDocumento());
        if (proveedorLocal != null) {
            throw new Exception("El proveedor se encuentra registrado!");
        }
        proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception {
        Optional<Proveedor> proveedorLocal = proveedorRepository.findById(proveedor.getIdProveedor());

        if (proveedorLocal.isEmpty()) {
            throw new Exception("EL proveedor no se encuentra registrado!");
        }

        return proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> listarProveedores() throws Exception {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor buscarProveedor(int id) throws Exception {
        Optional<Proveedor> op = proveedorRepository.findById(id);
        return op.isPresent() ? op.get() : new Proveedor();
    }
}
