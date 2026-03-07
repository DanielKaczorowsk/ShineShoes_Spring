import React, { useState, useEffect } from 'react'; // <--- DODAJ TO
import { BrowserRouter as Router, Routes, Route, Link, Navigate, Outlet } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import RegisterForm from "./components/RegisterForm";

const Home = () => <h2>Witaj w naszym sklepie! 🛒</h2>;

const Dashboard = () => {
    return <h2>Panel użytkownika - Tutaj widzisz swoje zamówienia! 📦</h2>;
};
const ProtectedRoute = ({ isLoggedIn }) => {
    if (!isLoggedIn) return <Navigate to="/login" replace />;
    return <Outlet />;
}
function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('token'));

    const handleLogout = () => {
        localStorage.removeItem('token');
        setIsLoggedIn(false);
    };

    return (
        <Router>
            <div className="App">
                <nav style={{ padding: "10px", borderBottom: "1px solid #ccc" }}>
                    <Link to="/"> Start </Link> |

                    {!isLoggedIn && <Link to="/login"> Logowanie </Link>}
                    {!isLoggedIn && <Link to="/register"> Register </Link>}
                    {isLoggedIn && (
                        <>
                            <Link to="/dashboard"> Moje Konto </Link> |
                            <button onClick={handleLogout} style={{ marginLeft: "10px" }}>Wyloguj</button>
                        </>
                    )}
                </nav>

                <div style={{ padding: "20px" }}>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/login" element={<LoginForm onLoginSuccess={setIsLoggedIn} />} />
                        <Route path="/register" element={<RegisterForm />} />

                        <Route element={<ProtectedRoute isLoggedIn={isLoggedIn} />}>
                            <Route path="/dashboard" element={<Dashboard />} />
                        </Route>
                        <Route path="*" element={<h2>Strona nie istnieje (404)</h2>} />
                    </Routes>
                </div>
            </div>
        </Router>
    );
}

export default App;