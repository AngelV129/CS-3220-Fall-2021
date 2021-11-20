function max1(arr) {
    let max = arr[0];

    for (let index = 1; index < arr.length; index++) {
        if (max < arr[index]) {
            max = arr[index];
        }
        
    }
    return max;
}

function max2(arr) {
    let max = arr[0];

    arr.forEach(element => {
        if (max < element) {
            max = element;
        }
    });
    return max;
}

function max3(arr) {
    const reducer = (prev, currentValue) => {
        // console.log(`prev is ${prev} and curr is ${currentValue}`);

        if (prev < currentValue) {
            return prev = currentValue;
        }
        else return prev
    };

    let max = arr.reduce(reducer);

    return max;
}



let array = [3,5,4,12,6,5];

console.log(`max1 value is ${max1(array)}`);
console.log(`max2 value is ${max2(array)}`);
console.log(`max2 value is ${max3(array)}`);