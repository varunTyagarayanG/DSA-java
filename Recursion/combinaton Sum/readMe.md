# Combination Sum Intuition

## Problem Statement

Given an array of distinct integers `candidates` and a target integer `target`, return all unique combinations in `candidates` where the chosen numbers sum to `target`. Each number in `candidates` may be used an unlimited number of times. The combinations can be returned in any order.

## Intuition

To solve this problem, we can use a **backtracking** approach, which allows us to explore all possible combinations of the elements in the array to achieve the target sum.

### Key Concepts

1. **Backtracking**:

   - Backtracking is a recursive technique where we build a solution incrementally, adding candidates one by one to the current combination.
   - If at any point the current combination exceeds the target sum or we reach the end of the array, we backtrack by removing the last added element and try the next possibility.

2. **Combination Exploration**:

   - We start with an index and attempt to include the element at this index in the current combination.
   - We then subtract this element's value from the target and recursively search for the remaining sum using the updated target.
   - If the updated target becomes zero, it means we have found a valid combination, which we then add to the result set.

3. **Decision Points**:
   - At each recursive step, we have two main decisions to make:
     1. **Include the current element**: Subtract its value from the target and continue exploring combinations from the same index (since the element can be reused).
     2. **Exclude the current element**: Move to the next index and explore combinations without the current element.

### Example Walkthrough

Consider the example with `candidates = [2, 3, 6, 7]` and `target = 7`.

1. **Starting at Index 0 (Element = 2)**:

   - We can include `2` multiple times:
     - Include `2`: Target becomes `5`.
     - Include `2` again: Target becomes `3`.
     - Include `2` again: Target becomes `1`.
     - Including `2` once more would exceed the target, so we backtrack.

2. **Exploring Other Combinations**:

   - After backtracking, we explore other combinations by excluding the last added `2` and including the next candidate, `3`.
   - By combining `2` and `3`, we eventually find a valid combination `[2, 2, 3]` that sums to `7`.

3. **Single Element Combination**:
   - Additionally, we explore the possibility of using the element `7` directly, which also forms a valid combination `[7]`.

```
                                                        [ ] (sum = 7)
                                                         /             \
                                                +2                              (skip 2)
                                                /                                  \
                                 [2] (sum = 5)                             [ ] (sum = 7)
                                   /               \                           /               \
                                 +2             (skip 2)                    +3             (skip 3)
                                 /                   \                       /                   \
                      [2, 2] (sum = 3)       [2] (sum = 5)         [3] (sum = 4)       [ ] (sum = 7)
                        /         \             /        \            /         \          /          \
                      +2     (skip 2)     +3  (skip 3)   +3    (skip 3)   +7     (skip 7)
                      /              \        /           \       /            \      /             \
           [2, 2, 2] (sum = 1) [2, 2] (sum = 3) [2, 3] (sum = 2) [3, 3] (sum = 1) [7] (sum = 0) [ ] (sum = 7)
                /          \               /           \         /           \        \
              +2       (skip 2)      +3  (skip 3)   +3  (skip 3)  (skip)  (valid)
              /               \       /              \       /             \
 [2, 2, 2, 2] (sum = -1) [2, 2, 2] (sum = 1) [2, 3, 3] (sum = -1) [3, 3, 3] (sum = -2)
  (invalid)          (valid)           (invalid)        (invalid)


```

### Conclusion

Backtracking efficiently explores all possible combinations by making a series of choices—whether to include or exclude an element—at each step. This approach ensures that we find all valid combinations without missing any possibilities. By recursively exploring these options and backtracking when necessary, we build up the set of all unique combinations that sum to the target.
