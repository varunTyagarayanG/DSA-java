### Power Set Generation Approach

The code generates the power set of an array using a recursive backtracking approach. Here's how it works:

#### 1. **Recursive Function (`helper` method):**
   - The function explores two possibilities at each index:
     1. **Include the current element in the subset.**
     2. **Exclude the current element from the subset.**
   - The recursion continues until it reaches the end of the array, at which point the current subset is added to the result list.

#### 2. **Base Case:**
   - When the index `idx` equals the length of the array (`n`), the current subset (`preAns`) is added to the list of all subsets (`ans`). This represents one possible subset in the power set.

#### 3. **Tree Diagram:**
   The tree diagram below illustrates how the recursion unfolds for an example array, say `[1, 2, 3]`.

```               
                 []
                /  \
              /      \
            /          \
         [1]            []
        /   \           / \
      /       \        /   \
   [1,2]      [1]     [2]   []
   /   \     /   \    / \   / \

```



- **Root Node (`[]`)**: Start with an empty subset.
- **First Level**:
  - Include the first element `1` → Left branch leads to `[1]`.
  - Exclude the first element `1` → Right branch leads to `[]`.
- **Second Level**:
  - For each subset generated in the previous level, decide to include or exclude the next element `2`.
  - This creates further branches, expanding the tree.
- **Third Level**:
  - Finally, decide to include or exclude the last element `3`.
  - This results in all possible subsets (including the empty set and the full set), which represent the power set.

#### 4. **Final Result:**
   - The leaves of the tree represent all the possible subsets:
     - `[1,2,3]`, `[1,2]`, `[1,3]`, `[1]`, `[2,3]`, `[2]`, `[3]`, `[]`
