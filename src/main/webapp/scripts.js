//Actualiza la cantidad del producto
function updateQuantity(id, increment) {
    const quantityInput = document.getElementById(`quantity-${id}`);
    if (!quantityInput) {
        console.error(`Elemento con ID 'quantity-${id}' no encontrado`);
        return;
    }

    let currentValue = parseInt(quantityInput.value) || 0;
    currentValue = increment ? currentValue + 1 : Math.max(0, currentValue - 1);
    quantityInput.value = currentValue;
}

// Añade el producto al carrito
function addToCart(id) {
    const quantityInput = document.getElementById(`quantity-${id}`);
    if (!quantityInput) {
        console.error(`Elemento con ID 'quantity-${id}' no encontrado`);
        return;
    }

    const quantity = parseInt(quantityInput.value) || 0;
    if (quantity > 0) {
        alert(`Producto ${id} añadido al carrito con cantidad: ${quantity}`);
        // Aquí puedes realizar una llamada al servidor o manejar el carrito localmente
    } else {
        alert("Por favor selecciona una cantidad mayor a 0.");
    }
}