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