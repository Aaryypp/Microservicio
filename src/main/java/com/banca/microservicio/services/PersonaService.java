package com.banca.microservicio.services;

import com.banca.microservicio.model.Persona;
import com.banca.microservicio.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public Persona buscaP(String dni) {
        return personaRepository.findByDni(dni);
    }

    public String nombreCompl(String dni) {
        Persona persona = personaRepository.findByDni(dni);
        return persona.getNombre() + " " + persona.getApellido();
    }
}