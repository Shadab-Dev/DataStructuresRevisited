# Recursion

## Time and Space complexity

The *time complexity* in a recursive problem will always be the **number of nodes** in the Recursive Tree.

The *space complexity* in a recursive problem will always be the **height** of the Recursive Tree.

Videos explaining time and space complexity of a recursive problem: [Link1](https://www.youtube.com/watch?v=2l3cSfE885g&list=PLjkkQ3iH4jy82KRn9jXeFyWzvX7sqYrjE&index=4) [Link2](https://www.youtube.com/watch?v=BYCeh76OASc&list=PLDzeHZWIZsTqBmRGnsCOGNDG5FY0G04Td&index=11)

Article for space and time complexity along with must solve questions:  [Link](https://www.codingninjas.com/codestudio/guided-paths/competitive-programming/content/126222/offering/1476042)

## Notes for specific questions
- [Pow(x,n)](https://leetcode.com/problems/powx-n/): A better way to solve this problem would be to calculate pow(x,n/2) * pow(x, n/2). This would give us the total answer but in limited time and space complexity since the recursion stack will only contain elements till n/2 and not n. The time and space complexity reduces to logN for this apporach. We also need to handle few edge cases:
    - `negative values of n`: To handle this we can change x to 1/x and n to -(n/2). 
    - `integer overflow`: This can be avoided if we negate the value of n and then divide it by 2
    - `even and odd values of n`: We need to check if n is even, then we return func * func else we return x * func * func

###    
- [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/): Simple question that can be solved using linear recursion, but we would need to thing of few things when solving this:
    - `Write down all the edge cases`: This is a problem which has multiple edge cases. Write them down before submitting the problem.
    - `Use Java constructs for validations`: Use **Character.isLetter**, **Character.isDigit** and **Character.toLowerCase** to check for char specific validations
    - `Use char array for iteration`: Instead of iterating over the string, use **s.toCharArray** to convert to char array.

###
- [Subsets](https://leetcode.com/problems/subsets/): A classic problem on recursion which emphasized the **Input Output Method** of solving recursive problems. Few points to note when solving this problem
    - `Add a copy of output to result`: In the base condition when index is at the end of nums, make sure that we make a copy of output and then add it to result. Since output is being changed at each recursion stack, we must not use the same list.
    - `Remove the added element from output`: There are two recursion calls in each step of the stack, so after picking the index elem at first call, we need to remove it from output so that the next recursion calls does not contain previous picked element
    - `Time and Space Complexity`: Since the height of the recursion tree is n, therefore space complexity is **O(n)**, Time complexity is **O(2^n)** since there are two decisions in each recursion stack.

###
- [Permutations](https://leetcode.com/problems/permutations/): Another classic question that teaches the importance of backtracking as well as using loops inside the recursive functions. Few points to note:
    - `Avoiding duplicates`: Since the loop will take elements which are right to the index, therefore we will avoid all duplicates. If we were to swap all the elements from 0 to n-1, then we would get duplicates
    - `Backtracking`: It is very important to swap back the changes that we did in order to create a new permutation so that the next stack gets a fresh nums array.
    - `Time and Space complexity`: Space complexity will be **O(n)** since the recursion tree will have a height of n. Time complexity will be **O(n*n!)** since there are n! permutations and each permutation is of size n. 

###
- [Permutations II](https://leetcode.com/problems/permutations-ii/): The idea is to only get the unique permuations. We can do that by the following steps:
    - `Use a HashSet`: We can use a set to keep track of the elements which have already been swapped at the current index. If an integer has already been swapped, we skip it by doing continue in the for loop.
    - `Time and Space complexity`: It will be similar to the previous question as the worst case can contain all unique integers. There will be a slight increase in space complexity as we are using a set in each recursion stack. But the worst case space complexity will still be **O(n)**