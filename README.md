# leetcode，sorting...

| #    | Title                                | Solution |
| ---- | ------------------------------------ | -------- |
| 1    | [两数之和](#jump1) | Java     |
| 2    | [两数相加](#jump2) |    Java      |
| 3    | [无重复字符的最长子串](#jump3)       |    Java      |
| 4    | [寻找两个有序数组的中位数](#jump4)   |    Java      |
| 5    | [最长回文子串](#jump5)               |    Java      |

## <span id="jump1">1.两数之和</span>

### 题目描述

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

<b>示例：</b>

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

链接：https://leetcode-cn.com/problems/two-sum

### 解决方法

方法一：暴力解法

遍历数组中的每个元素x，查找target-x；

代码略；

时间复杂度 *O(n2)* ,空间复杂度*O(1)*

方法二：遍历哈希表

遍历数组 中的每个元素x，索引i，判断map中是否存在 target-x 的 值，不存在就将元素及索引添加到map中，
继续遍历直到找到为止

```java
public int[] twoSum(int[] nums, int target) {
        int[] numIndex=new int[2];
		HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(hashmap.get(target-nums[i])==null) {
				hashmap.put(nums[i], i);
			}else {
				numIndex[0]=hashmap.get(target-nums[i]);
				numIndex[1]=i;
			}
                  		}
    return numIndex;
    }
```

时间复杂度*O(n)*，空间复杂度*O(n)*

## <span id="jump2">2.两数相加</span>

### 题目描述

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

链接：https://leetcode-cn.com/problems/add-two-numbers

### 解决方法

思路：可以看做左边第一个数相加，>10则向右进一；

```java
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);
        ListNode curr=temp;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0){
            curr=new ListNode(carry);
        }
        return temp.next;
}
```

时间复杂度*O(max(m,n))*，空间复杂度*O(max(m,n))*，m、n为两个链表的长度

## <span id="jump3">3.无重复字符的最长子串</span>

### 题目描述

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

### 解决方法

```java
public int lengthOfLongestSubstring(String s) {
        int max=0,left=0; 
		 for(int i=1;i<s.length();i++) {
			 for(int j=left;j<i;j++) 
				 if(s.charAt(i)==s.charAt(j)) {
                     left=j+1;
                     break;
				 }
                     if(i-left+1>max) max=i-left+1;
             } 
		 return max==0?s.length():max;
    }
```



## <span id="jump4">4.寻找两个有序数组的中位数</span>

## <span id="jump5">5.最长回文子串</span>
