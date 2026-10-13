package br.edu.uninter.baozi.controller;
import br.edu.uninter.baozi.model.Cliente;
import br.edu.uninter.baozi.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/clientes") public class ClienteController {
private final ClienteRepository repo; 
public ClienteController(ClienteRepository repo){this.repo=repo;}
@PostMapping public ResponseEntity<Cliente> criar(@RequestBody Cliente obj){obj.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(obj));}
@GetMapping public List<Cliente> listar(){return repo.findAll();}
@GetMapping("/{id}") public ResponseEntity<Cliente> buscar(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
@DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
