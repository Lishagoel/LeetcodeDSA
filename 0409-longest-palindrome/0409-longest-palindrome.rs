impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        s.len() as i32 - s.as_bytes().iter()
            .fold(0u64, |mask, c| mask ^ (1u64 << (c - b'A')))
            .count_ones()
            .saturating_sub(1) as i32
    }
}