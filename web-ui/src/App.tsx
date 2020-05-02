import React from 'react';

import 'font-awesome/css/font-awesome.css';
import 'font-awesome/scss/font-awesome.scss';

import ControlPanel from './components/ControlPanel';

const appStyle: any = { width:'100vw', height: '100vh' };

function App() {
  return (
    <div style={appStyle}>
      <ControlPanel />
    </div>
  )
}

export default App
