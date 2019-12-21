package zero

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2019/12/21 19:14
 * @Author Cheng
 */

func twoSum(nums []int, target int) []int {
	myMap:=make(map[int]int)
	for i,v := range nums{
		value,ok:=myMap[target-v]
		if ok{
			return []int{i,value}
		}
		myMap[v]=i;
	}
	return []int{};
}