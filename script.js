const button = document.getElementById('clickBtn');
const message = document.getElementById('message');

button.addEventListener('click', () => {
    const now = new Date();
    message.textContent = `Button clicked at: ${now.toLocaleTimeString()}`;
});
