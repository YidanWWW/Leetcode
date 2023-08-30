const ppp = new Promise((resolve, reject) => {
    setTimeout(()=> {
        resolve('a')
    }, 1000)
}).then(res=> {
    console.log('res1', res)
    return new Promise(resolve=>resolve(res+'a'))
}).then(res=> {
    console.log('res', res)
    return new Promise(resolve=>resolve(res+'a'))
}).then(res=> {
    console.log('res3',res)
})
//a, aa, aaa

//simplify: ignore inner promise
function one () {
    return new Promise(resolve => {
        doSomething()
        resolve()
    })
}

function two () {
    return new Promise(resolve => {
        doAnotherThing()
        resolve()
    })
}

function three () {
    return new Promise(resolve => {
        doSomethingElse()
        resolve()
    })
}

one()
.then(()=> {
    return two();
})
.then(()=> {
    return three();
})
.then(()=> {
    console.log("complete")
})

//promise all

Promise.all([one(), two()])
.then(message => {
    console.log(message)
})
.catch(error => {
    //
})

//timer 的例子
const fetchDate = new Promise((resolve, reject)=> {
    setTimeout(()=> {
        const data = {name : 'Ruby', age: 23};
        resolve(data);

        reject('Error');
    }, 1000)
})

// Using the promise
fetchData
    .then(result => {
        console.log('Data fetched:', result);
    })
    .catch(error => {
        console.error('Error:', error);
    });



//非timer的例子
const promise = new Promise((resolve, reject)=> {
    const success = isWork();
    if(success) {
        resolve();
    }else{
        reject();
    }
})
//use promise
promise
.then(()=> {
    console.log("Success")
})
.catch(()=> {
    console.log("Error")
})

const promise1 = new Promise((resolve, reject)=> {
    const ifSuccess = true;
    if(ifSuccess) {
        resolve();
    }else {
        reject();
    }
})

promise1.then(()=> {
    console.log('Succcess');
}).catch(()=> {
    console.log('Failure')
})