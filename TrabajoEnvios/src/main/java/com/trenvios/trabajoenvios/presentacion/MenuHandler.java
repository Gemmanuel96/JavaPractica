package com.trenvios.trabajoenvios.presentacion;

import com.trenvios.trabajoenvios.model.*;
import com.trenvios.trabajoenvios.service.IEnvioService;
import com.trenvios.trabajoenvios.service.IPedidoService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class MenuHandler {
    private final Scanner scanner;
    private IPedidoService pedidoService;

    public MenuHandler(Scanner scanner, IPedidoService pedidoService) {
        this.scanner = scanner;
        this.pedidoService = pedidoService;
    }

    public void crearPedido() {
        try {
            System.out.println("\n--- CREAR NUEVO PEDIDO CON ENVÍO ---");

            // Datos del pedido
            System.out.print("Número de pedido: ");
            String numero = scanner.nextLine().toUpperCase();

            System.out.print("Nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("Total del pedido: ");
            double total = Double.parseDouble(scanner.nextLine());

            System.out.println("Empresas disponibles: " + Arrays.toString(EmpresaEnvio.values()));
            System.out.print("Empresa de envío: ");
            String empresa = scanner.nextLine().toUpperCase();

            System.out.println("Tipos disponibles: " + Arrays.toString(TipoDeEnvio.values()));
            System.out.print("Tipo de envío: ");
            String tipo = scanner.nextLine().toUpperCase();

            System.out.print("Costo de envío: ");
            double costo = Double.parseDouble(scanner.nextLine());

            // Crear pedido
            Pedido pedido = new Pedido();
            pedido.setNumero(numero);
            pedido.setClienteNombre(cliente);
            pedido.setTotal(total);
            Envio envio = new Envio();

            // generamos uuid para tracking:
            String tracking = UUID.randomUUID().toString();
            envio.setTracking(tracking);

            envio.setEmpresa(EmpresaEnvio.valueOf(empresa));
            envio.setTipo(TipoDeEnvio.valueOf(tipo));
            envio.setCosto(costo);
            envio.setEstado(EstadoDeEnvio.EN_PREPARACION); // valor por defecto


            pedidoService.crearPedidoConEnvio(pedido, envio);
            System.out.println("✓ Pedido creado exitosamente!");

        } catch (Exception e) {
            System.out.println("Error al crear pedido: " + e.getMessage());
        }
    }
}
