# Phone decoder

## Prompt

Write a program in Java that’ll accept a phone number with letters and convert it to a phone number with only digits.
For example, if you sent the program a phone number like 800888TEST, it should return (800) 888-8378.

Note that it shouldn't only convert letters to the digits they represent but also format the number correctly with
parentheses and dashes. And, if you send the program an invalid number, it should throw an error.

## Solution

Implemented a phone decoder. It ignores all invalid characters, then map letters to the correct numbers using the index
of an array. Finally, applies the expected format to the phone number.

If the phone number does not have the expected length, then an error is showed.

The main class receives an array of phone numbers to format.