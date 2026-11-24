# [3411. Maximum Subarray With Equal Products](https://leetcode.com/problems/maximum-subarray-with-equal-products/)

![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen)

**Topics:** `Array` `Math` `Sliding Window` `Enumeration` `Number Theory`

---

## Problem Statement

You are given an array of **positive** integers `nums`.

An array `arr` is called **product equivalent** if `prod(arr) == lcm(arr) * gcd(arr)`, where:

	
- `prod(arr)` is the product of all elements of `arr`.
	
- `gcd(arr)` is the GCD of all elements of `arr`.
	
- `lcm(arr)` is the LCM of all elements of `arr`.

Return the length of the **longest** **product equivalent** subarray of `nums`.

 

**Example 1:**

**Input:** nums = [1,2,1,2,1,1,1]

**Output:** 5

**Explanation:** 

The longest product equivalent subarray is `[1, 2, 1, 1, 1]`, where `prod([1, 2, 1, 1, 1]) = 2`, `gcd([1, 2, 1, 1, 1]) = 1`, and `lcm([1, 2, 1, 1, 1]) = 2`.

**Example 2:**

**Input:** nums = [2,3,4,5,6]

**Output:** 3

**Explanation:** 

The longest product equivalent subarray is `[3, 4, 5].`

**Example 3:**

**Input:** nums = [1,2,3,1,4,5,1]

**Output:** 5

 

**Constraints:**

	
- `2 <= nums.length <= 100`
	
- `1 <= nums[i] <= 10`

### Submission Stats

| Metric | Result | Percentile |
| :--- | :--- | :--- |
| **Language** | `Java` | - |
| **Runtime** | `2
ms` | - |
| **Memory** | `43.65
MB` | - |

---

### Solution Explanation

<!-- LLM_EXPLANATION_START -->
> *Automated AI explanation will be generated here in future updates.*
<!-- LLM_EXPLANATION_END -->
