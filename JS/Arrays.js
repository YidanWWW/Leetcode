//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/every

//shift : delete first element
const array1 = [1,2,3];
const firstElement = array1.shift(); //delete first element

//concat: merge array
const array2 = ['a','b','c'];
const array3 = ['d','e'];
const newArray = array2.concat(array3)

//every: test if all elements in the array pass the test
const isBelowThreshold = (current) => current<40;
const array4 = [1,30,43,6,23];
console.log(array1.every(isBelowThreshold)); //false

//fill: change elements within a range of indices in an array
const array5 = [1,2,3,4];
console.log(array5.fill(6)); //[6,6,6,6]

//filter: create a shallow copy, 
//filter down to just the element pass the test
const words = ['abc', 'a', 'ab','abcd'];
const result = words.filter((word)=>word.length>2);
console.log(result); //['abc','abcd']

//find: return the first element that pass the test
//if no value satisfythe testing function, return -1
const array6 = [5,12,8,130,23];
const found = array6.find((element)=>element>10);
console.log(found); //12


//at: find the corresponding element
array6.at(2); //8

//map, flatmap
const arr1 = [1,2,3,4];
arr1.map((element)=>[element*2]); //[[2],[4],[6],[8]]
arr1.map((element)=>[element*2]); //[2,4,6,8]

const arr2 = [[1,2],3,4];
arr2.flat(arr2);

//slice
const arr3=['a','b','c','d'];
arr3.slice(0,2); //['a', 'b'] [start, end)

//reduce : return the sum 
const arr4 = [1,2,3,4];
const init = 2;
arr4.reduce((accumulator, current)=>accumulator+current, init);

//join 
const elements = ['Fire', 'Air', 'Water'];
elements.join() //"Fire,Air,Water"
elements.join('') //"FireAirWater"
element.join('-') // "Fire-Air-Water"


