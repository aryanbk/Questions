# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         m, n = len(nums1), len(nums2)
#         if m>n:
#             return self.findMedianSortedArrays(nums2, nums1)
#         half = (m+n)//2
#         l, r = 0, m
        
#         while l<=r:
#             mid = (l+r)//2
#             mid2 = half - mid - 1
#             if mid2+1<n and nums1[mid]>nums2[mid2+1]:
#                 r=mid-1
#             elif mid+1<m and nums2[mid2]>nums1[mid+1]:
#                 l=mid+1
#             else:
#                 return min(nums1[mid], nums2[mid2]) if (m+n)%2==1 else (nums1[mid] + nums2[mid2])/2


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        cmb = [0]*(m+n)
        i=j=0
        while i<m and j<n:
            if nums1[i]>nums2[j]:
                cmb[i+j] = nums2[j]
                j+=1
            else:
                cmb[i+j] = nums1[i]
                i+=1
        while i<m:
            cmb[i+j]=nums1[i]
            i+=1
        while j<n:
            cmb[i+j]=nums2[j]
            j+=1
        return cmb[(m+n)//2] if (m+n)%2==1 else (cmb[(m+n)//2]+cmb[((m+n)//2)-1])/2