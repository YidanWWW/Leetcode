import React from 'react';
import ReactDOM from 'react-dom/client';

function Car(props) {
    return <li>I am a {props.Brand}</li>
}

function Garage() {
    const cars = ['BMW', 'Ford'];
    return (
        <div>
            <ul>
                {cars.map((car)=> <Car Brand = {car}/>)}
            </ul>
        </div>
    )
}
export default Garage;