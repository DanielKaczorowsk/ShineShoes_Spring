import React, { useState } from 'react';
import { loginUser } from '../api/api';
import { useNavigate } from 'react-router-dom';

const LoginForm = ({onLoginSuccess}) => {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            const data = await loginUser(name, password);
            if (data) {
                localStorage.setItem('token', data);
                onLoginSuccess(data);
                navigate('/dashboard');
            }
        } catch (err) {
            setError('Błąd logowania: Sprawdź dane lub połączenie z serwerem.');
        }
    };

    return (
        <div style={{ maxWidth: '300px', margin: 'auto', textAlign: 'center' }}>
            <h3>Logowanie do Systemu</h3>
            <form onSubmit={handleSubmit}>
                <div style={{ marginBottom: '10px' }}>
                    <input
                        type="text"
                        placeholder="Login"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <input
                        type="password"
                        placeholder="Hasło"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                {error && <p style={{ color: 'red', fontSize: '12px' }}>{error}</p>}
                <button type="submit">Zaloguj się</button>
            </form>
        </div>
    );
};

export default LoginForm;