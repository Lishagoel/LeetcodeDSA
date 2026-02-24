impl Solution {
  pub fn minimum_array_length(nums: Vec<i32>) -> i32 {
    let mut m = *nums.iter().min().unwrap();
    for &v in &nums {
      if v % m != 0 {
        return 1;
      }
    }
    
    let mut cnt = 0;
    for v in nums {
      if v == m {
        cnt += 1;
      }
    }

    return (cnt + 1) / 2;
  }
}