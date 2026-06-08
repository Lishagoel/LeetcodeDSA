impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        let mut result = vec![0; nums.len()];
        let mut left = 0;
        let mut right = nums.len() - 1;

        for (i, j) in (0..nums.len()).zip((0..nums.len()).rev()) {
            if nums[i] < pivot {
                result[left] = nums[i];
                left += 1;
            }

            if nums[j] > pivot {
                result[right] = nums[j];
                right -= 1;
            }
        }

        while left <= right {
            result[left] = pivot;
            left += 1;
        }

        result
    }
}