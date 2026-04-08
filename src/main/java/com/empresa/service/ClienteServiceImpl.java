package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@Override
	public Cliente insertaCliente(Cliente objCliente) {
		return ClienteRepository.save(objCliente);
	}
	
}
