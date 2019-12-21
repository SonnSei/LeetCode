package zero

/**
 * @Classname Solution4
 * @Description TODO
 * @Date 2019/12/21 19:48
 * @Author Cheng
 */
const INT_MAX = int(^uint(0) >> 1)
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	len1 := len(nums1)
	len2 := len(nums2)
	p1 := (len1+len2+1)/2
	p2 := (len1+len2+2)/2
	v1:= getKthFromTowArray(nums1,0,nums2,0,p1)
	v2:= getKthFromTowArray(nums1,0,nums2,0,p2)
	return float64(v1 + v2)/2
}

func getKthFromTowArray(nums1 []int, start1 int,nums2 []int ,start2 int, k int) int {
	if start1>=len(nums1) {
		return nums2[start2+k-1]
	}
	if start2>=len(nums2) {
		return nums1[start1+k-1]
	}
	if k == 1 {
		if nums1[start1]<nums2[start2]{
			return nums1[start1]
		}
		return nums2[start2]
	}
	var v1,v2 int
	if start1+k/2-1<len(nums1){
		v1 = nums1[start1+k/2-1]
	}else{
		v1 = INT_MAX
	}
	if start2+k/2-1<len(nums2){
		v2 = nums2[start2+k/2-1]
	}else {
		v2 = INT_MAX;
	}
	if v1<=v2{
		return getKthFromTowArray(nums1,start1+k/2,nums2,start2,k-k/2)
	}else {
		return getKthFromTowArray(nums1,start1,nums2,start2+k/2,k-k/2)
	}
}