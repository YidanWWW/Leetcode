//1. useState
//2. useEffect
//3. useContext
//4. useReducer 
//5. useMemo
//6. useCallBack

import React, {useState} from React

function conter() {
    const [count, setCount] = useState("");

    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={()=> setCount(count +1)}>Add</button>
        </div>
    )
}

//useEffect [<function>, <dependency>] perform side effects
//