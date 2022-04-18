let check = function() {
    if (document.getElementById('passwordInput').value ===
        document.getElementById('confirmPasswordInput').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Passwords match!';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Passwords do not match';
    }
}