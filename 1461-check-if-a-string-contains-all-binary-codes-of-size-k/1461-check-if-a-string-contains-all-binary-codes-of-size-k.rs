impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        let k = k as usize;
        if s.len() < k {
            return false;
        }

        let total = 1 << k;
        let mut seen = vec![false; total];
        let mut remaining = total;
        let mut mask = 0;
        let all_ones = total - 1;

        for (i, ch) in s.chars().enumerate() {
            mask = ((mask << 1) & all_ones) | (ch as usize - '0' as usize);

            if i >= k - 1 {
                if !seen[mask] {
                    seen[mask] = true;
                    remaining -= 1;
                    if remaining == 0 {
                        return true;
                    }
                }
            }
        }

        false
    }
}