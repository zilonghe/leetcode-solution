# 28.Implement strStr()

## strStr
### Question

- leetcode: [Implement strStr() | LeetCode OJ](https://leetcode.com/problems/implement-strstr/)
- lintcode: [lintcode - (13) strstr](http://www.lintcode.com/en/problem/strstr/)

#### Problem Statement

For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return `-1`.

##### Example

If source = `"source"` and target = `"target"`, return `-1`.

If source = `"abcdabcdefg"` and target = `"bcd"`, return `1`.

##### Challenge

O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: `KMP`)

##### Clarification

Do I need to implement KMP Algorithm in a real interview?

- Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure your confirm with the interviewer first.