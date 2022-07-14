# Is prime

## Prompt
Write a Java program to determine whether a number is prime or not. This program should accept an array of numbers. It should iterate through the array of numbers and determine if each is prime or not. Once it’s done processing, it should return only those numbers that are prime in an array.

## Solution
Wrote a function that filters the input array using an stream.

The function that determines if a number is prime or not, computes ans stores all possible prime numbers between zero and an upper limit. If the number that is required to evaluate is greater than the upper limit, then the prime number storage is extended and prime numbers are computed again.

One of the implementations provided sorts the input array before filtering it. That proved to increase the performance by ~900% when calculating very big prime numbers repeatedly.