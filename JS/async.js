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