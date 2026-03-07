import React, { useState } from 'react';
import { registerUser } from '../api/api'; // Musimy to dopisać w api.js
import { useNavigate } from 'react-router-dom';

const RegisterForm = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [success, setSuccess] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        try {
            await registerUser(name, email, password);
            setSuccess(true);
            setTimeout(() => navigate('/login'), 2000);
        } catch (err) {
            const msg = err.response?.data?.message || 'Błąd rejestracji. Może email jest zajęty?';
            setError(msg);
        }
    };

    if (success) {
        return <div style={{ textAlign: 'center' }}><h3>Zarejestrowano!</h3><p>Przekierowuję do logowania...</p></div>;
    }

    return (
        <div style={{ maxWidth: '300px', margin: 'auto', textAlign: 'center' }}>
            <h3>Utwórz konto</h3>
            <form onSubmit={handleSubmit}>
                <div style={{ marginBottom: '10px' }}>
                    <input type="text" placeholder="Imię" value={name} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <input type="password" placeholder="Hasło" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                {error && <p style={{ color: 'red', fontSize: '12px' }}>{error}</p>}
                <button type="submit">Zarejestruj się</button>
            </form>
            <p style={{ fontSize: '12px', marginTop: '10px' }}>
                Masz już konto? <span style={{ color: 'blue', cursor: 'pointer' }} onClick={() => navigate('/login')}>Zaloguj się</span>
            </p>
        </div>
    );
};

export default RegisterForm;