//1. async/await
import {useState} from 'react';

const App=()=> {
    const [isLoading, setIsLoading] = useState(false);
    const [err, setErr] = useState('');
    const handleClick = async () => {
        setIsLoading(true);
        try {
            const response = await fetch('http....');
            if(!response.ok){
                throw new Error(...);
            }
            const result = await response.json();

            
        }catch (err) {
            setErr(err.message);
        }finally {
            setIsLoading(false);
        }
    }
}

fetch('http://re.....', {
    method: 'POST', //could be post, delete, get, update
    headers: { //you need to tell fetch that you are going to be passing JSON, so we should pass it an object
        'Content-Type':'application/json'
    }, 
    body: JSON.stringify({ // should get sent up correctly, should send it JSON
        name: 'User1'
    })
}) //fetch URL
.then(response => {
    
    if(response.ok) { //check the status
        console.log('SUCCESS')
    }else {
        console.log("Not Successful")
    }
    return response.json()

}) //convert the response to JSON
.then(data => console.log(data)) //then we use the data
.catch(error => console.log('ERROR')) //catch error

const result = await fetch('http://').then(status).then(json()).then(handleData()).catch().finally()

fetch('http://example...')
.then(response => {
    if(response.ok) {
        console.log("Sucessful")
    }else {
        console.log('Not sucessful')
    }
    return response.json();
})
.then(data => console.log(data)) //handle data
.catch(errot => console.log('Error'))
.finally()

