/**
 * Problem: 1352. Product of the Last K Numbers
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/product-of-the-last-k-numbers/
 */

class ProductOfNumbers {
    List<Integer>products;
    int lastZero;
    public ProductOfNumbers() {
        products=new ArrayList<>();
        lastZero=-1;
    }
    
    public void add(int num) {
        int l=products.size();
        if(num!=0){
            if(l==0)products.add(num);
            else products.add(num*products.get(l-1));
        }
        else{
            lastZero=l;
            products.add(1);
        }
    }
    
    public int getProduct(int k) {
        int l=products.size();
        int last=l-k-1;
        if(lastZero>last)return 0;
        if(last==-1)return products.get(l-1);
        return products.get(l-1)/products.get(last);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
