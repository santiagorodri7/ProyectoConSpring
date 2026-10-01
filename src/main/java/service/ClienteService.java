package service;

import models.MCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public MCliente crearCliente(MCliente c){
        return clienteRepository.save(c);
    }
    public List<MCliente> listarClientes(){
        return clienteRepository.findAll();
    }
    public MCliente buscarClientePorId(Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("El cliete con la id: " + id + " no existe"));
    }
    public MCliente actualizarCliente(Integer id, MCliente actualizado){
        MCliente c = buscarClientePorId(id);
        c.setNombre(actualizado.getNombre());
        c.setCorreo(actualizado.getCorreo());
        c.setDirreccion(actualizado.getDirreccion());
        c.setPedidos(actualizado.getPedidos());
        c.setTelefono(actualizado.getTelefono());
        return clienteRepository.save(c);


    }
    public void eliminarCliente(Integer id){
        MCliente c = buscarClientePorId(id);
        clienteRepository.delete(c);
    }
}
