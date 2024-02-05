import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponents from './components/HeaderComponents'
import FooterComponent from './components/FooterComponent'
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'

function App() {


  return (
    <>
    <BrowserRouter>
    <HeaderComponents/>
    <Routes>
      <Route path='/' element ={<ListEmployeeComponent/>}></Route>
      <Route path='/employee' element ={<ListEmployeeComponent/>}></Route>
      <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>
    </Routes>
     <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
