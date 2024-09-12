package com.projetoAgasalho.services; 
 
import java.util.List; 
import java.util.Optional; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import com.projetoAgasalho.entity.Item; 
import com.projetoAgasalho.repository.ItemRepository; 
@Service  
public class ItemService {  
	private final ItemRepository itemRepository;  
	@Autowired  
	public ItemService(ItemRepository itemRepository) {  
		this.itemRepository = itemRepository;  
	}  
	public List<Item> buscaTodosItems(){  
		return itemRepository.findAll();  
	}  
	public Item buscaItemId(Long id) {  
		Optional <Item> existeItem = itemRepository.findById(id);  
		return existeItem.orElse(null);  
	}  
	public Item salvaItem(Item item) {  
		return itemRepository.save(item);		  
	}  
	public Item alterarItem(Long id, Item alterarItem) {  
		Optional <Item> existeItem = itemRepository.findById(id);  
		if (existeItem.isPresent()) {  
			alterarItem.setId(id);;  
			return itemRepository.save(alterarItem);  
		}  
		return null;  
	}  
	public boolean apagarItem(Long id) {  
		Optional <Item> existeItem = itemRepository.findById(id);  
		if (existeItem.isPresent()) {  
			itemRepository.deleteById(id);  
			return true;  
		}  
		return false;  
	}  
} 