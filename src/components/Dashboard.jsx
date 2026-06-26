import React, { useState } from 'react';
import {Link, useNavigate} from 'react-router-dom';

const Dashboard = () => {
    const navigate = useNavigate();

    return (
        <div className="min-h-full pt-3">
        <header className="relative bg-white shadow-sm">
            <div className="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
                <h1 className="text-3xl font-bold tracking-tight text-gray-900">Your Profile</h1>
            </div>
        </header>
            <main>
                <div className="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">{/* Your content */}</div>
                <p className="mt-10 text-center text-sm/6 text-gray-400">
                    <Link to="/add/product" className="font-semibold text-gray-500 hover:text-gray-600">
                        Dodaj Produkt
                    </Link>
                </p>
            </main>
        </div>
    );
};

export default Dashboard;