import React from 'react';
import { 
    BrowserRouter as Router,
    Routes,
    Route 
} from 'react-router-dom';

import Product from './products';
const Webpages = () => {
    return(
        <Router>
            <Routes>
                <Route exact path="/" component= {Product} />
            </Routes>
        </Router>
    );
};
export default Webpages;