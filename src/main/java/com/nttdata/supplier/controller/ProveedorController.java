package com.nttdata.supplier.controller;


import com.nttdata.supplier.model.Proveedor;
import com.nttdata.supplier.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Proveedor p) {

        try {
            proveedorService.registroProveedor(p);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizar(@RequestBody Proveedor p) throws Exception {
        try {
            Proveedor proveedor = proveedorService.actualizarProveedor(p);
            return ResponseEntity.ok(proveedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Proveedor> buscar(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(proveedorService.buscarProveedor(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Proveedor>> listar() throws Exception {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

}
