package com.nttdata.supplier.repository;

import com.nttdata.supplier.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    Proveedor findByNroDocumento(String nroDocumento);

}
