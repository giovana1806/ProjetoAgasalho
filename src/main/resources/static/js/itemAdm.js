
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
					<td>  
						<button class="btn btn-sm btn-warning" onclick="showEditGuestForm(${guest.id}, '${guest.nome}', '${guest.descricao}')">Edit</button>  
						<button class="btn btn-sm btn-danger" onclick="deleteGuest(${guest.id})">Delete</button>  
					</td>  
				</tr>`  
			);  
		});  
	});  
}  
function showAddGuestForm() {  
	$('#formTitle').text('Add item');  
	$('#guestId').val('');  
	$('#guestNome').val('');  
	$('#guestDescricao').val('');
	$('#guestFormModal').show();  
}  
function showEditGuestForm(id, nome, descricao) {  
	$('#formTitle').text('Edit Item');  
	$('#guestId').val(id);  
	$('#guestNome').val(nome);  
	$('#guestDescricao').val(descricao);
	$('#guestFormModal').show();  
}  
function closeGuestForm() {  
	$('#guestFormModal').hide();  
}  
function addGuest() {  
	const guest = {  
		nome: $('#guestNome').val(),  
		descricao: $('#guestDescricao').val()
	};  
	$.ajax({  
		url: '/item', 
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
		nome: $('#guestNome').val(),  
		descricao: $('#guestDescricao').val()
	};  
	$.ajax({  
		url: `/item/${id}`,  
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
			url: `/item/${id}`,  
			type: 'DELETE',  
			success: function() {  
				loadGuests();  
			}  
		});  
	}  
} 