//timer:
setTimeout(callback, delay);

function setTimeoutPromise(delay) {
    return new Promise((resolve, reject) => {
      if (delay < 0) return reject("Delay must be greater than 0")
  
      setTimeout(() => {
        resolve(`You waited ${delay} milliseconds`)
      }, delay)
    })
}

doStuff()
async function doStuff() {
    const msg1 = await setTimeoutPromise(250)
    console.log(msg1)
    console.log("First Timeout")

    const msg2 = await setTimeoutPromise(500);
    console.log(msg2);
    console.log("Second Timeout")
}

//catch error
doStuff()
async function doStuff() {
    try {
        const msg = await setTimeoutPromise(-10)
        console.log(msg)
    }catch(error) {
        console.error(error)
    }
    console.log("outside")
}
// Output:
// Delay must be greater than 0
// Outside

async function httpRequest(method, data) {
    const url = 'http://example.com';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: data? JSON.stringify(data):undefined
    }

    try{
        const response = await fetch(url, options);
        if(!response.ok) {
            throw new Error('ERROR');
        }
        const responseData = response.json();
        console.log(responseData);
    }catch (error) {
        console.error(error);
    }
}

performHttpRequest('GET');
performHttpRequest('POST', { key: 'value' });