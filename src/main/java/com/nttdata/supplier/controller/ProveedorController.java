package com.nttdata.supplier.controller;


import com.nttdata.supplier.model.Proveedor;
import com.nttdata.supplier.service.ProveedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Proveedor p) {

        try {
            LOGGER.info(String.format("Registro de Proveedor -> %s", p.toString()));
            proveedorService.registroProveedor(p);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizar(@RequestBody Proveedor p) throws Exception {
        try {
            LOGGER.info(String.format("Actualizacion de Proveedor -> %s", p.toString()));
            Proveedor proveedor = proveedorService.actualizarProveedor(p);
            return ResponseEntity.ok(proveedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Proveedor> buscar(@RequestParam("id") int id) throws Exception {
        LOGGER.info(String.format("Buscar de Proveedor"));
        return ResponseEntity.ok(proveedorService.buscarProveedor(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Proveedor>> listar() throws Exception {
        LOGGER.info(String.format("Listar Proveedor"));
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

}
