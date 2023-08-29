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


//concat() merge 2 or more arrays
const array1 = [1,2,3];
const array2 = [4,5,6];
const array3 = [7,8,9];
const array4 = array1.concat(arr2, arr3);




