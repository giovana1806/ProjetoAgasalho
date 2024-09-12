
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
	$.getJSON('/ponto', function(data) {  
		$('#guestTableBody').empty();  
		data.forEach(guest => {  
			$('#guestTableBody').append(  
				`<tr>  
					<td>${guest.id}</td>  
					<td>${guest.pontoColeta}</td> 
					<td>${guest.item.nome}</td>    
					<td>  
						<button class="btn btn-sm btn-warning" onclick="showEditGuestForm(${guest.id}, '${guest.pontoColeta}', '${guest.item.id}')">Edit</button>  
						<button class="btn btn-sm btn-danger" onclick="deleteGuest(${guest.id})">Delete</button>  
					</td>  
				</tr>`  
			);  
		});  
	});  
}  
function showAddGuestForm() {  
	$('#formTitle').text('Add ponto');  
	$('#guestId').val('');  
	$('#guestPontoColeta').val('');  
	$('#guestItem').val(''); 
	$('#guestFormModal').show();  
}  
function showEditGuestForm(id, pontoColeta, item) {  
	$('#formTitle').text('Edit Reserva');  
	$('#guestId').val(id);  
	$('#guestPontoColeta').val(pontoColeta);  
	$('#guestItem').val(item);; 
	$('#guestFormModal').show();  
}  
function closeGuestForm() {  
	$('#guestFormModal').hide();  
}  
function addGuest() {  
	const guest = {    
		pontoColeta: $('#guestPontoColeta').val(), 
		item: {id:$('#guestItem').val()}  
	};  
	$.ajax({  
		url: '/ponto',  
		type: 'POST',  
		contentType: 'application/json',  
		data: JSON.stringify(guest),  
		success: function() {  
			closeGuestForm();  
			loadGuests();  
		}  
	});  
}  
function updateGuest(id) {  
	const guest = {    
		pontoColeta: $('#guestPontoColeta').val(), 
		item: {id:$('#guestItem').val()}
	};  
	$.ajax({  
		url: `/ponto/${id}`,  
		type: 'PUT',  
		contentType: 'application/json',  
		data: JSON.stringify(guest),  
		success: function() {  
			closeGuestForm();  
			loadGuests();  
		}  
	});  
}  
function deleteGuest(id) {  
	if (confirm('Realmente vai deletar?')) {  
		$.ajax({  
			url: `/ponto/${id}`,  
			type: 'DELETE',  
			success: function() {  
				loadGuests();  
			}  
		});  

	}  
} 
 