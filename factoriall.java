function factorial(n) {
  if (n === 0) {          // base condition
    return 1;
  }
  return n * factorial(n - 1);  // recursive call
}

console.log(factorial(5)); // 120
