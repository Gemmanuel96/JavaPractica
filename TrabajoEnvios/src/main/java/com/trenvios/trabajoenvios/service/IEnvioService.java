package com.trenvios.trabajoenvios.service;

import com.trenvios.trabajoenvios.model.Envio;

import java.util.List;

public interface IEnvioService {

    public void save(Envio envio);
    public Envio findById(Long id);
    public List<Envio> findAll();
    public void delete(Envio envio);
    public void update(Envio envio);

}
