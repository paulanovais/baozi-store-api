package br.edu.uninter.baozi.controller;
import br.edu.uninter.baozi.model.Pedido;
import br.edu.uninter.baozi.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/pedidos") public class PedidoController {
private final PedidoRepository repo; private final ClienteRepository clientes; private final ProdutoRepository produtos;

public PedidoController(PedidoRepository repo, ClienteRepository clientes, ProdutoRepository produtos){this.repo=repo;this.clientes=clientes;this.produtos=produtos;}
@PostMapping public ResponseEntity<Pedido> criar(@RequestBody Pedido obj){obj.setId(null);if (obj.getQuantidade()==null || obj.getQuantidade()<=0 || obj.getClienteId()==null || obj.getProdutoId()==null) return ResponseEntity.badRequest().build();
if (!clientes.existsById(obj.getClienteId()) || !produtos.existsById(obj.getProdutoId())) return ResponseEntity.badRequest().build(); return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(obj));}
@GetMapping public List<Pedido> listar(){return repo.findAll();}
@GetMapping("/{id}") public ResponseEntity<Pedido> buscar(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
@DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
