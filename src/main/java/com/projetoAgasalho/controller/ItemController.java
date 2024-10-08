package com.projetoAgasalho.controller; 
 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
 
import com.projetoAgasalho.entity.Item; 
import com.projetoAgasalho.services.ItemService; 
 
import jakarta.validation.Valid;  
@RestController  
@RequestMapping("/item")  
public class ItemController {  

	private final ItemService itemService;  
	@Autowired  
	public ItemController(ItemService itemService) {  
		this.itemService = itemService;  
	}  
	  
	@GetMapping("/{id}")  
	public ResponseEntity<Item> buscaItemControlId(@PathVariable Long id){  
		Item item = itemService.buscaItemId(id);  
		if(item != null) {  
			return ResponseEntity.ok(item);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@GetMapping  
	public ResponseEntity<List<Item>> buscaTodosItemsControl(){  
		List<Item> items = itemService.buscaTodosItems();  
		return ResponseEntity.ok(items);  
	}  
	@PostMapping  
	public ResponseEntity<Item> salvaItemsControl(@RequestBody @Valid Item item){  
		Item salvaItem = itemService.salvaItem(item);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItem);  
	}  
	  
	@PutMapping("/{id}")  
	public ResponseEntity<Item> alteraItemControl(@PathVariable Long id, @RequestBody @Valid Item item){  
		Item alteraItem = itemService.alterarItem(id, item);  
		if(alteraItem != null) {  
			return ResponseEntity.ok(item);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	 
	@DeleteMapping("/{id}")  
	public ResponseEntity<String> apagaItemControl(@PathVariable Long id){  
		boolean apagar = itemService.apagarItem(id);  
		if (apagar) {  
			return ResponseEntity.ok().body("O Item foi excluido com sucesso");  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
} 