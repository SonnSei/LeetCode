package zero

/**
 * @Classname Solution5
 * @Description TODO
 * @Date 2019/12/21 20:09
 * @Author Cheng
 */

/*
 * 中心扩展法
 */
func longestPalindrome(s string) string {
	if len(s)<2{
		return s
	}
	var left,maxLen int
	for i:=0;i<len(s)-1;i++{
		tempLen1:=getLength(s,i,i)
		tempLen2:=getLength(s,i,i+1)
		if tempLen1>tempLen2{
			tempLen2 = tempLen1
		}
		if tempLen2>maxLen{
			maxLen = tempLen2
			// 这个地方写错过一次
			left = i-(maxLen-1)/2
		}
	}
	return s[left:left+maxLen]
}

func getLength(s string, left int, right int) int {
	for left>=0 && right<len(s) && s[left]==s[right]{
		left--
		right++
	}
	return right-left-1
}

