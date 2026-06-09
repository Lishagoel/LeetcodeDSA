use itertools::{Itertools, MinMaxResult::{MinMax}};

impl Solution {
    pub fn max_total_value(nums: Vec<i32>, k: i32) -> i64 {
        match nums.into_iter().minmax() {
            MinMax(x, y) => (k as i64) * ((y - x) as i64),
            _ => 0i64
        }
    }
}