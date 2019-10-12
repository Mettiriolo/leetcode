package com.yang.hard;

public class _004 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m==0){
            return (nums2[n-n/2-1]+nums2[n-(n+1)/2])/2.0;
        }
        if(n==0){
            return (nums1[m-m/2-1]+nums1[m-(m+1)/2])/2.0;
        }
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        int lMax1=0,rMin1=0,lMax2=0,rMin2=0,c1,c2;
        int l=0,r=2*m;
        while(l<=r){
            c1=(l+r)/2;
            c2=m+n-c1;
            lMax1=c1==0?Integer.MIN_VALUE:nums1[(c1-1)/2];
            rMin1=c1==2*m?Integer.MAX_VALUE:nums1[c1/2];
            lMax2=c2==0?Integer.MIN_VALUE:nums2[(c2-1)/2];
            rMin2=c2==2*n?Integer.MAX_VALUE:nums2[c2/2];
            if(lMax1>rMin2) r=c1-1;
            else if(rMin1<lMax2) l=c1+1;
            else break; 
        }
        return (Math.max(lMax1, lMax2)+Math.min(rMin1, rMin2))/2.0;
    }
	 public static void main(String[] args) {
	        int[] nums1={3};
	        int[] nums2={-2,-1}; 
	        double result=new _004().findMedianSortedArrays(nums1,nums2);
	        System.out.println(result);
	    }
}
