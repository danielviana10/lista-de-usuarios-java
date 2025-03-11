document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/postgresql-connector/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: `email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}`
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.token);

            console.log('Login bem-sucedido. Redirecionando para /persons...');
            window.location.href = '/postgresql-connector/persons';
        } else {
            document.getElementById('message').innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Credenciais inválidas. Tente novamente.
                </div>
            `;
        }
    } catch (error) {
        console.error('Erro durante o login:', error);
        document.getElementById('message').innerHTML = `
            <div class="alert alert-danger" role="alert">
                Erro ao conectar ao servidor. Tente novamente.
            </div>
        `;
    }
});