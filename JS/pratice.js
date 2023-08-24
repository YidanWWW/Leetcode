//forEach method: could not return a new array
let arr = [1,2,3,4,5];
arr.forEach((element, index) => {
    arr[index] = element+1;
})
console.log(arr);

// arr.forEach((element) => {
//     element.key = element.key+1;
// })

//map method: could return a new array
let arr2 = [1,2,3,4,5];
const arr3 = arr2.map((element) => {
    return element+1;
}).reverse();
console.log(arr3);


//fetch api:
import {useState} from 'react';

const App=()=> {
    const [isLoading, setIsLoading] = useState(false);
    const handleClick = async () => {
        setIsLoading(true);
        try {
            const response = await fetch('http....');
            if(response.ok)
        }
    }
}
