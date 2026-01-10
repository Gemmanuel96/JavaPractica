package com.trenvios.trabajoenvios.service;

import com.trenvios.trabajoenvios.model.Envio;
import com.trenvios.trabajoenvios.model.Pedido;
import com.trenvios.trabajoenvios.repository.IEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService implements IEnvioService {

    @Autowired
    private IEnvioRepository envioRepository;

    @Override
    public void save(Envio envio) {
        envioRepository.save(envio);
    }

    @Override
    public Envio findById(Long id) {
        Envio envio = envioRepository.findById(id).orElse(null);
        return envio;
    }

    @Override
    public List<Envio> findAll() {
        List<Envio> listaEnvios = envioRepository.findAll();
        return listaEnvios;
    }

    @Override
    public void delete(Envio envio) {
        envioRepository.delete(envio);
    }

    @Override
    public void update(Envio envio) {

    }
}
