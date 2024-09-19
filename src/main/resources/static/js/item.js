
$(document).ready(function() {  
	loadGuests();  
	$('#guestForm').submit(function(event) {  
		event.preventDefault();  
		const id = $('#guestId').val();  
		if (id) {  
			updateGuest(id);  
		} else {  
			addGuest();  
		}  
	});  
});  
function loadGuests() {  
	$.getJSON('/item', function(data) {  
		$('#guestTableBody').empty();  
		data.forEach(guest => { 
			$('#guestTableBody').append(  
				`<tr>  
					<td>${guest.id}</td>  
					<td>${guest.nome}</td>  
					<td>${guest.descricao}</td>  
				</tr>`  
			);  
		});  
	});  
} 