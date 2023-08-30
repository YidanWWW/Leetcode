function resolve () {
    return new Promise((resolve) => {
        setTimeout(()=> {
            resolve('resolved');
        }, 2000)
    })
}

async function resolve1 () {
    console.log('calling');
    const result = await resolve();
    console.log(result);
}

resolve1();