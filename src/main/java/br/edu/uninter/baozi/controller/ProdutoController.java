package br.edu.uninter.baozi.controller;
import br.edu.uninter.baozi.model.Produto;
import br.edu.uninter.baozi.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/produtos") public class ProdutoController {
private final ProdutoRepository repo; 
public ProdutoController(ProdutoRepository repo){this.repo=repo;}
@PostMapping public ResponseEntity<Produto> criar(@RequestBody Produto obj){obj.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(obj));}
@GetMapping public List<Produto> listar(){return repo.findAll();}
@GetMapping("/{id}") public ResponseEntity<Produto> buscar(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
@DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
