package zero

import "strings"

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2019/12/21 19:39
 * @Author Cheng
 */

func lengthOfLongestSubstring(s string) int {
	ret:=0
	left:=0
	for right,ch:= range s{
		position := strings.Index(s[left:right],string(ch))
		if position>=0{
			left = left+position+1
		}
		if right-left+1>ret {
			ret = right-left+1
		}
	}
	return ret
}